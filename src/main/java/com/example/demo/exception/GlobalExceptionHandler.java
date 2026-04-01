package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex){
		ApiResponse<Object> res = ApiResponse.<Object>builder()
		.statusCode(404)
		.message(ex.getMessage())
		.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
	
}
