package com.fhdev.aebeauty.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.services.CategoriaProdutoService;

@RestController
@RequestMapping(value="/categorias-produtos")
public class CategoriaProdutoResource {
	
	@Autowired
	private CategoriaProdutoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		CategoriaProduto categoria = service.find(id);
		return ResponseEntity.ok().body(categoria);
		
	}

}
