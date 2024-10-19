package br.com.loteriasweb.service;

import br.com.loteriasweb.dto.ResultadosDTO;
import br.com.loteriasweb.dto.LoteriasDTO;
import java.util.List;

/**
 * Interface de implementação da classe responsável pela comunicação
 * com a loteriascaixa-api para consulta de informações das loterias.
 * 
 * @author Felipe Nascimento
 *
 */

public interface ConsultarLoteriaService {
	
	/**
	 * Assinatura do método responsável por gerar a lista de todos os resultados
	 * pela loteria informada e pelo concurso informado.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * @param numeroConcurso - {@link String} - número do concurso para busca
	 * 
	 * @return lista de resultados
	 * 
	 */
	public List<ResultadosDTO> buscarResultadosLoteriaPorConcurso(String loteria, String numeroConcurso);
	
	/**
	 * Assinatura do método responsável por gerar a lista do último resultado pela loteria informada.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * 
	 * @return lista de resultados
	 * 
	 */
	public List<ResultadosDTO> buscarResultadoRecentePorLoteria(String loteria);
	
	/**
	 * Assinatura do método responsável por gerar a lista de todos os resultados pela loteria informada.
	 * 
	 * @param loteria - {@link String} - descrição da loteria para busca (Ex.: lotofacil)
	 * 
	 * @return lista de resultados
	 * 
	 */
	public List<ResultadosDTO> buscarResultadosPorLoteria(String loteria);
	
	/**
	 * Assinatura do método responsável por gerar a lista de todas as loterias.
	 * 
	 * @return lista de loterias
	 * 
	 */
	public List<LoteriasDTO> buscarLoterias();
	
}