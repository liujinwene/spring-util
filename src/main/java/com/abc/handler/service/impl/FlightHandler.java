package com.abc.handler.service.impl;

import com.abc.handler.service.ServiceHandler;
import com.abc.handler.service.constant.ServiceIdConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 国内机票预订 处理器
 * Created by liujinwen on 2018-07-19
 */
@Slf4j
@Component
public class FlightHandler implements ServiceHandler {

    @Override
    public String getServiceId() {
        return ServiceIdConstant.FLIGHT;
    }

    @Override
    public Set<Object> search(String intent) {
        Set<Object> contentSet = new HashSet<>();
        contentSet.add("good");
        return contentSet;
    }
}
