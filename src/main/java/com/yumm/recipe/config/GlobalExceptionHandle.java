package com.yumm.recipe.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle  {
	private static final HttpStatus INTERNAL_SERVER_ERROR = null;
	
	
	@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
		
        return error(INTERNAL_SERVER_ERROR, e);
    }
	
	private ResponseEntity<String> error(HttpStatus status, Exception e) {
	   
		return ResponseEntity.status(506).body("Wrong Input");
	}
}