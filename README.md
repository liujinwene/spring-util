# spring-util
spring一些常用功能


## FastJson
com.abc.config.FastJsonConfigurer


## elasticsearch
com.abc.config.ElasticsearchConfigurer
com.abc.controller.ElasticSearchControler
http://localhost:8090/es/publish


## kafka
com.abc.config.KafkaConfigurer
com.abc.controller.KafkaController
http://localhost:8090/kafka/send


## Mybatis
com.abc.config.MybatisConfigurer
com.abc.database.mapper.ZkTriggerEventMapper
com.abc.controller.MybatisController
http://localhost:8090/mybatis/save


## 拦截器、过滤器
com.abc.config.ZkWebMvcConfigurer


## 请求和响应stream数据copy
com.abc.Interceptor.MyHttpInterceptor
com.abc.Interceptor.filter.MyHttpFilter
com.abc.Interceptor.wrapper.MyHttpRequestWrapper
com.abc.Interceptor.wrapper.MyHttpResponseWrapper


## 工厂设计模式
com.abc.handler.service.ServiceFactory
com.abc.handler.service.ServiceHandler
com.abc.handler.service.impl.FlightHandler
com.abc.controller.GetContentController


## 统一异常拦截
com.abc.Interceptor.ExceptionAdvice


## 定时任务
com.abc.task.TriggerEventTask
