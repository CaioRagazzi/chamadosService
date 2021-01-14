package com.api.tcdChamados.service;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.api.tcdChamados.exception.ChamadoNotFoundException;
import com.api.tcdChamados.exception.InvalidStatusException;
import com.api.tcdChamados.exception.InvalidTypeException;
import com.api.tcdChamados.exception.UserNotFoundException;
import com.api.tcdChamados.model.Chamado;
import com.api.tcdChamados.model.ChamadoTemplate;
import com.api.tcdChamados.model.StatusChamado;
import com.api.tcdChamados.repository.ChamadoRepository;

@Service
@ComponentScan("com.api.chamados.repository")
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;

	public Chamado createChamado(ChamadoTemplate chamadoTp) {

		if (chamadoTp.getTipoChamado().getIdTipoChamado() > 0 && chamadoTp.getTipoChamado().getIdTipoChamado() < 3) {
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
		} else {
			throw new InvalidTypeException();
		}
	}

	public Optional<Chamado> getChamadoById(int idChamado, int userId) {

		Optional<Chamado> chamado = chamadoRepository.findById(idChamado);

		if (chamado.isPresent()) {
			if (chamado.get().getUserId() == userId) {
				return chamado;
			}
		}
		throw new ChamadoNotFoundException();
	}

	public Collection<Chamado> getChamadosByUserId(int userId) {

		Collection<Chamado> chamados = chamadoRepository.findByUserId(userId);

		if (!chamados.isEmpty()) {
			return chamados;

		} else {
			throw new UserNotFoundException();
		}
	}

	public Chamado updateStatus(Chamado chamado) {
		
		int numeroChamado = chamado.getIdChamado();
		int status = chamado.getStatusChamado().getIdStatusChamado();
		int userId = chamado.getUserId();

		if (numeroChamado > 0 && userId > 0) {
			Optional<Chamado> c = getChamadoById(numeroChamado, userId);
			Chamado chamadoObj = c.get();

			if (status > 0 && status < 5) {
				StatusChamado st = new StatusChamado();
				st.setIdStatusChamado(status);
				chamadoObj.setStatusChamado(st);
			} else {
				throw new InvalidStatusException();
			}
			return chamadoRepository.save(chamadoObj);

		} else {
			throw new ChamadoNotFoundException();
		}
	}
}
