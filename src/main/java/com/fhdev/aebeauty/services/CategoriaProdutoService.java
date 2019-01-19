package com.fhdev.aebeauty.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {
	
	@Autowired
	private CategoriaProdutoRepository repo;
	
	public CategoriaProduto find(Integer id) {
		
		Optional<CategoriaProduto> categoria = repo.findById(id);
		return categoria.orElse(null);
		
	}

}
