package com.lollipop.candy.common.exception;

/**
 * Redis 连接异常
 * @author bear
 */
public class RedisConnectException extends Exception {

    private static final long serialVersionUID = 1639374111871115063L;

    /**
     * RedisConnectException
     * 
     * @param message
     * @return message
     */
    public RedisConnectException(String message) {
        super(message);
    }
    
	/**
     * RedisConnectException异常
     * 
     * @param message
     * @param cause
     * @return message
     */
    public RedisConnectException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
