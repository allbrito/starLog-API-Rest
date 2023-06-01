package com.allan.starlog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allan.starlog.domain.entities.ClienteEntitiy;
import com.allan.starlog.domain.service.GerenciadorClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private GerenciadorClienteService clienteService;	

	@GetMapping
	public List<ClienteEntitiy> listar() {
		return clienteService.listar();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteEntitiy> buscar(@PathVariable Long id) {
		return clienteService.buscar(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteEntitiy adicionar(@Valid @RequestBody ClienteEntitiy cliente) {
		return clienteService.adicionar(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteEntitiy> atualizar(@Valid @PathVariable Long id, @RequestBody ClienteEntitiy cliente) {
		return clienteService.atualizar(id, cliente);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return clienteService.deletar(id);
	}
}
