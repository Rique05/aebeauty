package com.fhdev.aebeauty.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double preco;
	private Integer quantidadeDisponivel;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_produto_id")
	private CategoriaProduto categoria;
	
	//Set garante que não haverá items repetidos na coleção items
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")//mapeado pelo atributo composto id
	private Set<ItemPedido> itens= new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<CompraProduto> comprasProdutos = new ArrayList<>();
	
	public Produto() {		
	}

	public Produto(Integer id, String nome, Double preco, Integer quantidadeDisponivel, CategoriaProduto categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.categoria = categoria;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		
		List<Pedido> lista = new ArrayList<>();
		for(ItemPedido x : itens) {
			
			lista.add(x.getPedido());	
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setValor(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public List<CompraProduto> getComprasProdutos() {
		return comprasProdutos;
	}

	public void setComprasProdutos(List<CompraProduto> comprasProduto) {
		this.comprasProdutos = comprasProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
