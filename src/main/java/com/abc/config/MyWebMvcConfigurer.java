package com.abc.config;

import com.abc.Interceptor.MyHttpInterceptor;
import com.abc.Interceptor.filter.MyHttpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web拦截器、过滤器等 配置类
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHttpInterceptor());
    }

    @Bean
    public FilterRegistrationBean myHttpFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        MyHttpFilter myHttpFilter = new MyHttpFilter();
        registration.setFilter(myHttpFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }

}