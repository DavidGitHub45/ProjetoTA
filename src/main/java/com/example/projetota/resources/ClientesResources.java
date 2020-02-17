package com.example.projetota.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.projetota.model.Clientes;
import com.example.projetota.service.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesResources {

	@Autowired
	private ClientesService clientesService;
	
	@GetMapping("/todas")
	public List<Clientes> listarClientes() {
		return clientesService.listarClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> findCategoria(@PathVariable Integer id) {
		Clientes clientes = clientesService.findClientes(id);
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping()
	public Page<Clientes> pesquisar(@RequestParam(required = false, defaultValue = "") String nome, Pageable pageable) {
		return clientesService.pesquisar(nome, pageable);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Clientes clientes) {
		clientes = clientesService.insert(clientes);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clientes.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Clientes clientes) {
		clientes = clientesService.update(clientes);
		return ResponseEntity.noContent().build();

	}
}
