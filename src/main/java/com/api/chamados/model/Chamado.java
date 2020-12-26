package com.api.chamados.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_chamado", updatable = false, nullable = false)
	private int id_chamado;

	@Column(nullable = false)
	private Integer user_id;

	@Column(nullable = false)
	private Integer tipo;

	@Column(nullable = false, length = 500)
	private String descricao;

	@Column(nullable = false)
	private int status;

	@Column(nullable = false)
	private Date data_abertura;

	public Chamado() {
		super();
	}

	public Chamado(@JsonProperty("idChamado") int id_chamado, @JsonProperty("userId") int user_id,
			@JsonProperty("tipo") int tipo, @JsonProperty("descricao") String descricao,
			@JsonProperty("status") int status, @JsonProperty("dataAbertura") Date data_abertura) {

		super();

		this.id_chamado = id_chamado;
		this.user_id = user_id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.status = status;
		this.data_abertura = data_abertura;
	}

	public int getIdChamado() {
		return id_chamado;
	}

	public void setIdChamado(int id_chamado) {
		this.id_chamado = id_chamado;
	}

	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}
}
