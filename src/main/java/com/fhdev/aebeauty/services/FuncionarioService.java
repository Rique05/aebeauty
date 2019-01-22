package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.Funcionario;
import com.fhdev.aebeauty.repositories.FuncionarioRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public List<Funcionario> findAll() {
		
		List<Funcionario> funcionarios = repo.findAll();
		return funcionarios;
		
	}
	
	public Funcionario find(Integer id) {
		
		Optional<Funcionario> funcionario = repo.findById(id);
		return funcionario.orElseThrow(() -> new ObjectNotFoundException( //Exceção personalizada para busca
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaProduto.class.getName()));
		
	}
	
}
