package com.allan.starlog.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allan.starlog.domain.entities.ClienteEntitiy;
import com.allan.starlog.domain.exception.NegocioException;
import com.allan.starlog.domain.repository.ClienteRepository;

import lombok.Getter;

@Service
public class GerenciadorClienteService {

	@Autowired
	@Getter
	private ClienteRepository clienteRepository;
	
	@Transactional
	public List<ClienteEntitiy> listar(){
		return clienteRepository.findAll();
	}
	
	@Transactional
	public ResponseEntity<ClienteEntitiy> buscar(Long id){
		return clienteRepository.findById(id)
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public ClienteEntitiy adicionar(ClienteEntitiy cliente) {
		
		boolean existeEmail = clienteRepository.findByEmail(cliente.getEmail())
				.stream().anyMatch(existeCliente -> !existeCliente.equals(cliente));
		
		if (existeEmail) {
			throw new NegocioException("já existe um cliente cadastrado com esse email");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public ResponseEntity<ClienteEntitiy> atualizar(Long id, ClienteEntitiy cliente){
		
		if (clienteRepository.existsById(id)) {
			
			cliente.setId(id);
			cliente = adicionar(cliente);
			
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	public ResponseEntity<Void> deletar(Long id) {
		
		if (clienteRepository.existsById(id)) {
			
			clienteRepository.deleteById(id);
			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	public ClienteEntitiy verificar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
}
