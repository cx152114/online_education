package com.lwcx.common.exception;


import com.lwcx.common.code.ResponseCode;
import com.sun.org.apache.regexp.internal.RE;

/**
 * 接口服务抛出的异常
 * @author 陈翔
 */
public class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 2963760410777899525L;
	private ResponseCode responseCode;

	public AppRuntimeException() {
		responseCode = ResponseCode.SERVICE_UNAVAILABLE;
		
	}

	public AppRuntimeException(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	public AppRuntimeException(ResponseCode responseCode, String message) {
	    super(message);
	    this.responseCode = responseCode;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

}
