package com.hcl.employee_management_tool.exception;

public class EmployeeNotFoundException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException() {
		super();
	}
	public EmployeeNotFoundException(String errmsg) {
		super(errmsg);
	}

}

