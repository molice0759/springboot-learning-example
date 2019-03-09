package com.molice.response;

public class ExecuteResponse<T> {

	/** 是否成功标识 */
	private boolean success;
	/** 业务级错误信息 */
	private String exceptionMessage;
	/** 异常堆栈详细信息 */
	private String exceptionStack;
	/** 结果信息 */
	private T returnObject;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionStack() {
		return exceptionStack;
	}

	public void setExceptionStack(String exceptionStack) {
		this.exceptionStack = exceptionStack;
	}

	public T getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(T returnObject) {
		this.returnObject = returnObject;
	}

}

