package com.lollipop.candy.common.exception;

/**
 * 限流异常
 * @author bear
 */
public class LimitAccessException extends Exception {

	private static final long serialVersionUID = 7763387479264934326L;

    /**
     * LimitAccessException
     * 
     * @param message
     * @return message
     */
	public LimitAccessException(String message) {
        super(message);
    }
    
	/**
     * LimitAccessException异常
     * 
     * @param message
     * @param cause
     * @return message
     */
    public LimitAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}