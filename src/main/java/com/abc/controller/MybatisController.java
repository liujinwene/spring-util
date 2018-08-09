package com.abc.controller;

import com.abc.database.enums.TriggerEventStatus;
import com.abc.database.mapper.TriggerEventMapper;
import com.abc.database.po.TriggerEvent;
import com.abc.util.RespUtil;
import com.abc.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liujinwen on 2018-08-09
 */
@Slf4j
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private TriggerEventMapper triggerEventMapper;


    @RequestMapping("save")
    public JSONObject send() {
        TriggerEvent zkTriggerEvent = TriggerEvent.builder()
                .id(StringUtil.uuid())
                .event_id("123")
                .status(TriggerEventStatus.UN_TRIGGER.getCode())
                .build();
        triggerEventMapper.insert(zkTriggerEvent);
        return RespUtil.getOkResult();
    }
}
