package br.com.app.iqoption.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.iqoption.request.UsersRequest;
import br.com.app.iqoption.response.LogarResponse;
import br.com.app.iqoption.response.UsersResponse;
import br.com.app.iqoption.service.UsersService;

@RestController
public class UserController {

	@Autowired
	private UsersService service;

	@RequestMapping(value = "login/register/usuario", method = RequestMethod.POST)
	public UsersResponse cadastrar(UsersRequest user) { // @RequestBody
		return service.cadastrar(user);
	}

	@RequestMapping(value = "login/logar", method = RequestMethod.POST)
	public LogarResponse logar(UsersRequest user) {
		return service.logar(user);
	}

	@RequestMapping(value = "teste", method = RequestMethod.POST)
	public Map<String, String> logar() {
		Map<String, String> response = new HashMap<>();
		response.put("teste", "valor de teste");
		return response;
	}
}
