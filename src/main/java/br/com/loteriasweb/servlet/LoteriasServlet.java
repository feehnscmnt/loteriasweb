package br.com.loteriasweb.servlet;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;

/**
 * Classe responsável pela resposta do cliente, apresentando a tela loterias.
 * 
 * @author Felipe Nascimento
 * 
 */

@WebServlet("/loterias")
public class LoteriasServlet extends HttpServlet {
	private static final long serialVersionUID = 2548883314126133577L;
	
	/**
	 * Método responsável pela manipulação de solicitações GET no servidor.
	 * 
	 * @param req - {@link HttpServletRequest}
	 * @param resp - {@link HttpServletResponse}
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			req.getRequestDispatcher("/pages/loterias/loterias.xhtml").forward(req, resp);
			
		} catch (IOException | ServletException e) {
			
			throw new IllegalArgumentException(e.getMessage(), e.getCause());
			
		}
		
	}
	
}