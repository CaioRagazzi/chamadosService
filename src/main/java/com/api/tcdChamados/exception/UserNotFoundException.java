package com.api.tcdChamados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Usuário não possui chamados")
public class UserNotFoundException extends RuntimeException {

}
