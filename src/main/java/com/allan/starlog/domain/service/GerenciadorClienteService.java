package com.allan.starlog.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allan.starlog.domain.exception.NegocioException;
import com.allan.starlog.domain.model.Cliente;
import com.allan.starlog.domain.repository.ClienteRepository;

import lombok.Getter;

@Service
public class GerenciadorClienteService {

	@Autowired
	@Getter
	private ClienteRepository repository;
	
	@Transactional
	public List<Cliente> listar(){
		return repository.findAll();
	}
	
	@Transactional
	public ResponseEntity<Cliente> buscar(Long id){
		return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public Cliente adicionar(Cliente cliente) {
		
		boolean existeEmail = repository.findByEmail(cliente.getEmail())
				.stream().anyMatch(existeCliente -> !existeCliente.equals(cliente));
		
		if (existeEmail) {
			
			String mensagem = "já existe um cliente cadastrado com esse email";
			throw new NegocioException(mensagem);
		}
		
		return repository.save(cliente);
	}
	
	@Transactional
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
