package com.allan.starlog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allan.starlog.domain.entities.ClienteEntitiy;
import com.allan.starlog.domain.entities.EntregaEntity;
import com.allan.starlog.domain.entities.StatusEntrega;
import com.allan.starlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private GerenciadorClienteService clienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public EntregaEntity solicitar(EntregaEntity entrega) {
		
		ClienteEntitiy cliente = clienteService.verificar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
