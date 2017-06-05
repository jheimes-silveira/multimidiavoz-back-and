package br.com.app.iqoption.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private List<Contato> contatos;

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public static final String CONTATO_LISTA_TELEFONICA = "contatoListaTelefonica";
	public static final String MEU_NUMERO = "meuNumero";
	public static final String CONTATO_NUMERO = "contatoNumero";
	

	public Contato() {
	}

	public Contato(String nome, String numero) {
		super();
		this.nome = nome;
		this.numero = numero;
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

}
