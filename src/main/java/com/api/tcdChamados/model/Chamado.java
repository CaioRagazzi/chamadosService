package com.api.tcdChamados.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_chamado", updatable = false, nullable = false)
	private int idChamado;

	@Column(nullable = false, name = "user_id")
	private Integer userId;

	@ManyToOne
	@JoinColumn(name = "id_tipo_chamado", nullable = false)
	private TipoChamado tipoChamado;

	@Column(nullable = false, length = 500)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_status_chamado", nullable = false)
	private StatusChamado statusChamado;

	@Column(name = "data_abertura", nullable = false)
	private Date dataAbertura;

	public Chamado() {
		super();
	}

	public Chamado(@JsonProperty("idChamado") int idChamado, @JsonProperty("userId") int userId,
			@JsonProperty("tipoChamado") TipoChamado tipoChamado, @JsonProperty("descricao") String descricao,
			@JsonProperty("statusChamado") StatusChamado statusChamado, @JsonProperty("dataAbertura") Date dataAbertura) {

		super();

		this.idChamado = idChamado;
		this.userId = userId;
		this.tipoChamado = tipoChamado;
		this.descricao = descricao;
		this.statusChamado = statusChamado;
		this.dataAbertura = dataAbertura;
	}

	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int id_chamado) {
		this.idChamado = id_chamado;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TipoChamado getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(TipoChamado idTipoChamado) {
		this.tipoChamado = idTipoChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusChamado getStatusChamado() {
		return this.statusChamado;
	}

	public void setStatusChamado(StatusChamado statusChamado) {
		this.statusChamado = statusChamado;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
}
