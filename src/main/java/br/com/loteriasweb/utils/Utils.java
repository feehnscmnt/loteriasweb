package br.com.loteriasweb.utils;

import java.util.Properties;

/**
 * Interface de implementação da classe de utilidades do software.
 * 
 * @author Felipe Nascimento
 *
 */

public interface Utils {
	
	/**
	 * Método responsável pela inicialização do log.
	 */
	public void initLog();
	
	/**
	 * Método responsável por obter as propriedades de conexão com a loteriascaixa-api.
	 * 
	 * @return propriedades obtidades no arquivo props.properties
	 * 
	 */
	public Properties getProperties();
	
	/**
	 * Método responsável pela obtenção do arquivo de mensageria do software.
	 * 
	 * @return caminho do arquivo de mensageria
	 * 
	 */
	public String getResourceMessage();
	
	/**
	 * Método responsável pela obtenção do arquivo de endpoints da loteriascaixa-api.
	 * 
	 * @return caminho do arquivo de endpoints
	 * 
	 */
	public String getResourceEndpoints();
	
	/**
	 * Método responsável pelo processo de encoder em Strings espaçadas.
	 * 
	 * @param str - {@link String} que será processada
	 * 
	 * @return String processada
	 * 
	 */
	public String encodeString(String str);
	
	/**
	 * Método responsável pela descrição das loterias disponíveis.
	 * 
	 * @return descrição das loterias
	 * 
	 */
	public String[] getLotteryDescription();
	
	/**
	 * Método responsável por modificar o nome da loteria vindo da loteriascaixa-api.
	 * 
	 * @param loteria - {@link String} - loteria que terá o nome modificado
	 * 
	 * @return novo nome da loteria
	 * 
	 */
	public String alterLotteryName(String loteria);
	
	/**
	 * Método responsável por obter a cor que simboliza a loteria.
	 * 
	 * @param loteria - {@link String} - loteria que terá a cor incluída
	 * 
	 * @return a cor da loteria
	 * 
	 */
	public String getBackcolorLoterias(String loteria);
	
	/**
	 * Método responsável por obter a informação de acúmulo das loterias.
	 * 
	 * @param acumulou - {@link Boolean} - informação de acúmulo da loteria
	 * 
	 * @return informação em {@link String}
	 * 
	 */
	public String getAccumulated(Boolean acumulou);
	
}