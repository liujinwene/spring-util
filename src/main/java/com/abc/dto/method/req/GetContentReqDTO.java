package com.abc.dto.method.req;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by liujinwen on 2018-07-30
 */
@Builder
@Data
public class GetContentReqDTO {
    @NotEmpty(message = "service_id不能为空")
    private String service_id;
}
