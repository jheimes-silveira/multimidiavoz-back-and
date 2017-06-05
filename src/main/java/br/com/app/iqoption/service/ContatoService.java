package br.com.app.iqoption.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.iqoption.model.Contato;
import br.com.app.iqoption.model.Meta;
import br.com.app.iqoption.repository.UsersRepository;
import br.com.app.iqoption.response.ContatoResponse;

@Service
public class ContatoService {

	@Autowired
	private UsersRepository repository;
	
	public Map<String, Object> cadastrarUmContatoAosMeusContatos(Map<String, String> request) {
		
		Map<String, Object> response = new HashMap<>();
		Meta meta = new Meta();
		
		String meuNumero = request.get(Contato.MEU_NUMERO);
		
		Contato meuContato = repository.findByNumero(meuNumero);
		meta.setOk(true);
		meta.setMessage("Usuario add com sucesso.");
		response.put(Meta.META, meta);
		response.put(Contato.CONTATO, repository.save(meuContato));

		return response;
	}

	/**
	 * Buscar todos os contatos no banco
	 * @return lista de contatos
	 */
	public ContatoResponse buscarContatos(Map<String, String> request) {
		ContatoResponse response = new ContatoResponse();
		if (request.containsKey("idUser")) {			
			Long id = Long.valueOf(request.get("idUser"));
			response.setContatos(repository.findAll(id));
		} else {
			response.setContatos(repository.findAll());			
		}
		response.getMeta().setOk(true);
		return response;
	}

}
