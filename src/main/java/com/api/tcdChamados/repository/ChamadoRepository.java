package com.api.tcdChamados.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.api.tcdChamados.model.Chamado;

@Repository
@Component
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

	Collection<Chamado> findByUserId(int userId);
}
