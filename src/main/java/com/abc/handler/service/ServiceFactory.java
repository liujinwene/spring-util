package com.abc.handler.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据 serviceType 获取 指定的 service 实现类
 * Created by liujinwen on 2018-07-19
 */
@Component
public class ServiceFactory implements ApplicationContextAware {

    private Map<String, ServiceHandler> serviceHandlerMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ServiceHandler> serviceBeanMap = applicationContext.getBeansOfType(ServiceHandler.class);

        serviceHandlerMap = new HashMap<>(serviceBeanMap.size());
        for (ServiceHandler serviceHandler : serviceBeanMap.values()) {
            serviceHandlerMap.put(serviceHandler.getServiceId(), serviceHandler);
        }
    }

    public ServiceHandler getServiceHandler(String serviceId) {
        return serviceHandlerMap.get(serviceId);
    }
}
