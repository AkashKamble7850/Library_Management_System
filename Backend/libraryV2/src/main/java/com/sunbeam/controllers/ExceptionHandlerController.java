package com.sunbeam.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sunbeam.dtos.Response;

//global exception handling -- applicable for exception arised in any controller
@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException ex){
		// local Class
		class FieldErrorDto{
			private String fieldName;
			private String errMessage;
			
			public FieldErrorDto(String fieldName, String errMessage) {
				super();
				this.fieldName = fieldName;
				this.errMessage = errMessage;
			}
			public String getFieldName() {
				return fieldName;
			}
			public void setFieldName(String fieldName) {
				this.fieldName = fieldName;
			}
			public String getErrMessage() {
				return errMessage;
			}
			public void setErrMessage(String errMessage) {
				this.errMessage = errMessage;
			}		
		}
		List<FieldError> error = ex.getFieldErrors();
		Stream<FieldErrorDto> result = error.stream().map(err -> new FieldErrorDto(err.getField(), err.getDefaultMessage()));
		return Response.error(result);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class) 
	public ResponseEntity<?> emailExistsHandler(DataIntegrityViolationException ex)	{
		return Response.error(ex.getMessage());
	}

}
