package com.abc.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 触发事件定时任务
 * Created by liujinwen on 2018-07-24
 */
@Slf4j
@Component
@Configurable
@EnableScheduling
public class TriggerEventTask {
    /**
     * 定时任务是否正在执行
     */
    private boolean TASK_RUNNING = false;


    /**
     * 每隔5秒，查询触发事件状态
     */
    @Scheduled(cron = "*/5 * *  * * * ")
    public void execute() {
        if (TASK_RUNNING) {
            return;
        }
        TASK_RUNNING = true;
        log.info("start TriggerEventTask");
        log.info("end TriggerEventTask");
        TASK_RUNNING = false;
    }
}
