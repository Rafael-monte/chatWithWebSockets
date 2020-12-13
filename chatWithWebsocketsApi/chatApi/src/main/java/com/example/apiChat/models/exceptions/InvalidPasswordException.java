package com.example.apiChat.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Senha invalida!")
public class InvalidPasswordException extends Exception{

	/**
	 * Represents an Invalid Password Exception
	 */
	private static final long serialVersionUID = 6710094119061463358L;

}
