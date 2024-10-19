package br.com.loteriasweb.domain;

/**
 * Interface de implementação da classe responsável pela leitura do properties contendo as chaves (keys) com as mensagens aos usuários.
 * 
 * @author Felipe Nascimento
 *
 */

public interface Bundle {
	
	/**
	 * Método responsável pela obtenção da chave da mensagem no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém a mensagem
	 * 
	 * @return mensagem que será apresentada ao usuário
	 * 
	 */
	public String getChaveMensagem(String key);
	
	/**
	 * Método responsável pela obtenção da chave da mensagem com parâmetros no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém a mensagem
	 * @param params - {@link String} - parâmetros que serão inclusos na chave
	 * 
	 * @return mensagem que será apresentada ao usuário
	 * 
	 */
	public String getChaveMensagemComParametro(String key, Object ... params);
	
	/**
	 * Método responsável pela obtenção da chave do endpoint no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém o endpoint
	 * 
	 * @return endpoint da loteriascaixa-api
	 * 
	 */
	public String getChaveEndpoint(String key);
	
	/**
	 * Método responsável pela obtenção da chave do endpoint com parâmetros no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém o endpoint
	 * @param params - {@link String} - parâmetros que serão inclusos na chave
	 * 
	 * @return endpoint da loteriascaixa-api
	 * 
	 */
	public String getChaveEndpointComParametro(String key, Object ... params);
	
}