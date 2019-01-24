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
import com.fhdev.aebeauty.domain.CompraProduto;
import com.fhdev.aebeauty.domain.Endereco;
import com.fhdev.aebeauty.domain.Estado;
import com.fhdev.aebeauty.domain.Fornecedor;
import com.fhdev.aebeauty.domain.Funcionario;
import com.fhdev.aebeauty.domain.ItemPedido;
import com.fhdev.aebeauty.domain.Pagamento;
import com.fhdev.aebeauty.domain.PagamentoCartao;
import com.fhdev.aebeauty.domain.Pedido;
import com.fhdev.aebeauty.domain.Produto;
import com.fhdev.aebeauty.domain.Servico;
import com.fhdev.aebeauty.domain.Usuario;
import com.fhdev.aebeauty.domain.enums.StatusAgenda;
import com.fhdev.aebeauty.domain.enums.StatusPagamento;
import com.fhdev.aebeauty.domain.enums.TipoFuncionario;
import com.fhdev.aebeauty.domain.enums.TipoServico;
import com.fhdev.aebeauty.repositories.AgendaServicoRepository;
import com.fhdev.aebeauty.repositories.CategoriaProdutoRepository;
import com.fhdev.aebeauty.repositories.CategoriaServicoRepository;
import com.fhdev.aebeauty.repositories.CidadeRepository;
import com.fhdev.aebeauty.repositories.CompraProdutoRepository;
import com.fhdev.aebeauty.repositories.EnderecoRepository;
import com.fhdev.aebeauty.repositories.EstadoRepository;
import com.fhdev.aebeauty.repositories.FornecedorRepository;
import com.fhdev.aebeauty.repositories.FuncionarioRepository;
import com.fhdev.aebeauty.repositories.ItemPedidoRepository;
import com.fhdev.aebeauty.repositories.PagamentoRepository;
import com.fhdev.aebeauty.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private CompraProdutoRepository compraProdutoRepository;
	
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
		CategoriaServico catServ3 = new CategoriaServico(null, "Unha");
		
		
		//formato definido para a hora média gasta para a realização do serviço
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		Servico serv1 = new Servico(null, "Escova Pequena", 20.00, sdf.parse("1:30"), "Escova para cabelos pequenos.", TipoServico.CABELO,catServ1);
		Servico serv2 = new Servico(null, "Escova Grande", 40.00, sdf.parse("2:30"), "Escova para cabelos grandes", TipoServico.CABELO,catServ1);
		Servico serv3 = new Servico(null, "Unha Francesa", 15.00, sdf.parse("1:00"), "Unha Francesa", TipoServico.UNHA ,catServ3);
		Servico serv4 = new Servico(null, "Relaxamento", 20.00, sdf.parse("2:30"), "Relaxamento", TipoServico.CABELO,catServ2);
		
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
		
		
		//Instância de CategoriaServico e Servico
		//formato da data e hora da agenda
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		
		//Categoria servico
		CategoriaServico catServ4 = new CategoriaServico(null, "Rolinho");
		
		//Serviço instanciado para exemplo
		Servico serv5 = new Servico(null, "Rolinho Grande", 20.00, sdf.parse("2:10"), "Rolinho para cabelos grandes", TipoServico.CABELO, catServ4);
		
		//Adiciona o serviço serv5 à lista da serviços da categoria catServ4
		catServ4.getServicos().addAll(Arrays.asList(serv5));
				
		//Salva as instâncias no banco de dados
		categoriaServicoRepository.saveAll(Arrays.asList(catServ4));
		servicoRepository.saveAll(Arrays.asList(serv5));
		
		//Instancias de Pedidos
		Usuario user3 = new Usuario(null,"Ermita", "ermita@teste.com","EGS123@");

		
		Pedido pedido1 = new Pedido(null, sdf1.parse("11-12-2018 07:00"), user2, end2);
		Pedido pedido2 = new Pedido(null, sdf1.parse("22-12-2018 08:00"), user2, end3);
		Pedido pedido3 = new Pedido(null, sdf1.parse("27-12-2018 13:00"), user1, end1);
		
		user2.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		user1.getPedidos().addAll(Arrays.asList(pedido3));
		
		usuarioRepository.save(user3);
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		//Instancia de Funcionario
		
		Usuario user4 = new Usuario(null, "Marly Santos", "marly_santos@teste.com","Ico2006");
		Funcionario func1 = new Funcionario(null,TipoFuncionario.GERENTE, user4);
		user4.setFuncionario(func1);
		
		Usuario user5 = new Usuario(null, "Aline Dias", "aline12@teste.com.br", "XB50");
		Funcionario func2 = new Funcionario(null,TipoFuncionario.MANICURE, user5);
		user5.setFuncionario(func2);
		
		usuarioRepository.saveAll(Arrays.asList(user4, user5));
		funcionarioRepository.saveAll(Arrays.asList(func1, func2));
		
		//Instancias de Pagamento
		Pedido pedido4 = new Pedido(null, sdf1.parse("29-12-2018 19:00"), user1, end1);
		//Pagamento do pedido4
		Pagamento pgto1 = new PagamentoCartao(null, StatusPagamento.PENDENTE, pedido4, 7);
		pedido4.setPagamento(pgto1);
		
		pedidoRepository.save(pedido4);
		pagamentoRepository.save(pgto1);
		
		//Instancias de fornecedor
		Usuario user6 = new Usuario(null,"Ricardo de Souza","ricardosz@teste.com","Ricdoz23");
		Fornecedor forn1 = new Fornecedor(null,"06.114.300/0001-13", user6);
		user6.setFornecedor(forn1);
		
		Usuario user7 = new Usuario(null, "Paulo Almeida", "pauloal@teste.com", "paulinhoDP");
		Fornecedor forn2 = new Fornecedor(null, "01.254.234/0001-11",user7);
		user7.setFornecedor(forn2);
		
		usuarioRepository.saveAll(Arrays.asList(user6, user7));
		fornecedorRepository.saveAll(Arrays.asList(forn1, forn2));
		
		//Funcionario - AgendaServico
		Usuario user8 = new Usuario(null,"Cintia Santos", "cintia@teste.com", "cintia123");
		Funcionario func3 = new Funcionario(null, TipoFuncionario.MANICURE, user8);
		user8.setFuncionario(func3);
		
		//Instancias das Agendas
		AgendaServico agenda3 = new AgendaServico(null, sdf1.parse("24-12-2018 19:30"), StatusAgenda.ABERTA, serv3, func3);
		AgendaServico agenda4 = new AgendaServico(null, sdf1.parse("24-12-2018 19:30"),StatusAgenda.ABERTA, serv1, func1);
		
		//Atribui o cliente que marcou a agenda4 (user2)
		agenda4.setUsuario(user2);
		
		usuarioRepository.saveAll(Arrays.asList(user8));
		funcionarioRepository.saveAll(Arrays.asList(func3));
		agendaServicoRepository.saveAll(Arrays.asList(agenda3, agenda4));
			
		//Instâncias dos itens de pedido
		
		Pedido pedido5 = new Pedido(null, sdf1.parse("25-12-2018 20:12"), user2, end1);
		ItemPedido item1 = new ItemPedido(pedido5, p1, 5.00, 5, 40.00);
		ItemPedido item2 = new ItemPedido(pedido5, p2, 10.00, 6, 70.00);
		
		pedido5.getItens().addAll(Arrays.asList(item1, item2));
		p1.getItens().addAll(Arrays.asList(item1));
		p2.getItens().addAll(Arrays.asList(item2));
		
		pedidoRepository.save(pedido5);
		itemPedidoRepository.saveAll(Arrays.asList(item1, item2));
		
		//Instâncias de CompraProdutoFornecedor
		Produto p4 = new Produto(null, "Dove", 20.00, 5, catProd2);
		CompraProduto compra1 = new CompraProduto(null, sdf1.parse("23-12-2018 22:03"), 15.00, 3, forn1, p4, func1);
		CompraProduto compra2 = new CompraProduto(null, sdf1.parse("25-12-2018 8:36"), 10.00, 6, forn1, p4, func3);
		
		p4.getComprasProdutos().addAll(Arrays.asList(compra1, compra2));
		forn1.getComprasProdutos().addAll(Arrays.asList(compra1,compra2));
		func3.getComprasProdutos().addAll(Arrays.asList(compra1,compra2));
		
		produtoRepository.save(p4);
		compraProdutoRepository.saveAll(Arrays.asList(compra1,compra2));
		
	}
}
