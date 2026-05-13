package br.com.loteriasweb.service;

import jakarta.enterprise.context.ApplicationScoped;
import br.com.loteriasweb.dto.ResultadosDTO;
import br.com.loteriasweb.util.ConnectUtil;
import jakarta.annotation.PostConstruct;
import br.com.loteriasweb.domain.Bundle;
import br.com.loteriasweb.util.Util;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Comparator;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe service responsável pela comunicação com a loteriascaixa-api para consulta de resultados.
 * 
 * @author Felipe Nascimento
 * 
 */

@Named
@ApplicationScoped
public class ConsultarLoteriaService implements Serializable {
	private static final long serialVersionUID = 3515077755575764230L;
	private String headerValueAccept;
	private String headerKeyAccept;
	private String methodGet;
	private String urlApi;
	
	@Inject
	private ConnectUtil connect;
	
	@Inject
	private Bundle bundle;
	
	@Inject
	private Util util;
	
	/**
	 * Método responsável pela inicialização das propriedades.
	 */
	@PostConstruct
	public void init() {
		var properties = util.getProperties();
		headerValueAccept = properties.getProperty("HEADER_VALUE_ACCEPT");
		headerKeyAccept = properties.getProperty("HEADER_KEY_ACCEPT");
		urlApi = properties.getProperty("URL_LOTERIASCAIXA_API");
		methodGet = properties.getProperty("METHOD_GET");
	}
	
	/**
	 * Implementação do método responsável por gerar o array contendo todas as loterias.
	 * 
	 * @return lista de loterias
	 * 
	 */
	public String[] buscarLoterias() {
		
		var endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_TODAS_LOTERIAS");
		
		var responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		var loterias = new Gson().fromJson(responseApi, String[].class);
		
		Arrays.sort(loterias);
		
		return loterias;
		
	}
	
	/**
	 * Implementação do método responsável por gerar a lista do último resultado pela loteria informada.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * 
	 * @return lista de resultados
	 * 
	 */
	public List<ResultadosDTO> buscarResultadoRecentePorLoteria(String loteria) {
		
		var listaResultados = new ArrayList<ResultadosDTO>();
		
		var endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_RESULTADO_LOTERIA_RECENTE", loteria);
		
		var responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		var dadosResultadosDTO = new Gson().fromJson(responseApi, ResultadosDTO.class);
		
		dadosResultadosDTO.setLoteria(util.alterLotteryName(loteria));
		dadosResultadosDTO.setBackcolorLoterias(util.getBackcolorLoterias(loteria));
		dadosResultadosDTO.setStrAcumulou(util.getAccumulated(dadosResultadosDTO.getAcumulou()));
		
		listaResultados.add(dadosResultadosDTO);
		
		listaResultados.sort(Comparator.comparing(ResultadosDTO::getLoteria));
		
		return listaResultados;
		
	}
	
	/**
	 * Implementação do método responsável por gerar a lista de todos os resultados
	 * pela loteria informada e pelo concurso informado.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * @param numeroConcurso - {@link String} - número do concurso para busca
	 * 
	 * @return lista de resultados
	 * 
	 */
	public List<ResultadosDTO> buscarResultadosLoteriaPorConcurso(String loteria, String numeroConcurso) {
		
		var listaResultados = new ArrayList<ResultadosDTO>();
		
		var endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_RESULTADO_LOTERIA_CONCURSO", loteria, numeroConcurso);
		
		var responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		var dadosResultadosDTO = new Gson().fromJson(responseApi, ResultadosDTO.class);
		
		dadosResultadosDTO.setLoteria(util.alterLotteryName(loteria));
		dadosResultadosDTO.setBackcolorLoterias(util.getBackcolorLoterias(loteria));
		dadosResultadosDTO.setStrAcumulou(util.getAccumulated(dadosResultadosDTO.getAcumulou()));
		
		listaResultados.add(dadosResultadosDTO);
		
		listaResultados.sort(Comparator.comparing(ResultadosDTO::getLoteria));
		
		return listaResultados;
		
	}
	
	/**
	 * Implementação do método responsável por gerar a lista de todos os resultados pela loteria informada.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * 
	 * @return lista de resultados
	 * 
	 */
	public List<ResultadosDTO> buscarResultadosPorLoteria(String loteria) {
		
		var listaResultados = new ArrayList<ResultadosDTO>();
		
		var endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_RESULTADO_LOTERIA_ESPECIFICA", loteria);
		
		var responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		var dadosResultadosDTO = new Gson().fromJson(responseApi, ResultadosDTO.class);
		
		dadosResultadosDTO.setLoteria(util.alterLotteryName(loteria));
		dadosResultadosDTO.setBackcolorLoterias(util.getBackcolorLoterias(loteria));
		dadosResultadosDTO.setStrAcumulou(util.getAccumulated(dadosResultadosDTO.getAcumulou()));
		
		listaResultados.add(dadosResultadosDTO);
		
		listaResultados.sort(Comparator.comparing(ResultadosDTO::getLoteria));
		
		return listaResultados;
		
	}
	
}