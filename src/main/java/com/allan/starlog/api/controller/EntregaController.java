package com.allan.starlog.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allan.starlog.api.mapper.EntregaMapper;
import com.allan.starlog.api.model.EntregaModel;
import com.allan.starlog.domain.model.Entrega;
import com.allan.starlog.domain.repository.EntregaRepository;
import com.allan.starlog.domain.service.SolicitacaoEntregaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService entregaService;
	private EntregaMapper entregaMapper;
	
	@GetMapping
	public List<EntregaModel> listar(){
		return entregaMapper.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map(entrega ->ResponseEntity.ok(entregaMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody Entrega entrega) {
		Entrega entregaSolicitada = entregaService.solicitar(entrega);
		return entregaMapper.toModel(entregaSolicitada);
	}
}
