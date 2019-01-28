package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.domain.Servico;
import com.fhdev.aebeauty.repositories.CategoriaServicoRepository;
import com.fhdev.aebeauty.repositories.ServicoRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServicoService {
	
	@Autowired
	private CategoriaServicoRepository repo;
	
	@Autowired
	private ServicoRepository servRepo;
	
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
	
	//Metodo responsável por inserir uma categoria de servico
	@Transactional
	public CategoriaServico insert(CategoriaServico obj) {
		
		obj.setId(null);//O id deve ser nulo para que o método save considere uma inserção nova, não uma atualização
		obj = repo.save(obj);//Salva no banco de dados e retorna o objeto com o id criado automaticamente pelo banco

		//Define a categoria a qual os servicos cadastrados da categoria pertencem
		for(Servico x : obj.getServicos()) {
			x.setCategoria(obj);	
		}
		 
		//Salva os servicos cadastrados da categoria no banco de dados
		servRepo.saveAll(obj.getServicos());
		return obj; 
		
	}
	
}
