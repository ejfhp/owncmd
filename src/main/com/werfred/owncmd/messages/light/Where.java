package com.werfred.owncmd.messages.light;

public class Where {
	private String text = "";
	int ambient = -1;
	int light = -1;
	
	public static Where GENERAL = new Where("0");
	
	public Where (int ambient, int light) {
		this.ambient = ambient;
		this.light = light;
	}
	
	// GENERAL
	private Where(String text) {
		this.text = text;
	} 
	
	public String getText() {
		if (this.ambient > 0 && this.light > 0) {
			this.text = this.ambient + "" + this.light;
		}
		return this.text;
	}
}
