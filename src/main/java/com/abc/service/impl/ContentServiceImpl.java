package com.abc.service.impl;

import com.abc.dto.method.req.GetContentReqDTO;
import com.abc.enums.CodeEnum;
import com.abc.exception.MyRuntimeException;
import com.abc.handler.service.ServiceHandler;
import com.abc.handler.service.ServiceFactory;
import com.abc.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by liujinwen on 2018-08-02
 */
@Slf4j
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ServiceFactory serviceStrategy;


    @Override
    public Set<Object> getContent(GetContentReqDTO reqDTO) {
        String serviceId = reqDTO.getService_id();
        ServiceHandler serviceHandler = serviceStrategy.getServiceHandler(serviceId);
        if (serviceHandler == null) {
            log.error("serviceStrategy.getServiceHandler({}) return null.", serviceId);
            throw MyRuntimeException.error(CodeEnum.METHOD_ERROR.getCode(), "指定的handler未定义");
        }
        log.info("serviceStrategy.getServiceHandler({}) return {}", serviceId, serviceHandler.toString());
        return serviceHandler.search(null);
    }
}
