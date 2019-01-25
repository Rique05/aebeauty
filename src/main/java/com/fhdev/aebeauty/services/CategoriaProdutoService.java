package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaProdutoService {
	
	@Autowired
	private CategoriaProdutoRepository repo;
	
	public List<CategoriaProduto> findAll(){
		
		List<CategoriaProduto> categorias = repo.findAll();
		
		//Condição que verifica se a lista de categorias está vazia. Se estiver, lança a exceção
		if(categorias.isEmpty()) {
					
		throw new ObjectNotFoundException(
					"Objetos não encontrados!, Tipo: " + CategoriaProduto.class.getName());
		}
				
		return categorias;	
	}
	
	public CategoriaProduto find(Integer id) {
		
		Optional<CategoriaProduto> categoria = repo.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException( //Exceção personalizada para busca
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaProduto.class.getName()));
		
	}
	
	public CategoriaProduto insert(CategoriaProduto obj) {
		
		obj.setId(null); //O id deve ser nulo para que o método save considere uma inserção nova, não uma atualização
		return repo.save(obj);
	}

}
