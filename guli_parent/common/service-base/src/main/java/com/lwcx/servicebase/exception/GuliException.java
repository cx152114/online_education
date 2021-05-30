package com.lwcx.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈翔
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException extends RuntimeException {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;
}
