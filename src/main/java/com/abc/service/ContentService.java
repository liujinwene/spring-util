package com.abc.service;

import com.abc.dto.method.req.GetContentReqDTO;

import java.util.Set;

/**
 * Created by liujinwen on 2018-08-02
 */
public interface ContentService {
    /**
     * 获取内容
     * @param reqDTO
     * @return
     */
    Set<Object> getContent(GetContentReqDTO reqDTO);
}
