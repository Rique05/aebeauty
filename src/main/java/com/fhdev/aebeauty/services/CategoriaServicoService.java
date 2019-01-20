package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.repositories.CategoriaServicoRepository;

@Service
public class CategoriaServicoService {
	
	@Autowired
	private CategoriaServicoRepository repo;

	public CategoriaServico find(Integer id) {
		
		Optional<CategoriaServico> categoria = repo.findById(id);
		return categoria.orElse(null);
		
	}
	
	public List<CategoriaServico> findAll(){
		
		List<CategoriaServico> categorias = repo.findAll();
		return categorias;
		
	}

}
