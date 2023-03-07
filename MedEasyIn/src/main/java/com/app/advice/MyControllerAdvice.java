package com.app.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.customException.ElementAlreadyExistsException;
import com.app.customException.ElementNotFoundException;
import com.app.customException.EmptyInputException;
import com.app.customException.OutOfStockException;
import com.app.customException.ResourceNotFoundException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ElementAlreadyExistsException.class)
	public ResponseEntity<String> handleUserAlreadyExistsException(ElementAlreadyExistsException elementException){
		return new ResponseEntity<String>("Conflict:" + elementException.getElementName() + elementException.getErrorMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(OutOfStockException.class)
	public ResponseEntity<String> handleOutOfStockException(OutOfStockException elementException){
		return new ResponseEntity<String>("Conflict:" + elementException.getElementName()+" " + elementException.getErrorMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException resourceException){
		return new ResponseEntity<String>("Not found: Resource you are trying to find not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyIputException){
		return new ResponseEntity<String>("Input fields are empty", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<String> handleElementNotFoundException(ElementNotFoundException elementException){
		return new ResponseEntity<String>(elementException.getElementName() +" "+ elementException.getErrorMessage(), HttpStatus.NOT_FOUND);
	}
	
}