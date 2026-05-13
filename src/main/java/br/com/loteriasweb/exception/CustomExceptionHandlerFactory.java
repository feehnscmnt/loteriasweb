package br.com.loteriasweb.exception;

import jakarta.faces.context.ExceptionHandlerFactory;
import jakarta.faces.context.ExceptionHandler;

/**
 * Classe factory responsável por criar a instância da classe que fará o tratamento das exceções.
 * 
 * @author Felipe Nascimento
 *
 */

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param exceptionHandlerFactory - {@link ExceptionHandlerFactory} - gerenciador de exceções
	 * 
	 */
	public CustomExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
		super(exceptionHandlerFactory);
	}
	
	/**
	 * Método responsável por capturar, gerenciar e customizar as exceções.
	 */
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new CustomExceptionHandler(getWrapped().getExceptionHandler());
	}
	
}