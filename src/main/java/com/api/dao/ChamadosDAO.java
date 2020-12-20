package com.api.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.api.database.DbConfig;
import com.api.model.Chamado;

public class ChamadosDAO {

	public String criarChamado(int userId, int tipo, String descricao) {
		try {
			Connection conn = DbConfig.getConnection();

			String sql = "INSERT INTO chamados(id_usuario, fk_tipo, descricao, fk_status, data_abertura) VALUES(?,?,?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
			statement.setInt(2, tipo);
			statement.setString(3, descricao);
			statement.setInt(4, 1);
			statement.setDate(5, new Date(System.currentTimeMillis()));

			statement.executeUpdate();

			sql = "SELECT MAX(id_chamado) FROM chamados WHERE id_usuario = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			String numChamado = rs.getString("MAX(id_chamado)");

			return "Chamado criado com sucesso. Número: " + numChamado;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Chamado> listarChamados(int userId) throws Exception {

		try {
			Connection conn = DbConfig.getConnection();

			String sql = "SELECT * FROM chamados WHERE id_usuario = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);

			ResultSet rs = statement.executeQuery();

			ArrayList<Chamado> listaChamados = new ArrayList<Chamado>();

			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setNumero(rs.getInt("id_chamado"));
				chamado.setUserId(rs.getInt("id_usuario"));
				chamado.setTipo(rs.getInt("fk_tipo"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getInt("fk_status"));
				chamado.setData_abertura(rs.getDate("data_abertura"));

				listaChamados.add(chamado);
			}

			return listaChamados;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public Chamado detalhesChamado(int numeroChamado, int userId) throws Exception {
		try {
			Connection conn = DbConfig.getConnection();

			String sql = "SELECT * FROM chamados WHERE id_chamado = ? AND id_usuario = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, numeroChamado);
			statement.setInt(2, userId);

			ResultSet rs = statement.executeQuery();

			Chamado chamado = new Chamado();

			while (rs.next()) {

				chamado.setNumero(rs.getInt("id_chamado"));
				chamado.setUserId(rs.getInt("id_usuario"));
				chamado.setTipo(rs.getInt("fk_tipo"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getInt("fk_status"));
				chamado.setData_abertura(rs.getDate("data_abertura"));
			}

			return chamado;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public void alterarChamado(int numeroChamado, int status) {

		if (numeroChamado > 0 && status > 0) {
			try {
				Connection conn = DbConfig.getConnection();

				String sql = "UPDATE chamados SET fk_status = ? WHERE id_chamado = ?";

				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, status);
				statement.setInt(2, numeroChamado);

				statement.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}