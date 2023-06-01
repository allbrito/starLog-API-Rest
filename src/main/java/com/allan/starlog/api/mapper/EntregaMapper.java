package com.allan.starlog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.allan.starlog.api.model.EntregaModel;
import com.allan.starlog.domain.entities.EntregaEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {

	private ModelMapper modelMapper;
	
	public EntregaModel toModel(EntregaEntity entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<EntregaEntity> entregas){
		return entregas.stream()
				.map(this::toModel).collect(Collectors.toList());
	}
}
