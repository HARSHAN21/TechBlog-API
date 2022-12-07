package com.blog.blogApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AllExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<String> genericExceptionHandler(Exception e){
		
		return new ResponseEntity<String>("Can not proccess request currently : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
