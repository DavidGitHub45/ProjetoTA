package com.example.projetota.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetota.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
	public Page<Clientes> findByNomeContaining(String nome, Pageable pageable);
}
