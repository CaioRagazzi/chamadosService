package com.api.chamados.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.api.chamados.model.Chamado;
import com.api.chamados.model.ChamadoTemplate;
import com.api.chamados.repository.ChamadoRepository;
import com.api.chamados.exception.ChamadoNotFoundException;

@Service
@ComponentScan("com.api.chamados.repository")
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;

	public Chamado createChamado(ChamadoTemplate chamadoTp) {
		
		Chamado chamado = new Chamado();
		chamado.setUserId(chamadoTp.getUserId());
		chamado.setTipo(chamadoTp.getTipo());
		chamado.setDescricao(chamadoTp.getDescricao());
		chamado.setStatus(1);
		chamado.setData_abertura(new Date(System.currentTimeMillis()));

		return chamadoRepository.save(chamado);
	}

	public Optional<Chamado> getChamadoById(int idChamado) {
		
		Optional<Chamado> chamado = chamadoRepository.findById(idChamado);
		
		if (chamado.isPresent()) {
			return chamado;
		} else {
			throw new ChamadoNotFoundException();
		}
	}
}
