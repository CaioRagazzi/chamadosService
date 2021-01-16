package com.api.tcdChamados.model;

public class ChamadoTemplate {

	private Integer userId;
	private TipoChamado tipoChamado;
	private String descricao;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TipoChamado getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(TipoChamado tipoChamado) {
		this.tipoChamado = tipoChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
