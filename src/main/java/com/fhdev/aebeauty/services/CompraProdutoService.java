package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CompraProduto;
import com.fhdev.aebeauty.repositories.CompraProdutoRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class CompraProdutoService {
	
	@Autowired
	private CompraProdutoRepository repo;
	
	public List<CompraProduto> findAll() {
		
		List<CompraProduto> compras = repo.findAll();
		
		//Condição que verifica se a lista de compras está vazia. Se estiver, lança a exceção
		if(compras.isEmpty()) {
			
			throw new ObjectNotFoundException(
					"Objetos não encontrados!, Tipo: " + CompraProduto.class.getName());
		}
		
		return compras;		
	}
	
	public CompraProduto find(Integer id) {
		
		Optional<CompraProduto> compra = repo.findById(id);
		return compra.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +"Tipo: "+ CompraProduto.class.getName()));
	}

}
