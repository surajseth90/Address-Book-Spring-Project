package com.bridgelabz.addressbookapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream()
											.map(objErr -> objErr.getDefaultMessage())
											.collect(Collectors.toList());
		ResponseDTO dto = new ResponseDTO("Exception while processing REST Request", errorMessage);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.BAD_REQUEST);
		
	}
}
