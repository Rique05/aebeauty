package com.fhdev.aebeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhdev.aebeauty.domain.CompraProduto;
import com.fhdev.aebeauty.services.CompraProdutoService;

@RestController
@RequestMapping(value="/compras-produtos")
public class CompraProdutoResource {
	
	@Autowired
	private CompraProdutoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<CompraProduto> compras = service.findAll();
		return ResponseEntity.ok().body(compras);
	}

}
