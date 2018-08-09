package com.abc.Interceptor.filter;

import com.abc.Interceptor.wrapper.MyHttpRequestWrapper;
import com.abc.Interceptor.wrapper.MyHttpResponseWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liujinwen on 2018-08-02
 */
@Slf4j
public class MyHttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("装饰request.getInputStream和response.getOutputStream");
        ServletRequest requestWrapper = null;
        ServletResponse responseWrapper = null;
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            requestWrapper = new MyHttpRequestWrapper((HttpServletRequest) request);
            responseWrapper = new MyHttpResponseWrapper((HttpServletResponse) response);
        }
        if (null == requestWrapper || null == responseWrapper) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, responseWrapper);
        }
    }

    @Override
    public void destroy() {

    }
}
