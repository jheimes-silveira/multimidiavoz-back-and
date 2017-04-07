package br.com.app.iqoption.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.iqoption.model.Contato;
import br.com.app.iqoption.model.Meta;
import br.com.app.iqoption.repository.UsersRepository;

@Service
public class ContatoService {

	@Autowired
	private UsersRepository repository;
	
	public Map<String, Object> cadastrarUmContatoAosMeusContatos(Map<String, String> request) {
		
		Map<String, Object> response = new HashMap<>();
		Meta meta = new Meta();
		
		String meuNumero = request.get(Contato.MEU_NUMERO);
		String contatoNumero = request.get(Contato.CONTATO_NUMERO);
		
		Contato meuContato = repository.findByNumero(meuNumero);
		Contato outroContato = repository.findByNumero(contatoNumero);
		meuContato.getContatoListaTelefonica().add(outroContato);
		meta.setOk(true);
		meta.setMessage("Usuario add com sucesso.");
		response.put(Meta.META, meta);
		response.put(Contato.CONTATO, repository.save(meuContato));

		return response;
	}

}
