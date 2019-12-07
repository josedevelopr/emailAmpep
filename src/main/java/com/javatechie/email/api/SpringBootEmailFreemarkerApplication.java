package com.javatechie.email.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.email.api.dto.MailRequest;
import com.javatechie.email.api.dto.MailResponse;
//import com.javatechie.email.api.dto.ValidacionRegistroUsuario;
import com.javatechie.email.api.service.EmailService;
//import com.javatechie.email.api.service.ValidacionRegistroUsuarioService;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class SpringBootEmailFreemarkerApplication {

	@Autowired
	private EmailService service;
	//private ValidacionRegistroUsuarioService serviceValidacion;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", " ");
		return service.sendEmail(request, model);

	}
	
	@PostMapping("/sendingEmailUserCreated")
	public MailResponse sendEmailUserCreated(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", " ");
		return service.sendUsersCredendetialsEmail(request, model);

	}
	/*
	@PostMapping(path= {"/validacionregistro/"})
	public ValidacionRegistroUsuario insertValidation(@RequestBody ValidacionRegistroUsuario valreg) {
		
		return serviceValidacion.add(valreg);
	}
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailFreemarkerApplication.class, args);
	}
}
