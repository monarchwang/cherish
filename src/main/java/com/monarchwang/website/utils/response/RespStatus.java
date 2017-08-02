/**
 * @author baoyx
 */
package com.monarchwang.website.utils.response;

/**
 *
 */
public interface RespStatus {
	/**
	 * 成功
	 */
	public static final int SUCCESS = 0;

	/**
	 * 失败
	 */
	public static final int FAIL = 1;

	/**
	 * token 失效
	 */
	public static final int TOKEN_INVALID = 1001;

	/**
	 * ....其他的状态
	 */
}
