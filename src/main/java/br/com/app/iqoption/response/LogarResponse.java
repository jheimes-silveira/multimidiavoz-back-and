package br.com.app.iqoption.response;

import br.com.app.iqoption.model.Contato;
import br.com.app.iqoption.model.Meta;

public class LogarResponse {
	
	private Meta meta;
	private Contato user;
	private String token;

	public Meta getMeta() {
		if(meta == null) {
			meta = new Meta();
		}
		return meta;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public Contato getUser() {
		return user;
	}
	public void setUser(Contato user) {
		this.user = user;
	}
	
	

}
