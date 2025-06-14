package br.com.loteriasweb.exception;

import jakarta.faces.event.ExceptionQueuedEventContext;
import jakarta.faces.application.ViewExpiredException;
import jakarta.faces.context.ExceptionHandlerWrapper;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.FacesContext;
import jakarta.faces.FacesException;
import java.io.Serializable;
import java.util.Map;

/**
 * Classe handler responsável pelo tratamento das exceções.
 * 
 * @author Felipe Nascimento
 *
 */

public class CustomExceptionHandler extends ExceptionHandlerWrapper implements Serializable {
	private static final long serialVersionUID = -2675998920925459907L;
	private transient FacesContext facesContext = FacesContext.getCurrentInstance();
	private transient NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
	private transient Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
	private transient ExceptionHandler exceptionHandler;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param exceptionHandler - {@link ExceptionHandler} - manipulador
	 * 
	 */
	@SuppressWarnings("deprecation")
	public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}
	
	/**
	 * Método responbsável pela manipulação e customização das exceções.
	 */
	@Override
	public void handle() throws FacesException {
		
		var iterator = getUnhandledExceptionQueuedEvents().iterator();
		var exceptionMessage = "";
		
		while (iterator.hasNext()) {
			
			var eqe = iterator.next();
			
			var eqec = (ExceptionQueuedEventContext) eqe.getSource();
			
			var throwable = eqec.getException();
			
			if (throwable instanceof ViewExpiredException) {
				
				exceptionMessage = "Sua sessão está expirada. Atualize a página.";
				
			} else {
				
				exceptionMessage = throwable.getMessage();
				
			}
			
			try {
				
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
	
	/**
	 * Retorna o atributo exceptionHandler.
	 * 
	 * @return o manipulador das exceções do tipo {@link ExceptionHandler}.
	 * 
	 */
	@Override
	public ExceptionHandler getWrapped() {
		return exceptionHandler;
	}
	
}