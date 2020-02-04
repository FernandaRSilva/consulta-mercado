package com.desafio.consumindoapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler({ConsumingErrorException.class})
	public ResponseEntity<ExceptionData> ConsumingErrorHandler(ConsumingErrorException e, WebRequest request) {
		log.error("Erro ao consumir API externa!");
		ExceptionData exceptionData = new ExceptionData(e.getMessage(), new Date());
		return new ResponseEntity<ExceptionData>(exceptionData, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
