package com.jsp.UserSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.UserSpringBoot.util.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserIdNotFound(UserIdNotFoundException ex)
	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Sorry User Id Not Found");
		responseStructure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserNameNotFound(UserNameNotFoundException ex)
	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Sorry User Name Not Found");
		responseStructure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
