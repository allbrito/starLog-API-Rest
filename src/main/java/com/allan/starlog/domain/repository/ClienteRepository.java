package com.allan.starlog.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allan.starlog.domain.entities.ClienteEntitiy;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntitiy, Long>{
	
	Optional<ClienteEntitiy> findByEmail(String email);
}
