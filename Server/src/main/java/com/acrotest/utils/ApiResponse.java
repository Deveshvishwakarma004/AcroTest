package com.acrotest.utils;

public class ApiResponse
{
   private boolean status;
   private String msg;
   private String error;
   private Object data;
   
public ApiResponse() {
	super();
}

public ApiResponse(boolean status, String msg, String error, Object data) {
	super();
	this.status = status;
	this.msg = msg;
	this.error = error;
	this.data = data;
}

public ApiResponse(boolean status, String msg, String error) {
	super();
	this.status = status;
	this.msg = msg;
	this.error = error;
}

public ApiResponse(boolean status, String msg, Object data) {
	super();
	this.status = status;
	this.msg = msg;
	this.data = data;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public String getError() {
	return error;
}

public void setError(String error) {
	this.error = error;
}

public Object getData() {
	return data;
}

public void setData(Object data) {
	this.data = data;
}

   
}
