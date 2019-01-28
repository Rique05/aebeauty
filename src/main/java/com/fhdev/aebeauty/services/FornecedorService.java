package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.Fornecedor;
import com.fhdev.aebeauty.repositories.FornecedorRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;
	
	public List<Fornecedor> findAll() {
		
		List<Fornecedor> fornecedores = repo.findAll();
		
		//Condição que verifica se a lista de funcionarios está vazia. Se estiver, lança a exceção
		if(fornecedores.isEmpty()) {
			
			throw new ObjectNotFoundException(
					"Objetos não encontrados!, Tipo: " + Fornecedor.class.getName());

		}
		return fornecedores;
	}
	
	public Fornecedor find(Integer id) {
		
		Optional<Fornecedor> fornecedor = repo.findById(id);
		return fornecedor.orElseThrow(() -> new ObjectNotFoundException( //Exceção personalizada para busca
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
		
	}
	
}
