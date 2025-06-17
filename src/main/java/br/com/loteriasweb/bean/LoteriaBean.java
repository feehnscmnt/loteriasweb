package br.com.loteriasweb.bean;

import br.com.loteriasweb.service.ConsultarLoteriaService;
import org.primefaces.model.ResponsiveOption;
import br.com.loteriasweb.dto.ResultadosDTO;
import br.com.loteriasweb.dto.LoteriasDTO;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import br.com.loteriasweb.util.Util;
import org.primefaces.PrimeFaces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Objects;
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
	private transient ResultadosDTO resultadoConcurso = new ResultadosDTO();
	private List<ResponsiveOption> listaRespOptions = new ArrayList<>();
	private List<ResultadosDTO> listaResultados = new ArrayList<>();
	private List<ResultadosDTO> listaResultConc = new ArrayList<>();
	private List<LoteriasDTO> listaLoterias = new ArrayList<>();
	private String concurso;
	private String loteria;
	
	@Inject
	private ConsultarLoteriaService consLoterService;
	
	@Inject
	private Util util;
	
	/**
	 * Método responsável pela inicialização das listas de resultados recentes das loterias.
	 */
	public void init() {
		
		util.timerSession();
		
		var arrayLoterias = consLoterService.buscarLoterias();
		
		Arrays.stream(arrayLoterias).forEach(loteria -> {
			
			listaLoterias.add(new LoteriasDTO(loteria, util.alterLotteryName(loteria)));
			
		});
		
		listaLoterias.forEach(loteria -> {
			
			if (!Objects.equals(loteria.getNomeOriginal(), arrayLoterias[2])) {
				
				var resultados = consLoterService.buscarResultadoRecentePorLoteria(loteria.getNomeOriginal());
				
				listaResultados.addAll(resultados);
				
			}
			
		});
		
		listaRespOptions.add(new ResponsiveOption("1024px", 3, 3));
		listaRespOptions.add(new ResponsiveOption("768px", 2, 2));
		listaRespOptions.add(new ResponsiveOption("560px", 1, 1));
		
	}
	
	/**
	 * Método responsável pela inicialização da lista de resultados das loterias por concurso.
	 */
	public void buscarResultadosLoteriaPorConcurso() {
		
		listaResultConc = consLoterService.buscarResultadosLoteriaPorConcurso(loteria, concurso);
		
		listaResultConc.forEach(loteria -> {
			
			resultadoConcurso.setLoteria(loteria.getLoteria());
			resultadoConcurso.setConcurso(loteria.getConcurso());
			resultadoConcurso.setData(loteria.getData());
			resultadoConcurso.setLocal(util.capitalizeString(loteria.getLocal()));
			resultadoConcurso.setDezenasOrdemSorteio(loteria.getDezenasOrdemSorteio());
			resultadoConcurso.setDezenas(loteria.getDezenas());
			resultadoConcurso.setTrevos(loteria.getTrevos());
			resultadoConcurso.setTimeCoracao(loteria.getTimeCoracao());
			resultadoConcurso.setMesSorte(loteria.getMesSorte());
			resultadoConcurso.setPremiacoes(loteria.getPremiacoes());
			resultadoConcurso.setEstadosPremiados(loteria.getEstadosPremiados());
			resultadoConcurso.setObservacao(loteria.getObservacao());
			resultadoConcurso.setAcumulou(loteria.getAcumulou());
			resultadoConcurso.setStrAcumulou(util.capitalizeString(loteria.getStrAcumulou()));
			resultadoConcurso.setProximoConcurso(loteria.getProximoConcurso());
			resultadoConcurso.setDataProximoConcurso(loteria.getDataProximoConcurso());
			resultadoConcurso.setLocalGanhadores(loteria.getLocalGanhadores());
			resultadoConcurso.setValorArrecadado(loteria.getValorArrecadado());
			resultadoConcurso.setValorAcumuladoConcurso05(loteria.getValorAcumuladoConcurso05());
			resultadoConcurso.setValorAcumuladoConcursoEspecial(loteria.getValorAcumuladoConcursoEspecial());
			resultadoConcurso.setValorAcumuladoProximoConcurso(loteria.getValorAcumuladoProximoConcurso());
			resultadoConcurso.setValorEstimadoProximoConcurso(loteria.getValorEstimadoProximoConcurso());
			resultadoConcurso.setBackcolorLoterias(loteria.getBackcolorLoterias());
			
		});
		
		PrimeFaces.current().executeScript("PF('dialogDetailsResultConc').show()");
		
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
	 * Retorna o atributo resultadoConcurso.
	 * 
	 * @return o objeto do resultado por concurso do tipo {@link ResultadosDTO}.
	 * 
	 */
	public ResultadosDTO getResultadoConcurso() {
		return resultadoConcurso;
	}
	
	/**
	 * Especifica o atributo resultadoConcurso.
	 * .
	 * @param resultadoConcurso {@link ResultadosDTO} referente ao objeto do resultado por concurso que será setado.
	 * 
	 */
	public void setResultadoConcurso(ResultadosDTO resultadoConcurso) {
		this.resultadoConcurso = resultadoConcurso;
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
	 * Retorna o atributo listaResultConc.
	 * 
	 * @return a lista de resultados das loterias por concurso do tipo {@link List}.
	 * 
	 */
	public List<ResultadosDTO> getListaResultConc() {
		return listaResultConc;
	}
	
	/**
	 * Especifica o atributo listaResultConc.
	 * .
	 * @param listaResultConc {@link List} referente à lista de resultados das loterias por concurso que será setada.
	 * 
	 */
	public void setListaResultConc(List<ResultadosDTO> listaResultConc) {
		this.listaResultConc = listaResultConc;
	}
	
	/**
	 * Retorna o atributo listaLoterias.
	 * 
	 * @return a lista de loterias disponíveis do tipo {@link List}.
	 * 
	 */
	public List<LoteriasDTO> getListaLoterias() {
		return listaLoterias;
	}
	
	/**
	 * Especifica o atributo listaLoterias.
	 * .
	 * @param listaLoterias {@link List} referente à lista de loterias disponíveis que será setada.
	 * 
	 */
	public void setListaLoterias(List<LoteriasDTO> listaLoterias) {
		this.listaLoterias = listaLoterias;
	}
	
	/**
	 * Retorna o atributo concurso.
	 * 
	 * @return o número do concurso do tipo {@link String}.
	 * 
	 */
	public String getConcurso() {
		return concurso;
	}
	
	/**
	 * Especifica o atributo concurso.
	 * .
	 * @param concurso {@link String} referente ao número do concurso que será setado.
	 * 
	 */
	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}
	
	/**
	 * Retorna o atributo loteria.
	 * 
	 * @return a loteria selecionada do tipo {@link String}.
	 * 
	 */
	public String getLoteria() {
		return loteria;
	}
	
	/**
	 * Especifica o atributo loteria.
	 * .
	 * @param loteria {@link String} referente à loteria selecionada que será setada.
	 * 
	 */
	public void setLoteria(String loteria) {
		this.loteria = loteria;
	}
	
}