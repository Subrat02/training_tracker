package com.hcl.trainingmanagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionError {

	@ExceptionHandler(TrainingManagementException.class)
	public ResponseEntity<TrainingManagementException> handleTrainingManagementException(TrainingManagementException e){
		return ResponseEntity.status(e.getHttpResponceCode()).body(e);
	}

}
