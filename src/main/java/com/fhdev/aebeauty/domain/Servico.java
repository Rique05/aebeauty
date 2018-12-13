package com.fhdev.aebeauty.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String nome;
	private Double valor;
	private Date tempoExecucao;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_servico_id")
	private CategoriaServico categoria;
	
	@OneToMany(mappedBy = "servico")
	private List<AgendaServico> agendasServicos = new ArrayList<>(); 
	
	public Servico() {
	}

	public Servico(Integer id, String nome, Double valor, Date tempoExecucao, String descricao, CategoriaServico categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.tempoExecucao = tempoExecucao;
		this.descricao = descricao;
		this.categoria = categoria;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(Date tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public CategoriaServico getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaServico categoria) {
		this.categoria = categoria;
	}

	public List<AgendaServico> getAgendasServicos() {
		return agendasServicos;
	}

	public void setAgendasServicos(List<AgendaServico> agendasServicos) {
		this.agendasServicos = agendasServicos;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
