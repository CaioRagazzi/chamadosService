package com.api.tcdChamados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusChamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
