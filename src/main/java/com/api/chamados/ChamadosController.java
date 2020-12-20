package com.api.chamados;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.ChamadosDAO;
import com.api.model.Chamado;

@RestController
@RequestMapping(value = "v1/chamados")
public class ChamadosController {

	public static ChamadosDAO db = new ChamadosDAO();
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String abrirChamado(@RequestBody Chamado chamado) {

		return db.criarChamado(chamado.getUserId(), chamado.getTipo(), chamado.getDescricao());
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public ArrayList<Chamado> listarChamados(@PathVariable("userId") int userId) throws Exception {

		return db.listarChamados(userId);
	}

	@RequestMapping(value = "{userId}/{numero}", method = RequestMethod.GET)
	public Chamado getChamado(@PathVariable("userId") int userId, @PathVariable("numero") int numero) throws Exception {

		return db.detalhesChamado(numero, userId);
	}

	@RequestMapping(value = "", method = RequestMethod.PATCH)
	public void alterarStatus(@RequestBody Chamado chamado) throws Exception {

		db.alterarChamado(chamado.getNumero(), chamado.getStatus());
	}
}
