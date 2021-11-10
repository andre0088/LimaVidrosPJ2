package com.limaVidros.gerenciamento.domain.exception;

public class IdExistenteException extends Exception{

	public IdExistenteException() {
		super("Esse id já foi cadastrado no sistema!");
	}
	
}
