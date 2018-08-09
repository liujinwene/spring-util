package com.abc.dto.content.req;

import lombok.Builder;
import lombok.Data;

/**
 * 事件对象
 * Created by liujinwen on 2018-07-24
 */
@Data
@Builder
public class EventReqDTO {
    private String appId;
    private String accessToken;
    private Integer cardId;
    private String eventId;
    private String cardParam;
    private Long eventTime;
    private Long triggerTime;
    private Long validPeroid;
}
