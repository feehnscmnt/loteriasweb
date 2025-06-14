package br.com.loteriasweb.domain;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.MissingResourceException;
import br.com.loteriasweb.util.Util;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * Classe responsável pela leitura do properties contendo as chaves (keys) com as mensagens aos usuários.
 * 
 * @author Felipe Nascimento
 * 
 */

@Named
@ApplicationScoped
public class Bundle implements Serializable {
	private static final long serialVersionUID = -5241075687755823863L;
	
	@Inject
	private Util util;
	
	/**
	 * Método responsável pela obtenção da chave do endpoint no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém o endpoint
	 * 
	 * @return endpoint da loteriascaixa-api
	 * 
	 */
	public String getChaveEndpoint(String key) {
		
		try {
			
			return ResourceBundle.getBundle(util.getResourceEndpoints(), Locale.of("pt", "BR")).getString(key);
			
		} catch (MissingResourceException | NullPointerException e) {
			
			throw new IllegalArgumentException(e.getMessage(), e.getCause());
			
		}
		
	}
	
	/**
	 * Método responsável pela obtenção da chave do endpoint com parâmetros no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém o endpoint
	 * @param params - {@link String} - parâmetros que serão inclusos na chave
	 * 
	 * @return endpoint da loteriascaixa-api
	 * 
	 */
	public String getChaveEndpointComParametro(String key, Object ... params) {
		
		return new MessageFormat(ResourceBundle.getBundle(util.getResourceEndpoints(), Locale.of("pt", "BR")).getString(key)).format(params);
		
	}
	
}