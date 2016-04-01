package com.werfred.owncmd.telegram.entity;

public class Response {

	private boolean ok;
	private Update[] result;
	
	public Response() {
		
	}
	
	public boolean getOk() {
		return this.ok;
	}
	
	public Update[] getResult() {
		return this.result;
	}
	
	
}
