package com.api.chamados;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.chamados.dao.ChamadosDAO;
import com.api.chamados.model.Chamado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Chamados")
@RequestMapping(value = "v1/chamados")
public class ChamadosController {
	
	private static ChamadosDAO db = new ChamadosDAO();
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/service-instances/{applicationName}", method = RequestMethod.GET)
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@ApiOperation(value = "Abre um novo chamado")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String abrirChamado(@RequestBody Chamado chamado) {

		return db.criarChamado(chamado.getUserId(), chamado.getTipo(), chamado.getDescricao());
	}
	
	@ApiOperation(value = "Lista os chamados de um usuário")
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public ArrayList<Chamado> listarChamados(@PathVariable("userId") int userId) throws Exception {

		return db.listarChamados(userId);
	}

	@ApiOperation(value = "Detalhes de um chamado")
	@RequestMapping(value = "{userId}/{numero}", method = RequestMethod.GET)
	public Chamado getChamado(@PathVariable("userId") int userId, @PathVariable("numero") int numero) throws Exception {

		return db.detalhesChamado(numero, userId);
	}

	@ApiOperation(value = "Altera o status de um chamado")
	@RequestMapping(value = "", method = RequestMethod.PATCH)
	public void alterarStatus(@RequestBody Chamado chamado) throws Exception {

		db.alterarChamado(chamado.getNumero(), chamado.getStatus());
	}
}
