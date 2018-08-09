package com.abc.util;

import com.alibaba.fastjson.JSONObject;

public abstract class RespUtil {
    private static final int RESULT_OK = 0;
    private static final int RESULT_AUTH_FAILED = 1;
    private static final int RESULT_FORMAT_ERROR = 2;
    private static final int RESULT_SERVER_ERROR = 3;

    public static JSONObject getReqIdObj() {
        JSONObject reqIdObj = new JSONObject();
        reqIdObj.put("req_id", StringUtil.uuid());
        return reqIdObj;
    }

    public static JSONObject getRetObj(int resultCode, String resultMsg) {
        JSONObject retObj = getReqIdObj();
        retObj.put("result_code", resultCode);
        retObj.put("result_msg", resultMsg);
        return retObj;
    }

    public static JSONObject getOkResult() {
        return getRetObj(RESULT_OK, "ok");
    }

    public static JSONObject getAuthFailedResult() {
        return getRetObj(RESULT_AUTH_FAILED, "authorize failed");
    }

    public static JSONObject getAuthFailedResult(String result_msg) {
        return getRetObj(RESULT_AUTH_FAILED, result_msg);
    }

    public static JSONObject getFormatErrorResult() {
        return getRetObj(RESULT_FORMAT_ERROR, "client format error");
    }
    public static JSONObject getFormatErrorResult(String result_msg) {
        return getRetObj(RESULT_FORMAT_ERROR, result_msg);
    }

    public static JSONObject getServerErrorResult() {
        return getRetObj(RESULT_SERVER_ERROR, "server internal error");
    }
    public static JSONObject error(Integer code, String msg) {
        return getRetObj(code, msg);
    }
}
