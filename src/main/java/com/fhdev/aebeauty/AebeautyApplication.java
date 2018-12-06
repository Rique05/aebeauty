package com.fhdev.aebeauty;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.domain.Produto;
import com.fhdev.aebeauty.domain.Servico;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;
import com.fhdev.aebeauty.repositories.CategoriaServicoRepository;
import com.fhdev.aebeauty.repositories.ProdutoRepository;
import com.fhdev.aebeauty.repositories.ServicoRepository;

@SpringBootApplication
public class AebeautyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaServicoRepository categoriaServicoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AebeautyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Instâncias de CategoriaProduto e Produto
		CategoriaProduto catProd1 = new CategoriaProduto(null,"Alisante");
		CategoriaProduto catProd2 = new CategoriaProduto(null,"Shampoo");
		
		Produto p1 = new Produto(null, "Hair Life", 40.00, 5, catProd1);
		Produto p2 = new Produto(null, "Salon Line", 70.00, 12, catProd1);
		Produto p3 = new Produto(null, "Seda", 8.50, 15, catProd2);
		
		catProd2.getProdutos().addAll(Arrays.asList(p3));
		catProd1.getProdutos().addAll(Arrays.asList(p1,p2));
		
		categoriaProdutoRepository.saveAll(Arrays.asList(catProd1,catProd2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		//Instâncias de CategoriaServico e Servico
		
		CategoriaServico catServ1 = new CategoriaServico(null,"Escova");
		CategoriaServico catServ2 = new CategoriaServico(null, "Alisamento");
		CategoriaServico catServ3 = new CategoriaServico(null, "Corte");
	
		//formato definido para a hora média gasta para a realização do serviço
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		
		Servico serv1 = new Servico(null, "Escova Pequena", 20.00, sdf.parse("2:30"), "Escova para cabelos pequenos.", catServ1);
		catServ1.getServicos().addAll(Arrays.asList(serv1));
		
		categoriaServicoRepository.saveAll(Arrays.asList(catServ1, catServ2, catServ3));
		servicoRepository.saveAll(Arrays.asList(serv1));
		
	}
}
