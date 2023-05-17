package com.allan.starlog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allan.starlog.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Joao");
		cliente1.setTelefone("11 99874-5879");
		cliente1.setEmail("joaodasilva@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("75 99748-7599");
		cliente2.setEmail("mariahelena@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
