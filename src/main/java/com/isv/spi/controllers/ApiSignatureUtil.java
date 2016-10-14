package com.isv.spi.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class ApiSignatureUtil {
    private static final String UTF8_CHARSET = "UTF-8";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    private SecretKeySpec secretKeySpec = null;
    private Mac mac = null;

    public ApiSignatureUtil(String clientSecret) {
        byte[] secretyKeyBytes;
        try {
            secretyKeyBytes = clientSecret.getBytes(UTF8_CHARSET);
            secretKeySpec = new SecretKeySpec(secretyKeyBytes, HMAC_SHA256_ALGORITHM);
            mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(secretKeySpec);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    
    public String sign(Map<String, String> params, String request_method, String request_uri) {
        params.remove("signature");
        SortedMap<String, String> sortedParamMap = new TreeMap<String, String>(params);
        String canonicalQS = canonicalize(sortedParamMap);
        String toSign = request_method + "\n" + request_uri + "\n" + canonicalQS;
        String hmac = hmac(toSign);
        String sign = percentEncodeRfc3986(hmac);
        return sign;
    }

    private String hmac(String stringToSign) {
        String hmac = null;
        byte[] data;
        byte[] rawHmac;
        try {
            data = stringToSign.getBytes(UTF8_CHARSET);
            rawHmac = mac.doFinal(data);
            Base64 encoder = new Base64();
            hmac = new String(encoder.encode(rawHmac));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
        }
        return hmac;
    }

    public String canonicalize(SortedMap<String, String> sortedParamMap) {
        if (sortedParamMap.isEmpty()) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        Iterator<Map.Entry<String, String>> iter = sortedParamMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> kvpair = iter.next();
            buffer.append(percentEncodeRfc3986(kvpair.getKey()));
            buffer.append("=");
            buffer.append(percentEncodeRfc3986(kvpair.getValue()));
            if (iter.hasNext()) {
                buffer.append("&");
            }
        }
        String canonical = buffer.toString();
        return canonical;
    }

    public String percentEncodeRfc3986(String s) {
        String out = null;
        try {
            if(s != null){
                out = URLEncoder.encode(s, UTF8_CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            out = s;
        }
        return out;
    }
}