package com.isv.spi.controllers;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;

@Controller
@RequestMapping(value="/isv")
public class IsvController {
    @Autowired
    private HttpServletRequest request;

    //API密钥ID和私钥，在SaaS服务平台管理后台产品API配置中可以查询到
    private static final String CLIENT_ID = "CLIENT_ID";
    private static final String CLIENT_SECRET = "CLIENT_SECRET";

    /**
     * default action
     * @return
     */
    @RequestMapping(value="")
    @ResponseBody
    public String defaultAction() {
        return generateErrorResponse("wrong action");
    }

    /**
     * 开通服务
     * @return
     */
    @RequestMapping(value="/open", method=RequestMethod.POST)
    @ResponseBody
    public String open(@RequestBody Map<String, String> params, HttpServletRequest request) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("app_id", "abcde12");
        result.put("status", "opened");
        JSONObject outputs = new JSONObject();
        String url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort() + "/isv/ssoLogin";
        outputs.put("url", url);
        result.put("outputs", outputs);
        return generateCorrectResponse(result);
    }

    /**
     * 关闭服务
     * @return
     */
    @RequestMapping(value="/close", method=RequestMethod.POST)
    @ResponseBody
    public String close(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "closed");
        return generateCorrectResponse(result);
    }

    /**
     * 删除服务
     * @return
     */
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

         //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "deleted");
        return generateCorrectResponse(result);
    }

    /**
     * 续费服务
     * @return
     */
    @RequestMapping(value="/renew", method=RequestMethod.POST)
    @ResponseBody
    public String renew(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "opened");
        return generateCorrectResponse(result);
    }

    /**
     * 升级服务
     * @return
     */
    @RequestMapping(value="/change", method=RequestMethod.POST)
    @ResponseBody
    public String change(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "opened");
        return generateCorrectResponse(result);
    }

    /**
     * 创建部门
     * @return
     */
    @RequestMapping(value="/deptCreate", method=RequestMethod.POST)
    @ResponseBody
    public String deptCreate(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "success");
        return generateCorrectResponse(result);
    }

    /**
     * 删除部门
     * @return
     */
    @RequestMapping(value="/deptRemove", method=RequestMethod.POST)
    @ResponseBody
    public String deptRemove(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "success");
        return generateCorrectResponse(result);
    }

    /**
     * 创建用户
     * @return
     */
    @RequestMapping(value="/userAssign", method=RequestMethod.POST)
    @ResponseBody
    public String userAssign(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "success");
        return generateCorrectResponse(result);
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping(value="/userUnassign", method=RequestMethod.POST)
    @ResponseBody
    public String userUnassign(@RequestBody Map<String, String> params) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验signature
        if(!validateSignature(params)) {
            return generateErrorResponse("signature is invalid");
        }

        //3. 处理具体业务逻辑
        //请不要阻塞此接口，若耗时较长，可使用队列做缓冲，设置status="executing"，然后立即返回。
        //..

        //4. 返回结果
        JSONObject result = new JSONObject();
        result.put("status", "success");
        return generateCorrectResponse(result);
    }

    /**
     * 单点登录
     * @return
     */
    @RequestMapping(value = "/ssoLogin", method = RequestMethod.GET)
    @ResponseBody
    public String ssoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String source = request.getParameter("source");

        if (!StringUtils.isEmpty(source)) {
            HttpSession session = request.getSession();
            session.setAttribute("source", source);

            String redirect_uri = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort() + "/isv/callback";
            response.sendRedirect(source + "/oauth/authorize?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + redirect_uri);
        }

        return null;
    }

    /**
     * 单点登录回调
     * @return
     */
    @RequestMapping(value="/callback", method=RequestMethod.GET)
    @ResponseBody
    public String callback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");

        HttpSession session = request.getSession();
        String source = (String) session.getAttribute("source");

        String redirect_uri = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort() + "/isv/callback";

        JSONObject urlJson = new JSONObject();
        urlJson.put("grant_type", "authorization_code");
        urlJson.put("client_id", CLIENT_ID);
        urlJson.put("client_secret", CLIENT_SECRET);
        urlJson.put("redirect_uri", redirect_uri);
        urlJson.put("code", code);
        String token = ApiSignatureUtil.httpPost(source + "/oauth/access_token", urlJson.toJSONString());

        JSONObject json = JSONObject.parseObject(token);
        String access_token = json.getString("access_token");

        urlJson = new JSONObject();
        urlJson.put("client_id", CLIENT_ID);
        urlJson.put("access_token", access_token);
        String data = ApiSignatureUtil.httpPost(source + "/api/user/show", urlJson.toJSONString());

        JSONObject userInfo = JSONObject.parseObject(data);
        String openid = userInfo.getString("openid");
        String account = userInfo.getString("account");

        return "<h1>Hello, " + account + "</h1>";
    }

    /**
     * 校验signature
     * @return
     */
    private boolean validateSignature(Map<String, String> params) {
        String client_id = params.get("client_id");
        String receivedSign = params.get("signature");
        
        if(StringUtils.isEmpty(client_id)) return false;
        if(StringUtils.isEmpty(receivedSign)) return false;
        
        if(!client_id.equals(CLIENT_ID)){
            return false;
        }
        ApiSignatureUtil apiSignatureUtil = new ApiSignatureUtil(CLIENT_SECRET);
        String sign = apiSignatureUtil.sign(params, request.getMethod(), request.getRequestURI());
        return receivedSign.equals(sign);
    }

    /**
     * 返回错误结果
     * @param errorMessage
     * @return
     */
    private String generateErrorResponse(String errorMessage) {
        JSONObject result = new JSONObject();
        result.put("ret", 1);
        result.put("msg", errorMessage);
        return result.toJSONString();
    }

    /**
     * 返回正确结果
     * @return
     */
    private String generateCorrectResponse(JSONObject result) {
        result.put("ret", 0);
        return result.toJSONString();
    }
}
