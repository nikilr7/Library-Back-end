package org.nik.Libraries.ExceptionsHandle;

import org.nik.Libraries.HelperClasses.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class MisMatchingHandling extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(MismatchingNotFound.class)
	public ResponseEntity<ResponseStructure<String>> misMatchingHandling(MismatchingNotFound exp)
	{
		ResponseStructure<String> resp=new ResponseStructure<String>();
		
		resp.setData(exp.getMessage());
		resp.setHttpstatuscode(HttpStatus.NOT_FOUND.value());
		resp.setMessage("MisMatching Data");
		return new ResponseEntity<ResponseStructure<String>>(resp,null,HttpStatus.NOT_FOUND);
	}
}
