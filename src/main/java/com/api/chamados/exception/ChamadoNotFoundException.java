package com.api.chamados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Chamado not found")
public class ChamadoNotFoundException extends RuntimeException {

}