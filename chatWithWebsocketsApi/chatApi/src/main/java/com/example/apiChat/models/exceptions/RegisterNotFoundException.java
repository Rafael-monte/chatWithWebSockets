package com.example.apiChat.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "REGISTRO NAO ENCONTRADO")
public class RegisterNotFoundException extends Exception{

	/**
	 * Represents a Not Found value
	 */
	private static final long serialVersionUID = -7234154114060257977L;
	

}
