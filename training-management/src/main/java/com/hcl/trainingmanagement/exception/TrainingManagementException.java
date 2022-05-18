package com.hcl.trainingmanagement.exception;

public class TrainingManagementException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	private int httpResponceCode;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public int getHttpResponceCode() {
		return httpResponceCode;
	}

	public TrainingManagementException() {
		super();
	}

	public TrainingManagementException(String errorCode, String errorMsg, int httpResponceCode) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.httpResponceCode = httpResponceCode;
	}

}
