package br.com.loteriasweb.exception;

import javax.faces.event.ExceptionQueuedEventContext;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.application.NavigationHandler;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.FacesContext;
import javax.faces.FacesException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe handler responsável pelo tratamento das exceções.
 * 
 * @author Felipe Nascimento
 *
 */

public class CustomExceptionHandler extends ExceptionHandlerWrapper implements Serializable {
	private transient FacesContext facesContext = FacesContext.getCurrentInstance();
	private transient NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
	private transient Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
	private static final long serialVersionUID = 4735652115221699044L;
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
		
		Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents().iterator();
		String exceptionMessage = null;
		
		while (iterator.hasNext()) {
			
			ExceptionQueuedEvent eqe = iterator.next();
			
			ExceptionQueuedEventContext eqec = (ExceptionQueuedEventContext) eqe.getSource();
			
			Throwable throwable = eqec.getException();
			
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