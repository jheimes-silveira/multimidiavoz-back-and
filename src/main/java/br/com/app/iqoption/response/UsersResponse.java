package br.com.app.iqoption.response;

import br.com.app.iqoption.model.Contato;
import br.com.app.iqoption.model.Meta;

public class UsersResponse {

	private Meta meta;
	private Contato user;
	
	public Meta getMeta() {
		if(meta == null) {
			meta = new Meta();
		}
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Contato getUser() {
		return user;
	}
	public void setUser(Contato user) {
		this.user = user;
	}
}
