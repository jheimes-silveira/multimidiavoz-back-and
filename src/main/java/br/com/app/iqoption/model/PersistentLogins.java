package br.com.app.iqoption.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersistentLogins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String series;	
	private String username;
	private String token;
	private Timestamp last_used;
	
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getLast_used() {
		return last_used;
	}
	public void setLast_used(Timestamp last_used) {
		this.last_used = last_used;
	}
	
	protected PersistentLogins(String series, String username, String token, Timestamp last_used) {
		super();
		this.series = series;
		this.username = username;
		this.token = token;
		this.last_used = last_used;
	}
	
	protected PersistentLogins() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
