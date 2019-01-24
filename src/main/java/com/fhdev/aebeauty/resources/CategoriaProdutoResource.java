package com.fhdev.aebeauty.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.services.CategoriaProdutoService;

@RestController
@RequestMapping(value="/categorias-produtos")
public class CategoriaProdutoResource {
	
	@Autowired
	private CategoriaProdutoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<?> findAll(){
		
		List<CategoriaProduto> categorias = service.findAll();
		return ResponseEntity.ok().body(categorias);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		CategoriaProduto categoria = service.find(id);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	//Requisição de inserção de uma categoria de produto. Método Post
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CategoriaProduto obj){//RequestBody faz o Json passado ser convertido para um objeto CategoriaProduto
		
		obj = service.insert(obj);
		
		//Cria uma URI com o objeto retornado da inserção (que ocorreu no método insert da classe CategoriaProdutoService)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//Retorna a uri criada como resposta
		return ResponseEntity.created(uri).build();
	}

}
