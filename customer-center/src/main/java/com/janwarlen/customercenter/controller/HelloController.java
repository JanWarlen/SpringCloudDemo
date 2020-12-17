package com.janwarlen.customercenter.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @author: wangjian
 * @Date: 2020/12/10 15:29
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        System.out.println("hello");
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            headers.put(s, request.getHeader(s));
        }
        return JSONObject.toJSONString(headers);
    }
}
