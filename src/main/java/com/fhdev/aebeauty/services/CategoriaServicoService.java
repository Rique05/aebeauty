package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.repositories.CategoriaServicoRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServicoService {
	
	@Autowired
	private CategoriaServicoRepository repo;
	
	public List<CategoriaServico> findAll(){
		
		List<CategoriaServico> categorias = repo.findAll();
		
		//Condição que verifica se a lista de categorias está vazia. Se estiver, lança a exceção
				if(categorias.isEmpty()) {
					
					throw new ObjectNotFoundException(
							"Objetos não encontrados!, Tipo: " + CategoriaServico.class.getName());
		
				}
	
		return categorias;
	}

	public CategoriaServico find(Integer id) {
		
		Optional<CategoriaServico> categoria = repo.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException( //Exceção personalizada para busca
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaProduto.class.getName()));
		
	}
	
}
