package com.fhdev.aebeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhdev.aebeauty.domain.Fornecedor;
import com.fhdev.aebeauty.services.FornecedorService;

@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service;
	
	//Retorna uma resposta http através do método GET de todos os fornecedores do sistema
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<Fornecedor> fornecedores = service.findAll();
		return ResponseEntity.ok().body(fornecedores);
		
	}
	
	//Retorna uma resposta http através do método GET de um fornecedor específico, determinado por um id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Fornecedor fornecedor = service.find(id);
		return ResponseEntity.ok().body(fornecedor);
		
	}

}
