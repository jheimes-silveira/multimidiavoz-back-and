package br.com.app.iqoption.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.iqoption.service.ContatoService;
import br.com.app.iqoption.utils.Urls;

@RestController
public class ContatoController {

	@Autowired
	private ContatoService service;

	@RequestMapping(value = Urls.ADD_NOVO_CONTATO, method = RequestMethod.POST)
	public Map<String, Object> cadastrarUmContatoAosMeusContatos(Map<String, String> request) {
		return service.cadastrarUmContatoAosMeusContatos(request);
	}
}
