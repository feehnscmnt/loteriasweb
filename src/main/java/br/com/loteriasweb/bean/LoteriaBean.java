package br.com.loteriasweb.bean;

import br.com.loteriasweb.service.ConsultarLoteriaService;
import org.primefaces.model.ResponsiveOption;
import br.com.loteriasweb.dto.ResultadosDTO;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import br.com.loteriasweb.util.Util;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;
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
	private static final long serialVersionUID = -1203378132360807839L;
	private transient ResultadosDTO resultadoSelecionado = new ResultadosDTO();
	private List<ResponsiveOption> listaRespOptions = new ArrayList<>();
	private List<ResultadosDTO> listaResultados = new ArrayList<>();
	
	@Inject
	private ConsultarLoteriaService consLoterService;
	
	@Inject
	private Util util;
	
	/**
	 * Método responsável pela inicialização das listas de resultados recentes das loterias.
	 */
	public void init() {
		
		util.timerSession();
		
		Arrays.stream(util.getLotteryDescription()).forEach(loteria -> {
			
			var resultados = consLoterService.buscarResultadoRecentePorLoteria(loteria);
			listaResultados.addAll(resultados);
			
		});
		
		listaRespOptions.add(new ResponsiveOption("1024px", 3, 3));
		listaRespOptions.add(new ResponsiveOption("768px", 2, 2));
		listaRespOptions.add(new ResponsiveOption("560px", 1, 1));
		
	}
	
	/**
	 * Método responsável pelo redirecionamento para a página loterias.
	 */
	public void redirectPageLoterias() {
		
		try {
			
			var ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(String.format("%s/loterias", ec.getRequestContextPath()));
			
		} catch (IOException e) {
			
			throw new IllegalArgumentException(e.getMessage(), e.getCause());
			
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