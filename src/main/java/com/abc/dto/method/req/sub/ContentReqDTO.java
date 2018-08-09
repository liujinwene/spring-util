package com.abc.dto.method.req.sub;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by liujinwen on 2018-07-30
 */
@Builder
@Data
public class ContentReqDTO {
    @NotEmpty(message = "content_id不能为空")
    private String content_id;
    @NotEmpty(message = "op_type不能为空")
    private String op_type;
    @NotNull(message = "valid_time不能为空")
    private Long valid_time;
    @NotNull(message = "detail不能为空")
    private Object detail;
}
