package com.abc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liujinwen on 2018-07-27
 */
@Configuration
@MapperScan("com.abc.database.mapper")
public class MybatisConfigurer {
}
