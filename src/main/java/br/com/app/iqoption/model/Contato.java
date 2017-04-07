package br.com.app.iqoption.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Contato {

	public static final String CONTATO = "contato";
	public static final String CONTATOS = "contatos";

	public static final String ID = "id";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public static final String NOME = "nome";
	private String nome;

	public static final String SENHA = "senha";
	private String senha;

	public static final String NUMERO = "numero";
	private String numero;
	
	public static final String CONTATO_LISTA_TELEFONICA = "contatoListaTelefonica";
	public static final String MEU_NUMERO = "meuNumero";
	public static final String CONTATO_NUMERO = "contatoNumero";
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="contatoListaTelefonica"
		, joinColumns={
			@JoinColumn(name="meuNumero")
			}
		, inverseJoinColumns={
			@JoinColumn(name="contatoNumero")
			}
		)
	private List<Contato> contatoListaTelefonica = new ArrayList<>();
	private Boolean enabled;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Contato() {
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Contato> getContatoListaTelefonica() {
		return contatoListaTelefonica;
	}

	public void setContatoListaTelefonica(List<Contato> contatoListaTelefonica) {
		this.contatoListaTelefonica = contatoListaTelefonica;
	}

}
