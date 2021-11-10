package com.limaVidros.gerenciamento.domain.exception;

public class LoginInvalidoException extends Exception{

	public LoginInvalidoException() {
		super("Login ou senha inválido.");
	}
	
}
