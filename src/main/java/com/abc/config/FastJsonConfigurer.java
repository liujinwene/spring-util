package com.abc.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * FastJson 配置类
 * Created by liujinwen on 2018-07-30
 */
@Configuration
public class FastJsonConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //  自定义配置
        FastJsonConfig config = new FastJsonConfig();
        // 自定义时间格式
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue); // 正常转换 null 值
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }
}
