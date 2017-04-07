package br.com.app.iqoption.model;

public class Meta {

	public static final String META = "meta";
	public static final String OK = "ok";
	public static final String MESSAGE = "message";
	
	private Boolean ok = false;
	private String message;
	
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
