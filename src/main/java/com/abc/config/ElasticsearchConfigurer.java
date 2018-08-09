package com.abc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by liujinwen on 2018-08-09
 */
@Configuration
@EnableElasticsearchRepositories("com.abc.util")
public class ElasticsearchConfigurer {
}
