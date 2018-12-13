package com.fhdev.aebeauty;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fhdev.aebeauty.domain.AgendaServico;
import com.fhdev.aebeauty.domain.CategoriaProduto;
import com.fhdev.aebeauty.domain.CategoriaServico;
import com.fhdev.aebeauty.domain.Cidade;
import com.fhdev.aebeauty.domain.Endereco;
import com.fhdev.aebeauty.domain.Estado;
import com.fhdev.aebeauty.domain.Produto;
import com.fhdev.aebeauty.domain.Servico;
import com.fhdev.aebeauty.domain.Usuario;
import com.fhdev.aebeauty.domain.enums.StatusAgenda;
import com.fhdev.aebeauty.repositories.AgendaServicoRepository;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;
import com.fhdev.aebeauty.repositories.CategoriaServicoRepository;
import com.fhdev.aebeauty.repositories.CidadeRepository;
import com.fhdev.aebeauty.repositories.EnderecoRepository;
import com.fhdev.aebeauty.repositories.EstadoRepository;
import com.fhdev.aebeauty.repositories.ProdutoRepository;
import com.fhdev.aebeauty.repositories.ServicoRepository;
import com.fhdev.aebeauty.repositories.UsuarioRepository;

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
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AgendaServicoRepository agendaServicoRepository;
	
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
		CategoriaServico catServ4 = new CategoriaServico(null, "Rolinho");
		
		//formato definido para a hora média gasta para a realização do serviço
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Servico serv1 = new Servico(null, "Escova Pequena", 20.00, sdf.parse("0000-00-00 1:30"), "Escova para cabelos pequenos.", catServ1);
		Servico serv2 = new Servico(null, "Escova Grande", 40.00, sdf.parse("0000-00-00 2:30"), "Escova para cabelos grandes", catServ1);
		Servico serv3 = new Servico(null, "Corte Pequeno", 25.00, sdf.parse("0000-00-00 1:00"), "Corte para cabelos pequenos", catServ3);
		Servico serv4 = new Servico(null, "Relaxamento", 20.00, sdf.parse("0000-00-00 2:30"), "Relaxamento", catServ2);
		
		catServ1.getServicos().addAll(Arrays.asList(serv1, serv2)); //pega a lista de servicos da categoria e preenche com uma lista de serviços instanciados 
		catServ2.getServicos().addAll(Arrays.asList(serv4));
		catServ3.getServicos().addAll(Arrays.asList(serv3));
		
		categoriaServicoRepository.saveAll(Arrays.asList(catServ1, catServ2, catServ3));
		servicoRepository.saveAll(Arrays.asList(serv1, serv2, serv3, serv4));
		
		//Instâncias de Cidade e Estado
		
		//Cidade
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		//Estado
		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		Cidade c3 = new Cidade(null, "Ouro Preto", est1);
		Cidade c4 = new Cidade(null, "Santos", est2);
		
		//Atribuição das cidadees aos estados
		est1.getCidades().addAll(Arrays.asList(c1,c3));
		est2.getCidades().addAll(Arrays.asList(c2,c4));
		
		//Salva os objetos no banco de dados através dos objetos estadoRepository e cidadeRepository
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		//Instâncias de usuários e endereços
		Usuario user1 = new Usuario(null,"Fanuel Pereira","fanuel@gmail.com","Xiaomi@15");

		Endereco end1 = new Endereco(null, "Rua Antonio Jose Ramos","180","Casa","Bauxita","35400-000",c3, user1);
				
		user1.getEnderecos().addAll(Arrays.asList(end1));
		
		Usuario user2 = new Usuario (null,"Lila Dias","aline@gmail.com","Lila@13");
		
		Endereco end2 = new Endereco(null, "Rua Jacarandá", "300", "Apartamento", "Fortes", "62451-002", c4, user2);
		Endereco end3 = new Endereco(null,"Rua Pelé", "1000", "Casa","Baixada Santista","64585-003", c4, user2);
		
		user2.getEnderecos().addAll(Arrays.asList(end2, end3));
		
		//Adicionando os telefones dos usuários
		
		//preenche a lista de telefones com o array gerado por Arrays.asList através do método addAll
		user1.getTelefones().addAll(Arrays.asList("3199248-6568","313456-2801")); 
		user2.getTelefones().addAll(Arrays.asList("3199556-2405", "313456-2801"));
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		
		//Instância de agenda de servico
		//formato da data e hora da agenda
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		//Serviço instanciado para exemplo
		Servico serv5 = new Servico(null, "Rolinho Grande", 20.00, sdf.parse("0000-00-00 2:10"), "Rolinho para cabelos grandes", catServ4);
		
		//Adiciona o serviço serv5 à lista da serviços da categoria catServ4
		catServ4.getServicos().addAll(Arrays.asList(serv5));
		
		//Instância da agenda
		AgendaServico agenda1 = new AgendaServico(null, sdf1.parse("2018-12-13 08:00"), StatusAgenda.toEnum(1) , serv5);
		
		//Adiciona a agenda agenda1 à lista de agendas do serviço serv5
		serv5.getAgendasServicos().addAll(Arrays.asList(agenda1));
		
		//Vincula a agenda1 ao usuário user1
		user2.getAgendasServicos().addAll(Arrays.asList(agenda1));
		
		//Muda o status da agenda para status 2 "Pendente"
		agenda1.setStatus(StatusAgenda.toEnum(2));
		
		//Vincula o usuario user1 à agenda 1
		agenda1.setUsuario(user2);
				
		//Salva as instâncias no banco de dados
		categoriaServicoRepository.saveAll(Arrays.asList(catServ4));
		servicoRepository.saveAll(Arrays.asList(serv5));
		agendaServicoRepository.saveAll(Arrays.asList(agenda1));
		
	}
}
