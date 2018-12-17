package edu.ccc.pharma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ccc.pharma.service.AdministradorService;

@CrossOrigin(value = "*")
@RestController
public class AdministradorController {


	@Autowired
	AdministradorService administradorService;
	
	@RequestMapping(value = "/admin/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Boolean login(@RequestBody String senha) {
		return this.administradorService.login(senha);
	}
}