package br.com.loteriasweb.bean;

import br.com.loteriasweb.service.ConsultarLoteriaService;
import org.primefaces.model.ResponsiveOption;
import br.com.loteriasweb.dto.ResultadosDTO;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import br.com.loteriasweb.domain.Bundle;
import br.com.loteriasweb.utils.Utils;
import org.apache.log4j.LogManager;
import javax.faces.view.ViewScoped;
import org.apache.log4j.Logger;
import java.io.Serializable;
import java.io.IOException;
import javax.inject.Inject;
import java.util.ArrayList;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

/**
 * Classe bean responsável pelas funções da tela de loterias.
 * 
 * @author Felipe Nascimento
 * 
 */

@Named
@ViewScoped
public class LoteriaBean implements Serializable {
	private static final Logger LOG = LogManager.getLogger(LoteriaBean.class.getName());
	private static final long serialVersionUID = -8825364807788515339L;
	
	private transient ResultadosDTO resultadoSelecionado = new ResultadosDTO();
	
	private List<ResultadosDTO> listaResultados = new ArrayList<>();
	private List<ResponsiveOption> listaRespOptions;
	
	private ConsultarLoteriaService consLoterService;
	private Bundle bundle;
	private Utils utils;
	
	/**
	 * Construtor da classe parametrizado para injeção dos serviços.
	 * 
	 * @param consLoterService - {@link ConsultarLoteriaService} - serviço de consulta dos resultados das loterias
	 * @param bundle - {@link Bundle} - serviço de internacionalização da aplicação
	 * @param utils - {@link Utils} - serviço de utilidades da aplicação
	 * 
	 */
	@Inject
	public LoteriaBean(ConsultarLoteriaService consLoterService, Bundle bundle, Utils utils) {
		this.consLoterService = consLoterService;
		this.bundle = bundle;
		this.utils = utils;
	}
	
	/**
	 * Método responsável pela inicialização das listas de resultados recentes das loterias.
	 */
	public void init() {
		utils.initLog();
		
		Arrays.stream(utils.getLotteryDescription()).forEach(loteria -> {
			List<ResultadosDTO> resultados = consLoterService.buscarResultadoRecentePorLoteria(loteria);
			listaResultados.addAll(resultados);
		});
		
		listaRespOptions = new ArrayList<>();
		listaRespOptions.add(new ResponsiveOption("1024px", 3, 3));
		listaRespOptions.add(new ResponsiveOption("768px", 2, 2));
		listaRespOptions.add(new ResponsiveOption("560px", 1, 1));
	}
	
	/**
	 * Método responsável pelo redirecionamento para a página loterias.
	 */
	public void redirectPageLoterias() {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath().concat("/loterias"));
		} catch(IOException e) {
			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "redirectPageLoterias", e.getClass().getName(), e.getMessage()));
			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "redirectPageLoterias", e.getClass().getName(), e.getMessage()));
		}
	}
	
	/**
	 * Retorna o atributo resultadoSelecionado.
	 * 
	 * @return o objeto do resultado selecionado do tipo {@link ResultadosDTO}.
	 * 
	 */
	public ResultadosDTO getResultadoSelecionado() {
		return resultadoSelecionado;
	}
	
	/**
	 * Especifica o atributo resultadoSelecionado.
	 * .
	 * @param resultadoSelecionado {@link ResultadosDTO} referente ao objeto do resultado selecionado que será setado.
	 * 
	 */
	public void setResultadoSelecionado(ResultadosDTO resultadoSelecionado) {
		this.resultadoSelecionado = resultadoSelecionado;
	}
	
	/**
	 * Retorna o atributo listaResultados.
	 * 
	 * @return a lista de resultados das loterias disponíveis do tipo {@link List}.
	 * 
	 */
	public List<ResultadosDTO> getListaResultados() {
		return listaResultados;
	}
	
	/**
	 * Especifica o atributo listaResultados.
	 * .
	 * @param listaResultados {@link List} referente à lista de resultados das loterias disponíveis que será setada.
	 * 
	 */
	public void setListaResultados(List<ResultadosDTO> listaResultados) {
		this.listaResultados = listaResultados;
	}
	
	/**
	 * Retorna o atributo listaRespOptions.
	 * 
	 * @return a lista de opções responsivas do tipo {@link List}.
	 * 
	 */
	public List<ResponsiveOption> getListaRespOptions() {
		return listaRespOptions;
	}
	
	/**
	 * Especifica o atributo listaRespOptions.
	 * .
	 * @param listaRespOptions {@link List} referente à lista de opções responsivas que será setada.
	 * 
	 */
	public void setListaRespOptions(List<ResponsiveOption> listaRespOptions) {
		this.listaRespOptions = listaRespOptions;
	}
	
}