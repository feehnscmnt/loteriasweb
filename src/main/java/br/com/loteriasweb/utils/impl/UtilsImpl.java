package br.com.loteriasweb.utils.impl;

import javax.enterprise.context.ApplicationScoped;
import org.apache.log4j.PropertyConfigurator;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import javax.faces.context.FacesContext;
import br.com.loteriasweb.domain.Bundle;
import br.com.loteriasweb.utils.Utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.Properties;
import java.io.Serializable;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe de utilidades da aplicação.
 * 
 * @author Felipe Nascimento
 *
 */

@Named
@ApplicationScoped
public class UtilsImpl implements Utils, Serializable {
	private static final Logger LOG = LogManager.getLogger(UtilsImpl.class.getName());
	private static final long serialVersionUID = 6728867668122500032L;
	private Bundle bundle;
	
	/**
	 * Construtor da classe parametrizado para injeção dos serviços.
	 * 
	 * @param bundle - {@link Bundle} - serviço de internacionalização da aplicação
	 * 
	 */
	@Inject
	public UtilsImpl(Bundle bundle) {
		this.bundle = bundle;
	}
	
	/**
	 * Método responsável pela inicialização do log.
	 */
	@Override
	public void initLog() {
		Properties properties = new Properties();
		
		try (InputStream is = FacesContext.getCurrentInstance()
				.getExternalContext().getResourceAsStream("/WEB-INF/configs/log4j.properties")) {
			properties.load(is);
		} catch(IOException e) {
			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "initLog", e.getClass().getName(), e.getMessage()));
			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "initLog", e.getClass().getName(), e.getMessage()));
		}
		
		PropertyConfigurator.configure(properties);
	}
	
	/**
	 * Método responsável por obter as propriedades de conexão com a loteriascaixa-api.
	 * 
	 * @return propriedades obtidas no arquivo props.properties
	 * 
	 */
	@Override
	public Properties getProperties() {
		Properties properties = new Properties();
		
		try (InputStream is = FacesContext.getCurrentInstance()
				.getExternalContext().getResourceAsStream("/WEB-INF/configs/props.properties")) {
			properties.load(is);
		} catch(IOException e) {
			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getProperties", e.getClass().getName(), e.getMessage()));
			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getProperties", e.getClass().getName(), e.getMessage()));
		}
		
		return properties;
	}
	
	/**
	 * Método responsável pela obtenção do arquivo de mensageria do software.
	 * 
	 * @return caminho do arquivo de mensageria
	 * 
	 */
	@Override
	public String getResourceMessage() {
		return "br/com/loteriasweb/bundle/messages";
	}
	
	/**
	 * Método responsável pela obtenção do arquivo de endpoints da loteriascaixa-api.
	 * 
	 * @return caminho do arquivo de endpoints
	 * 
	 */
	@Override
	public String getResourceEndpoints() {
		return "br/com/loteriasweb/bundle/endpoints";
	}
	
	/**
	 * Método responsável pelo processo de encoder em Strings espaçadas.
	 * 
	 * @param str - {@link String} que será processada
	 * 
	 * @return String processada
	 * 
	 */
	@Override
	public String encodeString(String str) {
		try {
			return URLEncoder.encode(!str.equals("") ? str : "", String.valueOf(StandardCharsets.UTF_8)).replace("+", "%20");
		} catch(UnsupportedEncodingException e) {
			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "encodeString", e.getClass().getName(), e.getMessage()));
			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "encodeString", e.getClass().getName(), e.getMessage()));
        }
	}
	
	/**
	 * Método responsável pela descrição das loterias disponíveis.
	 * 
	 * @return descrição das loterias
	 * 
	 */
	@Override
	public String[] getLotteryDescription() {
		return new String [] {
			"maismilionaria",
			"megasena",
			"lotofacil",
			"quina",
			"lotomania",
			"timemania",
			"duplasena",
			"diadesorte",
			"supersete"
		};
	}
	
	/**
	 * Método responsável por modificar o nome da loteria vindo da loteriascaixa-api.
	 * 
	 * @param loteria - {@link String} - loteria que terá o nome modificado
	 * 
	 * @return novo nome da loteria
	 * 
	 */
	@Override
	public String alterLotteryName(String loteria) {
		String novaLoteria = null;
		
		if (loteria.equals(getLotteryDescription()[0])) {
			
			novaLoteria = "+ Milionária";
			
		} else if (loteria.equals(getLotteryDescription()[1])) {
			
			novaLoteria = "Mega Sena";
			
		} else if (loteria.equals(getLotteryDescription()[2])) {
			
			novaLoteria = "Lotofácil";
			
		} else if (loteria.equals(getLotteryDescription()[3])) {
			
			novaLoteria = "Quina";
			
		} else if (loteria.equals(getLotteryDescription()[4])) {
			
			novaLoteria = "Lotomania";
			
		} else if (loteria.equals(getLotteryDescription()[5])) {
			
			novaLoteria = "Timemania";
			
		} else if (loteria.equals(getLotteryDescription()[6])) {
			
			novaLoteria = "Dupla Sena";
			
		} else if (loteria.equals(getLotteryDescription()[7])) {
			
			novaLoteria = "Dia de Sorte";
			
		} else if (loteria.equals(getLotteryDescription()[8])) {
			
			novaLoteria = "Super Sete";
			
		}
		
		return novaLoteria;
	}
	
	/**
	 * Método responsável por obter a cor que simboliza a loteria.
	 * 
	 * @param loteria - {@link String} - loteria que terá a cor incluída
	 * 
	 * @return a cor da loteria
	 * 
	 */
	@Override
	public String getBackcolorLoterias(String loteria) {
		String backcolor = null;
		
		if (loteria.equals(getLotteryDescription()[0])) {
			
			backcolor = "backcolor-maismilionaria";
			
		} else if (loteria.equals(getLotteryDescription()[1])) {
			
			backcolor = "backcolor-megasena";
			
		} else if (loteria.equals(getLotteryDescription()[2])) {
			
			backcolor = "backcolor-lotofacil";
			
		} else if (loteria.equals(getLotteryDescription()[3])) {
			
			backcolor = "backcolor-quina";
			
		} else if (loteria.equals(getLotteryDescription()[4])) {
			
			backcolor = "backcolor-lotomania";
			
		} else if (loteria.equals(getLotteryDescription()[5])) {
			
			backcolor = "backcolor-timemania";
			
		} else if (loteria.equals(getLotteryDescription()[6])) {
			
			backcolor = "backcolor-duplasena";
			
		} else if (loteria.equals(getLotteryDescription()[7])) {
			
			backcolor = "backcolor-diadesorte";
			
		} else if (loteria.equals(getLotteryDescription()[8])) {
			
			backcolor = "backcolor-supersete";
			
		}
		
		return backcolor;
	}
	
	/**
	 * Método responsável por obter a informação de acúmulo das loterias.
	 * 
	 * @param acumulou - {@link Boolean} - informação de acúmulo da loteria
	 * 
	 * @return informação em {@link String}
	 * 
	 */
	@Override
	public String getAccumulated(Boolean acumulou) {
		return acumulou != null ? "ACUMULOU" : "";
	}
	
}