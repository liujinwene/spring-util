package com.abc.controller;

import com.abc.dto.content.Content;
import com.abc.util.EsRepository;
import com.abc.util.RespUtil;
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
@RequestMapping("/es")
public class ElasticSearchControler {

    @Autowired
    private EsRepository esRepository;


    @RequestMapping("/publish")
    public JSONObject publish() {
        Content esContent = new Content();
        esContent.setId("123");
        esContent.setApp_id("456");
        esContent.setService_id("789");
        esRepository.save(esContent);

        return RespUtil.getOkResult();
    }
}
