package com.fhdev.aebeauty.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fhdev.aebeauty.domain.enums.TipoFuncionario;

@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registroFuncionario;
	private Integer tipoFuncionario;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Funcionario() {		
	}

	public Funcionario(Integer registroFuncionario, TipoFuncionario tipoFuncionario, Usuario usuario) {
		super();
		this.registroFuncionario = registroFuncionario;
		this.tipoFuncionario = tipoFuncionario.getCodigo();
		this.usuario = usuario;
	}

	public Integer getRegistroFuncionario() {
		return registroFuncionario;
	}

	public void setRegistroFuncionario(Integer registroFuncionario) {
		this.registroFuncionario = registroFuncionario;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registroFuncionario == null) ? 0 : registroFuncionario.hashCode());
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
		if (registroFuncionario == null) {
			if (other.registroFuncionario != null)
				return false;
		} else if (!registroFuncionario.equals(other.registroFuncionario))
			return false;
		return true;
	}
	
}
