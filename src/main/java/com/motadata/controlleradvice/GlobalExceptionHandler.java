package com.motadata.controlleradvice;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.motadata.exception.ElectronicsNotFoundException;
import com.motadata.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			String fieldName = error.getField();
			String errorMessage = error.getDefaultMessage();
			String[] fieldParts = fieldName.split("\\.");
			if (fieldParts.length > 0) {
				fieldName = fieldParts[fieldParts.length - 1];
			}
			errorMap.put("message", errorMessage);
		});

		return errorMap;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ElectronicsNotFoundException.class)
	public Map<String, String> timeLogFoundException(ElectronicsNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", ex.getMessage());
		return errorMap;
	}

	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public Map<String, String> timeLogFoundException(ProductNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", ex.getMessage());
		return errorMap;
	}
}