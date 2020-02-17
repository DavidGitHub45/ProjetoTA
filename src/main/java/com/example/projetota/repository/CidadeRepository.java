package com.example.projetota.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetota.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	public Page<Cidade> findByNomeContaining(String nome, Pageable pageable);
}
