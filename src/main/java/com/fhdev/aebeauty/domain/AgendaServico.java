package com.fhdev.aebeauty.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public AgendaServico() {
		
	}

	public AgendaServico(Integer id, Date dataHora, StatusAgenda status) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.status = status.getCodigo();
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
		
}
