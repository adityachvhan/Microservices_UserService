package com.corejavahub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.corejavahub.response.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourseNotFoundException(
			ResourseNotFoundException resourseNotFoundException) {

		String message = resourseNotFoundException.getMessage();

		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND)
				.build();

		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

	}
}
