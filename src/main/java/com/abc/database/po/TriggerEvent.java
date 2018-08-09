package com.abc.database.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by liujinwen on 2018-07-24
 */
@Builder
@Data
public class TriggerEvent {
    private String id;
    private Integer status;
    private String event_id;
    private Date create_time;
    private Date update_time;
}
