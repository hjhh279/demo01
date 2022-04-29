package com.demo.utils;

/**
 * 
 *@author chinaren
 * @date 2020/11/01
 * @since 1.0
 * 
 *        错误码基类，所有错误码都需要实现此接口
 */
public interface SysErrorCode {

	/**
	 * 错误码
	 *
	 * @return
	 */
	int getCode();

	/**
	 * 错误信息
	 *
	 * @return
	 */
	String getMessage();

}
