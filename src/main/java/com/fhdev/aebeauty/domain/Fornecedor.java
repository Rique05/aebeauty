package com.fhdev.aebeauty.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String cnpj;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	@MapsId
	private Usuario usuario;
	
	@OneToMany(mappedBy = "fornecedor")
	private List<CompraProdutoFornecedor> comprasProduto = new ArrayList<>();
	
	public Fornecedor () {		
	}

	public Fornecedor(Integer id, String cnpj, Usuario usuario) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<CompraProdutoFornecedor> getComprasProduto() {
		return comprasProduto;
	}

	public void setComprasProduto(List<CompraProdutoFornecedor> comprasProduto) {
		this.comprasProduto = comprasProduto;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
