package br.com.loteriasweb.exception;

import javax.faces.context.ExceptionHandlerFactory;
import javax.faces.context.ExceptionHandler;
import java.io.Serializable;

/**
 * Classe factory responsável por criar a instância da classe que fará o tratamento das exceções.
 * 
 * @author Felipe Nascimento
 *
 */

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory implements Serializable {
	private static final long serialVersionUID = 1974923816270876214L;
	private transient ExceptionHandlerFactory exceptionHandlerFactory;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param exceptionHandlerFactory - {@link ExceptionHandlerFactory} - gerenciador de exceções
	 * 
	 */
	@SuppressWarnings("deprecation")
	public CustomExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
		this.exceptionHandlerFactory = exceptionHandlerFactory;
	}
	
	/**
	 * Método responsável por capturar, gerenciar e customizar as exceções.
	 */
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new CustomExceptionHandler(exceptionHandlerFactory.getExceptionHandler());
	}
	
}