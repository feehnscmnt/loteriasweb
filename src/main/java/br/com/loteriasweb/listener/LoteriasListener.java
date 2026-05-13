package br.com.loteriasweb.listener;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.ServletRequestEvent;
import java.io.Serializable;

/**
 * Classe responsável pelo ciclo de vida da aplicação.
 * 
 * @author Felipe Nascimento
 * 
 */

@WebListener
public class LoteriasListener implements ServletRequestListener, Serializable {
	private static final long serialVersionUID = 343355122830110466L;

	/**
	 * Método responsável pela inicialização das requisições HTTP.
	 */
	@Override
    public void requestInitialized(ServletRequestEvent sre) {
		
		var httpServletRequest = (HttpServletRequest) sre.getServletRequest();
		httpServletRequest.setAttribute("horaInicio", System.currentTimeMillis());
		
	}
	
	/**
	 * Método responsável pela finalização das requisições HTTP.
	 */
	@Override
    public void requestDestroyed(ServletRequestEvent sre) {
		
		var httpServletRequest = (HttpServletRequest) sre.getServletRequest();
		httpServletRequest.removeAttribute("horaInicio");
		
	}
	
}