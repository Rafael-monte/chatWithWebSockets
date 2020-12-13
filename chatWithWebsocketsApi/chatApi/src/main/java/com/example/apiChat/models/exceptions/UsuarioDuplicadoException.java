package com.example.apiChat.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Usuario duplicado!")
public class UsuarioDuplicadoException extends Exception{

	/**
	 * Response for an duplicated user
	 */
	private static final long serialVersionUID = 43673675630133375L;

}
