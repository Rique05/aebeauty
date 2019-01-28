package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.Produto;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;
import com.fhdev.aebeauty.repositories.ProdutoRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaProdutoService {
	
	@Autowired
	private CategoriaProdutoRepository repo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
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
	
	@Transactional
	public CategoriaProduto insert(CategoriaProduto obj) {
		
		obj.setId(null); //O id deve ser nulo para que o método save considere uma inserção nova, não uma atualização
		obj = repo.save(obj); //Salva no banco de dados e retorna o objeto com o id criado automaticamente pelo banco
		
		//Define a categoria a qual os produtos cadastrados da categoria pertencem
		for (Produto x : obj.getProdutos()) {
			x.setCategoria(obj);
		}
		
		//Salva os produtos cadastrados da categoria no banco de dados
		prodRepo.saveAll(obj.getProdutos());
		return obj;
	}

}
