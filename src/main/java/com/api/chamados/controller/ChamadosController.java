package com.api.chamados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
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
	public Chamado createChamado(@RequestBody ChamadoTemplate chamado) {
		return chamadoService.createChamado(chamado);
	}

	@ApiOperation(value = "Retorna os detalhes de um chamado")
	@GetMapping(value = "{idChamado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Chamado> getChamadosById(@PathVariable("idChamado") int idChamado){
		return chamadoService.getChamadoById(idChamado);
	}
}
