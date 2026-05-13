package br.com.loteriasweb.exception;

import jakarta.faces.event.ExceptionQueuedEventContext;
import jakarta.faces.application.ViewExpiredException;
import jakarta.faces.context.ExceptionHandlerWrapper;
import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.FacesContext;
import jakarta.faces.FacesException;

/**
 * Classe handler responsável pelo tratamento das exceções.
 * 
 * @author Felipe Nascimento
 *
 */

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param exceptionHandler - {@link ExceptionHandler} - manipulador
	 * 
	 */
	public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
		super(exceptionHandler);
	}
	
	/**
	 * Método responbsável pela manipulação e customização das exceções.
	 */
	@Override
	public void handle() throws FacesException {
		
		var iterator = getUnhandledExceptionQueuedEvents().iterator();
		var facesContext = FacesContext.getCurrentInstance();
		
		while (iterator.hasNext()) {
			
			var eqe = iterator.next();
			var eqec = (ExceptionQueuedEventContext) eqe.getSource();
			var throwable = eqec.getException();
			
			var exceptionMessage = (throwable instanceof ViewExpiredException) ? "Sua sessão expirou. Atualize a página." : throwable.getMessage();
			
			try {
				
				var navigationHandler = facesContext.getApplication().getNavigationHandler();
                var requestMap = facesContext.getExternalContext().getRequestMap();
				
				requestMap.put("exceptionMessage", exceptionMessage);
				requestMap.put("causeException", throwable.getCause());
				
				navigationHandler.handleNavigation(facesContext, null, "/pages/error/error");				
				facesContext.renderResponse();
				
			} finally {
				
				iterator.remove();
				
			}
			
		}
		
		getWrapped().handle();
		
	}
	
}