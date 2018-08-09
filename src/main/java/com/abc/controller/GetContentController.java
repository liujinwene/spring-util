package com.abc.controller;

import com.abc.dto.method.req.GetContentReqDTO;
import com.abc.service.ContentService;
import com.abc.util.RespUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
public class GetContentController {

    @Autowired
    private ContentService contentService;


    @RequestMapping("/get_content")
    public JSONObject getContent() {
        GetContentReqDTO reqDTO = GetContentReqDTO.builder()
                .service_id("10001")
                .build();

        Set<Object> contentSet = contentService.getContent(reqDTO);
        JSONObject retObj = RespUtil.getOkResult();
        retObj.put("contents", JSON.toJSON(contentSet));
        return retObj;
    }

}