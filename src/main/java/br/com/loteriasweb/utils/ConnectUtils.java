package br.com.loteriasweb.utils;

/**
 * Interface de implementação da classe responsável pela comunicação com a loteriascaixa-api.
 * 
 * @author Felipe Nascimento
 *
 */

public interface ConnectUtils {
	
	/**
	 * Método responsável por se comunicar com a loteriascaixa-api e obter o response das requisições.
	 * 
	 * @param urlApi - {@link String} - URL da API
	 * @param headerKey - {@link String} - chave do cabeçalho da requisição
	 * @param headerValue - {@link String} - valor do cabeçalho da requisição
	 * @param method - {@link String} - método da requisição
	 * 
	 * @return response da API em formato JSON
	 * 
	 */
	public String getResponseApi(String urlApi, String headerKey, String headerValue, String method);
	
}