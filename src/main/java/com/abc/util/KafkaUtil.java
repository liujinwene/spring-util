package com.abc.util;

import com.abc.constant.Settings;
import com.abc.dto.content.req.EventReqDTO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * kafka工具类
 * Created by liujinwen on 2018-07-24
 */
@Slf4j
@Component
public class KafkaUtil {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 推送事件消息到kafka
     * @param eventReqDTO
     * @throws Exception
     */
    public void send(EventReqDTO eventReqDTO) throws Exception {
        String eventId = StringUtil.uuid();
        JSONObject kafkaObj = new JSONObject();
        kafkaObj.put("eventId", eventId);
        kafkaObj.put("eventName", eventReqDTO.getEventId());
        kafkaObj.put("eventType", 1);
        kafkaTemplate.send(Settings.getKafkaEventTopic(), eventId, kafkaObj.toString());
        log.info("send to kafka, topic:{} content:{}", Settings.getKafkaEventTopic(), kafkaObj.toString());
    }

}
