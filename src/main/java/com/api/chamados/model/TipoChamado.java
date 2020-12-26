package com.api.chamados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoChamado {

	@Id
	@Column(name = "id_tipo_chamado", nullable = false, updatable = false)
	private int idTipoChamado;

	@Column(nullable = false, updatable = false)
	private String descricao;
	
	public TipoChamado() {
		super();
	}

	public int getIdTipoChamado() {
		return idTipoChamado;
	}

	public void setIdTipoChamado(int idTipoChamado) {
		this.idTipoChamado = idTipoChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
