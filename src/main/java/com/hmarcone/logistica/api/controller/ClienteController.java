package com.hmarcone.logistica.api.controller;

//import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.hmarcone.domain.service.CatalogoClienteService;
import com.hmarcone.logistica.domain.model.Cliente;
import com.hmarcone.logistica.domain.repository.ClienteRepository;
import com.hmarcone.logistica.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;	
		
	
//	@PersistenceContext
//	private EntityManager manager;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
//		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
	}
//	
//	@PutMapping("/{clienteId}")
//	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, 
//			@Valid @RequestBody Cliente cliente) {
//		if (!clienteRepository.existsById(clienteId)) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		cliente.setId(clienteId);
//		cliente = catalogoClienteService.salvar(cliente);
//		
//		return ResponseEntity.ok(cliente);
//	}
//	
//	@DeleteMapping("/{clienteId}")
//	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
//		if (!clienteRepository.existsById(clienteId)) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		catalogoClienteService.excluir(clienteId);
//		
//		return ResponseEntity.noContent().build();
//	}
	
}
