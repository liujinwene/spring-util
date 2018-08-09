package com.abc.dto.content.detail;

import com.abc.dto.content.detail.sub.FlightTicketInfo;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * ContentDetail service_type=1 国内机票预订
 * Created by liujinwen on 2018-07-25
 */
@Builder
@Data
public class FlightInfo {
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String flightNum;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String airlineName;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String fromCityName;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String fromCityID;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String toCityName;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String toCityID;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String transitCityName;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String departureAirport;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String landingAirport;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String aircraftType;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String departureTime;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String landingTime;
    @Field(type = FieldType.Float, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private Float sailingTime;
    @Field(type = FieldType.Nested, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private List<FlightTicketInfo> ticketInfo;
    @Field(type = FieldType.Float, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private Float userRating;
    @Field(type = FieldType.Integer, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private Integer salesVolume;
}
