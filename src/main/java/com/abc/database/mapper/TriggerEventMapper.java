package com.abc.database.mapper;

import com.abc.database.po.TriggerEvent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 中控触发事件表 mapper
 * Created by liujinwen on 2018-07-24
 */
@Mapper
public interface TriggerEventMapper {
   @Insert("insert into trigger_event(id, status, event_id, create_time, update_time) " +
            "values(#{event.id},#{event.status},#{event.event_id},now(),now())")
    int insert(@Param("event") TriggerEvent event);


}
