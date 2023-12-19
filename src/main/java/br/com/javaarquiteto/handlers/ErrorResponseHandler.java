package br.com.javaarquiteto.handlers;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponseHandler {
	
	private HttpStatus status;
	private List<String> errors;

}
