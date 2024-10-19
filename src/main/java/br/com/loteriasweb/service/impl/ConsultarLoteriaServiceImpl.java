package br.com.loteriasweb.service.impl;

import br.com.loteriasweb.service.ConsultarLoteriaService;
import javax.enterprise.context.ApplicationScoped;
import br.com.loteriasweb.utils.ConnectUtils;
import br.com.loteriasweb.dto.ResultadosDTO;
import br.com.loteriasweb.dto.LoteriasDTO;
import br.com.loteriasweb.domain.Bundle;
import javax.annotation.PostConstruct;
import br.com.loteriasweb.utils.Utils;
import java.util.Properties;
import java.io.Serializable;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe service responsável pela comunicação com a loteriascaixa-api para consulta de resultados.
 * 
 * @author Felipe Nascimento
 * 
 */

@Named
@ApplicationScoped
public class ConsultarLoteriaServiceImpl implements ConsultarLoteriaService, Serializable {
	private static final long serialVersionUID = 3305648482238344072L;
	private String headerValueAccept;
	private String headerKeyAccept;
	private ConnectUtils connect;
	private String methodGet;
	private String urlApi;
	private Bundle bundle;
	private Utils utils;
	
	/**
	 * Construtor da classe parametrizado para injeção dos serviços.
	 * 
	 * @param connect - {@link ConnectUtils} - serviço de conexão com a loteriascaixa-api
	 * @param bundle - {@link Bundle} - serviço de internacionalização da aplicação
	 * @param utils - {@link Utils} - serviço de utilidades da aplicação
	 * 
	 */
	@Inject
	public ConsultarLoteriaServiceImpl(ConnectUtils connect, Bundle bundle, Utils utils) {
		this.connect = connect;
		this.bundle = bundle;
		this.utils = utils;
	}
	
	/**
	 * Método responsável pela inicialização das propriedades.
	 */
	@PostConstruct
	public void init() {
		Properties properties = utils.getProperties();
		headerValueAccept = properties.getProperty("HEADER_VALUE_ACCEPT");
		headerKeyAccept = properties.getProperty("HEADER_KEY_ACCEPT");
		urlApi = properties.getProperty("URL_LOTERIASCAIXA_API");
		methodGet = properties.getProperty("METHOD_GET");
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
	@Override
	public List<ResultadosDTO> buscarResultadosLoteriaPorConcurso(String loteria, String numeroConcurso) {
		List<ResultadosDTO> listaResultados = new ArrayList<>();
		
		String endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_RESULTADO_LOTERIA_CONCURSO", loteria, numeroConcurso);
		
		String responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		ResultadosDTO dadosResultadosDTO = new Gson().fromJson(responseApi, ResultadosDTO.class);
		
		listaResultados.add(dadosResultadosDTO);
		
		return listaResultados;
	}
	
	/**
	 * Implementação do método responsável por gerar a lista do último resultado pela loteria informada.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * 
	 * @return lista de resultados
	 * 
	 */
	@Override
	public List<ResultadosDTO> buscarResultadoRecentePorLoteria(String loteria) {
		List<ResultadosDTO> listaResultados = new ArrayList<>();
		
		String endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_RESULTADO_LOTERIA_RECENTE", loteria);
		
		String responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		ResultadosDTO dadosResultadosDTO = new Gson().fromJson(responseApi, ResultadosDTO.class);
		
		dadosResultadosDTO.setLoteria(utils.alterLotteryName(loteria));
		dadosResultadosDTO.setBackcolorLoterias(utils.getBackcolorLoterias(loteria));
		dadosResultadosDTO.setStrAcumulou(utils.getAccumulated(dadosResultadosDTO.getAcumulou()));
		
		listaResultados.add(dadosResultadosDTO);
		
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
	@Override
	public List<ResultadosDTO> buscarResultadosPorLoteria(String loteria) {
		List<ResultadosDTO> listaResultados = new ArrayList<>();
		
		String endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_RESULTADO_LOTERIA_ESPECIFICA", loteria);
		
		String responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		ResultadosDTO dadosResultadosDTO = new Gson().fromJson(responseApi, ResultadosDTO.class);
		
		listaResultados.add(dadosResultadosDTO);
		
		return listaResultados;
	}
	
	/**
	 * Implementação do método responsável por gerar a lista de todas as loterias.
	 * 
	 * @return lista de loterias
	 * 
	 */
	@Override
	public List<LoteriasDTO> buscarLoterias() {
		List<LoteriasDTO> listaLoterias = new ArrayList<>();
		
		String endpointConsulta = bundle.getChaveEndpointComParametro("ENDPOINT_TODAS_LOTERIAS");
		
		String responseApi = connect.getResponseApi(String.format("%s%s", urlApi, endpointConsulta), headerKeyAccept, headerValueAccept, methodGet);
		
		LoteriasDTO[] dadosLoterias = new Gson().fromJson(responseApi, LoteriasDTO[].class);
		
		for (LoteriasDTO dadosLoteriasDTO : dadosLoterias) {
			
			LoteriasDTO loteriasDTO = new LoteriasDTO();
			loteriasDTO.setLoterias(dadosLoteriasDTO.getLoterias());
			
			listaLoterias.add(loteriasDTO);
			
		}
		
		return listaLoterias;
	}
	
}