package org.nik.Libraries.ExceptionsHandle;

import org.nik.Libraries.HelperClasses.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IdNotFoundExceptionHandling 
{
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> IdNotFoundException(IdNotFoundException exp)
	{
		ResponseStructure<String> response=new ResponseStructure<String>();
		
		response.setHttpstatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Id Is Not Found");
		response.setData(exp.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,null,HttpStatus.NOT_FOUND);
	}
}
