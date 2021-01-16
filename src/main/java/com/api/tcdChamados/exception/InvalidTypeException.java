package com.api.tcdChamados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Tipo inválido")
public class InvalidTypeException extends RuntimeException {

}
