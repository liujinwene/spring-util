package com.abc.handler.service;

import java.util.Set;

/**
 * serviceType 处理器 接口定义
 * Created by liujinwen on 2018-07-19
 */
public interface ServiceHandler {
    int MAX_CONTENT_NUM = 100;

    /**
     * 处理器实现类 bean名称 前缀
     */
    String HANDLER_NAME_PREFIX = "ServiceHandler_";


    /**
     * 获取实现类的serviceId值
     * @return
     */
    String getServiceId();
    /**
     * 根据输入参数，查询匹配结果
     * @param intent 可选
     * @return
     */
    Set<Object> search(String intent);
}
