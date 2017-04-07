package br.com.app.iqoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.iqoption.model.Contato;
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

	@RequestMapping(value = "login/teste", method = RequestMethod.GET)
	public List<Contato> teste() {

		return service.findAll();
	}
}
