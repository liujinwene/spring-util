package com.abc.dto.content;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "zkes", type = "content")
public class Content implements Serializable {

    @Id
    private String id;
    private String app_id;
    /**
     * 10001-国内机票预订
     * 10002-热门景点
     * 10003-火车票预订
     */
    private String service_id;
    private String content_id;
    private Long valid_time;
    @Field(type = FieldType.Nested, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private Object detail;







}