package br.com.app.iqoption.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authorities {
	
	@Id
	private String username;
	private String authority;
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Authorities(String username, String authority, Long id) {
		super();
		this.username = username;
		this.authority = authority;
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthorities() {
		return authority;
	}
	public void setAuthorities(String authority) {
		this.authority = authority;
	}
	public Authorities() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
