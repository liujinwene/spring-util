package com.abc.database.enums;

import lombok.Getter;

/**
 * 触发事件表状态 zk_trigger_event
 * Created by liujinwen on 2018-07-24
 */
@Getter
public enum TriggerEventStatus {
    UN_TRIGGER(0, "未触发"),
    TRIGGERED(1, "已触发"),
    EXPIRED(2, "已失效"),
    CANCELLED(3, "已撤销");

    private int code;
    private String desc;

    TriggerEventStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
