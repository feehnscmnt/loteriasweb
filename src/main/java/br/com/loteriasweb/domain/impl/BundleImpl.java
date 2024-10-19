package br.com.loteriasweb.domain.impl;

import javax.enterprise.context.ApplicationScoped;
import java.util.MissingResourceException;
import br.com.loteriasweb.domain.Bundle;
import br.com.loteriasweb.utils.Utils;
import org.apache.log4j.LogManager;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import org.apache.log4j.Logger;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Locale;

/**
 * Classe responsável pela leitura do properties contendo as chaves (keys) com as mensagens aos usuários.
 * 
 * @author Felipe Nascimento
 * 
 */

@Named
@ApplicationScoped
public class BundleImpl implements Bundle, Serializable {
	private static final Logger LOG = LogManager.getLogger(BundleImpl.class.getName());
	private static final long serialVersionUID = -7109117412471939637L;
	private Utils utils;
	
	/**
	 * Construtor da classe parametrizado para injeção dos serviços.
	 * 
	 * @param utils - {@link Utils} - serviço de utilidades da aplicação
	 * 
	 */
	@Inject
	public BundleImpl(Utils utils) {
		this.utils = utils;
	}
	
	
	/**
	 * Método responsável pela obtenção da chave da mensagem no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém a mensagem
	 * 
	 * @return mensagem que será apresentada ao usuário
	 * 
	 */
	@Override
	public String getChaveMensagem(String key) {
		try {
			return ResourceBundle.getBundle(utils.getResourceMessage(), new Locale("pt", "BR")).getString(key);
		} catch(MissingResourceException | NullPointerException e) {
			LOG.error("Houve erro no método getChaveMensagem. Exception: ".concat(e.getClass().getName()).concat(" :: Message: ").concat(e.getMessage()));
			throw new IllegalArgumentException("Houve erro no método getChaveMensagem. Exception: ".concat(e.getClass().getName()).concat(" :: Message: ").concat(e.getMessage()));
		}
	}
	
	/**
	 * Método responsável pela obtenção da chave da mensagem com parâmetros no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém a mensagem
	 * @param params - {@link String} - parâmetros que serão inclusos na chave
	 * 
	 * @return mensagem que será apresentada ao usuário
	 * 
	 */
	@Override
	public String getChaveMensagemComParametro(String key, Object ... params) {
		String str = ResourceBundle.getBundle(utils.getResourceMessage(), new Locale("pt", "BR")).getString(key);
		MessageFormat messageFormat = new MessageFormat(str);
		return messageFormat.format(params);
	}
	
	/**
	 * Método responsável pela obtenção da chave do endpoint no .properties através da variável resourceBundle.
	 * 
	 * @param key - {@link String} - chave da propriedade que contém o endpoint
	 * 
	 * @return endpoint da loteriascaixa-api
	 * 
	 */
	@Override
	public String getChaveEndpoint(String key) {
		try {
			return ResourceBundle.getBundle(utils.getResourceEndpoints(), new Locale("pt", "BR")).getString(key);
		} catch(MissingResourceException | NullPointerException e) {
			LOG.error("Houve erro no método getChaveEndpoint. Exception: ".concat(e.getClass().getName()).concat(" :: Message: ").concat(e.getMessage()));
			throw new IllegalArgumentException("Houve erro no método getChaveEndpoint. Exception: ".concat(e.getClass().getName()).concat(" :: Message: ").concat(e.getMessage()));
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
	@Override
	public String getChaveEndpointComParametro(String key, Object ... params) {
		String str = ResourceBundle.getBundle(utils.getResourceEndpoints(), new Locale("pt", "BR")).getString(key);
		MessageFormat messageFormat = new MessageFormat(str);
		return messageFormat.format(params);
	}
	
}