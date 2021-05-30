package com.lwcx.common.response;

import com.lwcx.common.code.ResponseCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果通用类
 * @author 陈翔
 */
@Data
public class ResultResponse {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造方法私有化
     */
    private ResultResponse() {}

    public static ResultResponse ok() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setSuccess(true);
        resultResponse.setCode(ResponseCode.SUCCESS.getCode());
        resultResponse.setMessage(ResponseCode.SUCCESS.getDesc());
        return resultResponse;
    }

    public static ResultResponse ok(HashMap<String, Object> data) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setSuccess(true);
        resultResponse.setCode(ResponseCode.SUCCESS.getCode());
        resultResponse.setMessage(ResponseCode.SUCCESS.getDesc());
        resultResponse.setData(data);
        return resultResponse;
    }


    public static ResultResponse ok(ResponseCode responseCode) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setSuccess(true);
        resultResponse.setCode(responseCode.getCode());
        resultResponse.setMessage(responseCode.getDesc());
        return resultResponse;
    }

    public static ResultResponse error() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setSuccess(false);
        resultResponse.setCode(ResponseCode.ERROR.getCode());
        resultResponse.setMessage(ResponseCode.ERROR.getDesc());
        return resultResponse;
    }


    public static ResultResponse error(ResponseCode responseCode) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setSuccess(false);
        resultResponse.setCode(responseCode.getCode());
        resultResponse.setMessage(responseCode.getDesc());
        return resultResponse;
    }



    public ResultResponse success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultResponse message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultResponse code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultResponse data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultResponse data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
