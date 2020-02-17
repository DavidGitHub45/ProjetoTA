package com.example.projetota.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.projetota.exception.NotFound;
import com.example.projetota.model.Cidade;
import com.example.projetota.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listarCidade() {
		return cidadeRepository.findAll();
	}
	
	public Page<Cidade> pesquisar(String nome, Pageable pageable) {
		return cidadeRepository.findByNomeContaining(nome, pageable);
	}
	
	public Cidade findCidade(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(() -> new NotFound("Objeto não encontrado! Id: " + id + " Tipo: " + Cidade.class.getName()));
	}
	
	public Cidade insert(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public Cidade update(Cidade cidade) {
		findCidade(cidade.getId());
		return cidadeRepository.save(cidade);
	}

}
