package org.nik.Libraries.ExceptionsHandle;

public class IdNotFoundException extends RuntimeException
{
	@Override
	public String getMessage()
	{
		return "Id Not Found";
	}
}
