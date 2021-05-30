package com.lwcx.common.code;

import lombok.Data;

/**
 * 返回结果枚举类
 * @author 陈翔
 */

public enum ResponseCode {

    //系统返回码从200~10000
    SUCCESS(200, "SUCCESS"),
    ERROR(201, "ERROR"),
    TIME_OUT(300, "响应超时"),

    //业务相关从10000开始自增
    INVALID_REQUEST(10000, "不支持的请求方式"),

    //用户相关 (20000自增)
    //用户相关（20000自增）
    REQUEST_PARAM_ERROR(20000, "传入参数错误"),
    REGISTER_TYPE_ERROR(20001, "不支持的注册类型"),
    INVALID_SIGN(20002, "签名无效"),
    USER_LOGIN_EXIST(20003, "用户已存在"),
    USER_LOGIN_NOT_EXIST(20008, "用户不存在"),
    PASSWORD_ERROR(20009, "用户名或密码错误"),
    INVALID_TOKEN(20010, "无效token"),
    INVALID_LOGIN(20011, "登录失效，重新登录"),
    PASSWORD_SAME(20017, "密码重复"),
    OLD_PASSWORD_ERROR(20018, "密码错误，不能修改"),
    LOGIN_FAIL(20024, "登录失败"),
    VISITOR_REGISTER_FAIL(20025, "游客注册失败"),
    TOKEN_EXIST(20033, "token重复"),
    LOGIN_TYPE_EXIST(20034, "登录方式已存在"),
    USER_PROFILE_SEARCH_ERROR(20035, "用户查询失败"),
    USER_PROFILE_LOCK(20036, "用户已锁定"),
    ACCOUNT_SEARCH_FAIL(20037, "账号查询失败"),
    LOGIN_NAME_TYPE_ERROR(20038, "登录名不为空时，登录方式不能为空"),
    PASSWORD_SIMPLE_ERROR(20042, "密码错误，长度应为6-18，包含字母、数字和特殊字符"),
    PASSWORD_ERROR_MORE_THAN(20043,"用户名密码连续错误已达5次，请15分钟后再试"),
    LOGIN_TYPE_ERROR(20044, "不支持的登录类型"),
    SERVICE_UNAVAILABLE(50000, "操作失败，请重试");
    /**
     * code 返回码
     */
    private final int code;
    /**
     * desc 结果描述
     */
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
