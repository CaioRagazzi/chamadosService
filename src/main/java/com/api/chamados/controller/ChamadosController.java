package com.api.chamados.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.chamados.model.Chamado;
import com.api.chamados.model.ChamadoTemplate;
import com.api.chamados.service.ChamadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Chamados")
@RestController
@ComponentScan("com.api.chamados.service")
@RequestMapping(value = "v1/chamados")
public class ChamadosController {

	@Autowired
	private ChamadoService chamadoService;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/service-instances/{applicationName}", method = RequestMethod.GET)
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@ApiOperation(value = "Abre um novo chamado")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Chamado> createChamado(@RequestBody ChamadoTemplate chamado) {
		return new ResponseEntity<Chamado>(chamadoService.createChamado(chamado), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Retorna os detalhes de um chamado")
	@GetMapping(value = "{userId}/{idChamado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Chamado>> getChamadosById(@PathVariable("idChamado") int idChamado){
		return new ResponseEntity<>(chamadoService.getChamadoById(idChamado), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Lista os chamados de um usuário")
	@RequestMapping(value = "{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Chamado> listarChamados(@PathVariable("userId") int userId) {
		return chamadoService.getChamadosByUserId(userId);
	}
	
	@ApiOperation(value = "Atualiza o status de um chamado")
	@RequestMapping(value = "", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public Chamado updateStatus(@RequestBody Chamado chamado) {
		return chamadoService.updateStatus(chamado.getIdChamado(), chamado.getStatusChamado().getIdStatusChamado());
	}
}
