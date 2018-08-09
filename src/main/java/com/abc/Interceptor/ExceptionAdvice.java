package com.abc.Interceptor;

import com.abc.exception.MyRuntimeException;
import com.abc.util.RespUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 统一异常拦截处理
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public JSONObject onException(Exception e) throws Exception {
        log.error("[ExceptionAdvice.onException]", e);

        JSONObject jsonObject = null;
        if (e instanceof MethodArgumentNotValidException) {
            jsonObject = processMethodArgumentNotValidException((MethodArgumentNotValidException)e);
        } else if (e instanceof MyRuntimeException) {
            MyRuntimeException runtimeException = (MyRuntimeException) e;
            jsonObject = RespUtil.error(runtimeException.getCode(), runtimeException.getMsg());
        } else {
            jsonObject = RespUtil.getServerErrorResult();
        }
        return jsonObject;
    }

    private JSONObject processMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (CollectionUtils.isNotEmpty(fieldErrors) && fieldErrors.get(0) != null) {
            String errorMessage = fieldErrors.get(0).getDefaultMessage();
            return RespUtil.getFormatErrorResult(errorMessage);
        }
        return RespUtil.getFormatErrorResult("参数不合法");
    }
}
