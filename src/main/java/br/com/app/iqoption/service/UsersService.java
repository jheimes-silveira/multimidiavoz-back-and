package br.com.app.iqoption.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.iqoption.model.Contato;
import br.com.app.iqoption.repository.UsersRepository;
import br.com.app.iqoption.request.UsersRequest;
import br.com.app.iqoption.response.LogarResponse;
import br.com.app.iqoption.response.UsersResponse;
import br.com.app.iqoption.utils.Constants;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	public UsersResponse cadastrar(UsersRequest usersRequest) {

		UsersResponse usersResponse = new UsersResponse();
		String nome = usersRequest.getNome();
		String telefone = usersRequest.getTelefone();
		String senha = usersRequest.getSenha();
		if (nome == null || usersRequest.getSenha() == null) {
			usersResponse.getMeta().setOk(false);
			usersResponse.getMeta().setMessage("Dados incompletos");
			return usersResponse;
		}
		Contato contato = repository.findByLogin(telefone, senha);
		if (contato != null) {
			usersResponse.getMeta().setOk(false);
			usersResponse.getMeta().setMessage("Usuario já cadastrado");
			return usersResponse;
		}
		Contato users = new Contato();

		usersResponse.getMeta().setOk(true);
		usersResponse.getMeta().setMessage("Cadastro realizado com sucesso.");

		users.setNome(usersRequest.getNome());
		users.setSenha(usersRequest.getSenha());
		users.setNumero(usersRequest.getTelefone());
		usersResponse.setUser(repository.save(users));

		return usersResponse;
	}

	public LogarResponse logar(UsersRequest usersRequest) {
		LogarResponse logarResponse = new LogarResponse();
		Contato contato = repository.findByLogin(usersRequest.getTelefone(), usersRequest.getSenha());

		logarResponse.setToken(Jwts.builder().setSubject(usersRequest.getTelefone())
				.signWith(SignatureAlgorithm.HS512, Constants.KEY_CRIPT).compact());

		logarResponse.setUser(contato);
		logarResponse.getMeta().setOk(true);
		logarResponse.getMeta().setMessage("Logado com sucesoo!!");
		return logarResponse;
	}
}
