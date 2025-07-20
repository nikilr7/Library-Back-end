package org.nik.Libraries.HelperClasses;

public class ResponseStructure<T>
{
	private Integer httpstatuscode;
	private String message;
	private T data;
	public Integer getHttpstatuscode() {
		return httpstatuscode;
	}
	public void setHttpstatuscode(Integer httpstatuscode) {
		this.httpstatuscode = httpstatuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
