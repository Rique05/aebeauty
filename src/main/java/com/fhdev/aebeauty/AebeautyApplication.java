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
		
		
		
	}
}
