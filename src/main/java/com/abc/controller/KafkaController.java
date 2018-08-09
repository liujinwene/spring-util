package com.abc.controller;

import com.abc.constant.Settings;
import com.abc.util.RespUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liujinwen on 2018-08-09
 */
@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @RequestMapping("/send")
    public JSONObject send() {
        String id = "123";

        JSONObject kafkaObj = new JSONObject();
        kafkaObj.put("id", id);
        kafkaObj.put("name", "test");
        kafkaObj.put("desc", "hehe");
        kafkaTemplate.send(Settings.getKafkaUserTopic(), id, kafkaObj.toString());
        log.info("send to kafka, topic:{} content:{}", Settings.getKafkaUserTopic(), kafkaObj.toString());

        return RespUtil.getOkResult();
    }
}
