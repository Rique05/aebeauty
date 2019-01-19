package com.fhdev.aebeauty.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CompraProduto;
import com.fhdev.aebeauty.repositories.CompraProdutoRepository;

@Service
public class CompraProdutoService {
	
	@Autowired
	private CompraProdutoRepository repo;
	
	public List<CompraProduto> findAll() {
		
		List<CompraProduto> compras = repo.findAll();		
		return compras; //Necessário ajustes de exceções	
		
	}

}
