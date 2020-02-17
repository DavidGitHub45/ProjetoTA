package com.example.projetota.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.projetota.exception.NotFound;
import com.example.projetota.model.Clientes;
import com.example.projetota.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Clientes> listarClientes() {
		return clientesRepository.findAll();
	}
	
	public Page<Clientes> pesquisar(String nome, Pageable pageable) {
		return clientesRepository.findByNomeContaining(nome, pageable);
	}
	
	public Clientes findClientes(Integer id) {
		Optional<Clientes> clientes = clientesRepository.findById(id);
		return clientes.orElseThrow(() -> new NotFound("Objeto não encontrado! Id: " + id + " Tipo: " + Clientes.class.getName()));
	}
	
	public Clientes insert(Clientes clientes) {
		return clientesRepository.save(clientes);
	}
	
	public Clientes update(Clientes clientes) {
		findClientes(clientes.getId());
		return clientesRepository.save(clientes);
	}

}
