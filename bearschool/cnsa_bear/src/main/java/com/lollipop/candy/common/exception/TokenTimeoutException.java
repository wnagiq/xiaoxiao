package com.lollipop.candy.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * token过期抛出
 * @author bear
 */
public class TokenTimeoutException extends AuthenticationException {

	private static final long serialVersionUID = -78610695826885041L;

	public TokenTimeoutException(String message) {
        super(message);
    }
}