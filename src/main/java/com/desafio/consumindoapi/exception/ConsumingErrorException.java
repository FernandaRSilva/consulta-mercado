package com.desafio.consumindoapi.exception;

public class ConsumingErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	public ConsumingErrorException(String msg) {
		super(msg);
	}
}
