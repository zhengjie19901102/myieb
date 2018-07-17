package com.ieb.expect;

/**
 * @Description 用户相关异常
 * @author zhengjie
 *
 */
public class OptionalFaildException extends Exception {
	
	private static final long serialVersionUID = 1L;

	//异常信息
	public OptionalFaildException(String message) {
		super(message);
	}
}
