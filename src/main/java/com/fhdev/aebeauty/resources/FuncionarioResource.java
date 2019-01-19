package com.fhdev.aebeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhdev.aebeauty.domain.Funcionario;
import com.fhdev.aebeauty.services.FuncionarioService;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	//Retorna uma resposta http através do método GET de todos os funcionários do sistema
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<Funcionario> funcionarios = service.findAll();
		return ResponseEntity.ok().body(funcionarios);
		
	}
	
	//Retorna uma resposta http através do método GET de um funcionário específico, determinado por um id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Funcionario funcionario = service.find(id);
		return ResponseEntity.ok().body(funcionario);
		
	}

}
