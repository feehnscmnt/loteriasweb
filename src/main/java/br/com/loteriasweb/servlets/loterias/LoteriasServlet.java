package br.com.loteriasweb.servlets.loterias;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.Serializable;
import java.io.IOException;

/**
 * Classe responsável pela resposta do cliente, apresentando a tela loterias.
 * 
 * @author Felipe Nascimento
 * 
 */

@WebServlet("/loterias")
public class LoteriasServlet extends HttpServlet implements Serializable {
	private static final Logger LOG = LogManager.getLogger(LoteriasServlet.class.getName());
	private static final long serialVersionUID = 3376415950718955214L;
	
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
			LOG.error(String.format("Houve erro no método doGet. Exception: %s :: Message: %s", e.getClass().getName(), e.getMessage()));
		}
	}
	
}