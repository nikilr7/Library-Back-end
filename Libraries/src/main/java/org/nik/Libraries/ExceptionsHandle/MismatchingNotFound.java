package org.nik.Libraries.ExceptionsHandle;

public class MismatchingNotFound extends RuntimeException
{
	@Override
	public String getMessage()
	{
		return "MisMatching Data";
	}
}
