package com.fhdev.aebeauty.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fhdev.aebeauty.domain.enums.StatusAgenda;

@Entity
public class AgendaServico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataHora;
	
	//Modificado (Na construção passamos um inteiro e o método getStatus retorna um objeto StatusAgenda)
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	public AgendaServico() {
		
	}

	public AgendaServico(Integer id, Date dataHora, StatusAgenda status, Servico servico) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.status = status.getCodigo();
		this.servico = servico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public StatusAgenda getStatus() {
		return StatusAgenda.toEnum(status);
	}

	public void setStatus(StatusAgenda status) {
		this.status = status.getCodigo();
	}
	
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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
		AgendaServico other = (AgendaServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
