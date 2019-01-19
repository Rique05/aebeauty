package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.Funcionario;
import com.fhdev.aebeauty.repositories.FuncionarioRepository;

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
		return funcionario.orElse(null);
		
	}
	
}
