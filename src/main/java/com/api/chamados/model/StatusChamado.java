package com.api.chamados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatusChamado {

	
	@Id
	@Column(name = "id_status_chamado", nullable = false, updatable = false)
	private int idStatusChamado;

	@Column(nullable = false, updatable = false)
	private String descricao;
	
	public StatusChamado() {
		super();
	}

	public int getIdStatusChamado() {
		return idStatusChamado;
	}

	public void setIdStatusChamado(int idStatusChamado) {
		this.idStatusChamado = idStatusChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
