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

import com.fhdev.aebeauty.domain.enums.TipoFuncionario;

@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private Integer tipoFuncionario;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	@MapsId //Anotação necessária para o funcionário herdar o mesmo id do usuário dele	
	private Usuario usuario;
	
	@OneToMany(mappedBy = "funcionario")
	private List<AgendaServico> agendasServicos = new ArrayList<>();
	
	public Funcionario() {		
	}

	public Funcionario(Integer id, TipoFuncionario tipoFuncionario, Usuario usuario) {
		super();
		this.id = id;
		this.tipoFuncionario = tipoFuncionario.getCodigo();
		this.usuario = usuario;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoFuncionario getTipoFuncionario() {
		return TipoFuncionario.toEnum(tipoFuncionario);
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario.getCodigo();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
