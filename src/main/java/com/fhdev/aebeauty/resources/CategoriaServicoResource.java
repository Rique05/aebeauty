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

import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.services.CategoriaServicoService;

@RestController
@RequestMapping(value="/categorias-servicos")
public class CategoriaServicoResource {
	
	@Autowired
	private CategoriaServicoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<CategoriaServico> categorias = service.findAll();
		return ResponseEntity.ok().body(categorias);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaServico> find(@PathVariable Integer id){
		
		CategoriaServico categoria = service.find(id);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	//Método responsável pela requisição de inserção de um objeto do tipo CategoriaServico
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CategoriaServico obj){
		
		//Insere a categoria no banco e recebe o retorno do objeto para a criação da URI
		obj = service.insert(obj);
		
		//Cria uma URI com o objeto retornado da inserção (que ocorreu no método insert da classe CategoriaProdutoService)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//Retorna a uri criada como resposta
		return ResponseEntity.created(uri).build();
	}
	
}
