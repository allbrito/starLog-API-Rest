package com.allan.starlog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allan.starlog.domain.entities.EntregaEntity;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaEntity, Long> {

}
