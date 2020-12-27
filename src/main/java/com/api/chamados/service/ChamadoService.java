package com.api.chamados.service;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.api.chamados.exception.ChamadoNotFoundException;
import com.api.chamados.exception.InvalidStatusException;
import com.api.chamados.exception.UserNotFoundException;
import com.api.chamados.model.Chamado;
import com.api.chamados.model.ChamadoTemplate;
import com.api.chamados.model.StatusChamado;
import com.api.chamados.repository.ChamadoRepository;

@Service
@ComponentScan("com.api.chamados.repository")
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;

//	@HystrixCommand(fallbackMethod = "createChamadoCircuitBreaker", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public Chamado createChamado(ChamadoTemplate chamadoTp) {
		Chamado chamado = new Chamado();
		StatusChamado statusChamado = new StatusChamado();
		statusChamado.setIdStatusChamado(1);
		statusChamado.setDescricao("");

		chamado.setUserId(chamadoTp.getUserId());
		chamado.setTipoChamado(chamadoTp.getTipoChamado());
		chamado.setDescricao(chamadoTp.getDescricao());
		chamado.setStatusChamado(statusChamado);
		chamado.setDataAbertura(new Date(System.currentTimeMillis()));

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

	public Collection<Chamado> getChamadosByUserId(int userId) {

		Collection<Chamado> chamados = chamadoRepository.findByUserId(userId);

		if (!chamados.isEmpty()) {
			return chamados;

		} else {
			throw new UserNotFoundException();
		}
	}

	public Chamado updateStatus(int numeroChamado, int status) {

		if (numeroChamado > 0) {
			Optional<Chamado> c = getChamadoById(numeroChamado);
			Chamado chamado = c.get();

			if (status > 0) {
				StatusChamado st = new StatusChamado();
				st.setIdStatusChamado(status);
				chamado.setStatusChamado(st);
			} else {
				throw new InvalidStatusException();
			}

			return chamadoRepository.save(chamado);

		} else {
			throw new ChamadoNotFoundException();
		}
	}
}
