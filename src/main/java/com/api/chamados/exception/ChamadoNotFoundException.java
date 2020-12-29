package com.api.chamados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Chamado não encontrado")
public class ChamadoNotFoundException extends RuntimeException {

}