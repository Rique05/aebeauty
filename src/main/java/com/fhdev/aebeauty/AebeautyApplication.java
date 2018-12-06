package com.fhdev.aebeauty;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.Produto;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;
import com.fhdev.aebeauty.repositories.ProdutoRepository;

@SpringBootApplication
public class AebeautyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AebeautyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaProduto catProd1 = new CategoriaProduto(null,"Alisante");
		
		Produto p1 = new Produto(null, "Hair Life", 40.00, 5, catProd1);
		
		catProd1.getProdutos().addAll(Arrays.asList(p1));
		
		categoriaProdutoRepository.saveAll(Arrays.asList(catProd1));
		produtoRepository.saveAll(Arrays.asList(p1));
	
	}
}
