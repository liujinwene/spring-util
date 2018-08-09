package com.abc.dto.content.detail.sub;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 车票信息
 * Created by liujinwen on 2018-07-25
 */
@Builder
@Data
public class FlightTicketInfo {
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String subID;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String departureDate;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String cabinType;
    @Field(type = FieldType.Float, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private Float minPrice;
    @Field(type = FieldType.Float, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private Float maxPrice;
}
