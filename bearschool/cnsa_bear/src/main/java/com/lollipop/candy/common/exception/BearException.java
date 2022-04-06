package com.lollipop.candy.common.exception;

/**
 * 运行时异常
 * @author bear
 * @category RunTimeException：运行时异常，又称不受检查异常，不受检查！不受检查！！不受检查！！！重要的事情说三遍，因为不受检查，所以在代码中可能会有RunTimeException时Java编译检查时不会告诉你有这个异常，但是在实际运行代码时则会暴露出来，比如经典的1/0，空指针等。如果不处理也会被Java自己处理。
 */
public class BearException extends RuntimeException {


	private static final long serialVersionUID = 8302409806194198264L;

	/**
     * 异常
     * @param message
     * @param cause
     * @return message
     */
    public BearException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 异常
     * @param message
     * @return message
     */
    public BearException(String message) {
        super(message);
    }
}
