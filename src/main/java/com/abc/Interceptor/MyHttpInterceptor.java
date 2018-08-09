package com.abc.Interceptor;

import com.abc.Interceptor.wrapper.MyHttpRequestWrapper;
import com.abc.Interceptor.wrapper.MyHttpResponseWrapper;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujinwen on 2018-08-02
 */
@Slf4j
public class MyHttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 默认记录后台接口请求日志记录
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String headers = getRequestHeadersStr(request);
        String params = request.getQueryString();
        String requestBody = null;

        if (request instanceof MyHttpRequestWrapper) {
            requestBody = new String(((MyHttpRequestWrapper) request).getBody(), "utf-8");
        }

        log.info("[HTTP请求信息]\nurl:{}\nmethod:{}\nheaders:{}\nparams:{}\nbody:{}",
                url, method, headers, params, requestBody);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (response instanceof MyHttpResponseWrapper) {
            log.info("[HTTP响应信息]:body:{} ", new String(((MyHttpResponseWrapper) response).getBody(), "utf-8"));
        }
    }


    /**
     * 获取请求header字符串
     * @param request
     * @return
     */
    private String getRequestHeadersStr(HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                headerMap.put(name, value);
            }
        }
        if (MapUtils.isNotEmpty(headerMap)) {
            return JSON.toJSONString(headerMap);
        }
        return null;
    }
}
