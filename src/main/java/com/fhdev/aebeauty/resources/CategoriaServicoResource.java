package com.fhdev.aebeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.services.CategoriaServicoService;

@RestController
@RequestMapping(value="/categorias-servicos")
public class CategoriaServicoResource {
	
	@Autowired
	private CategoriaServicoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		CategoriaServico categoria = service.find(id);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<CategoriaServico> categorias = service.findAll();
		return ResponseEntity.ok().body(categorias);
		
	}

}
