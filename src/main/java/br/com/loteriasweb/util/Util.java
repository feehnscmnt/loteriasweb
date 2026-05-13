package br.com.loteriasweb.util;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.UnsupportedEncodingException;
import jakarta.faces.context.FacesContext;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.http.HttpSession;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Properties;
import java.net.URLEncoder;
import java.io.IOException;
import java.util.Objects;

/**
 * Classe de utilidades da aplicação.
 * 
 * @author Felipe Nascimento
 *
 */

@Named
@ApplicationScoped
public class Util implements Serializable {
	private static final long serialVersionUID = 7055711649044567049L;
	
	/**
	 * Método responsável por obter as propriedades de conexão com a loteriascaixa-api.
	 * 
	 * @return propriedades obtidas no arquivo props.properties
	 * 
	 */
	public Properties getProperties() {
		
		var properties = new Properties();
		
		try (var inStream = FacesContext.getCurrentInstance()
				.getExternalContext().getResourceAsStream("/WEB-INF/configs/props.properties")) {
			
			properties.load(inStream);
			
		} catch (IOException e) {
			
			throw new IllegalArgumentException(e.getMessage(), e.getCause());
			
		}
		
		return properties;
		
	}
	
	/**
	 * Método responsável pela obtenção do arquivo de endpoints da loteriascaixa-api.
	 * 
	 * @return caminho do arquivo de endpoints
	 * 
	 */
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
	public String encodeString(String str) {
		
		try {
			
			return URLEncoder.encode(!Objects.equals(str, "") ? str : "", String.valueOf(StandardCharsets.UTF_8)).replace("+", "%20");
			
		} catch (UnsupportedEncodingException e) {
			
			throw new IllegalArgumentException(e.getMessage(), e.getCause());
			
		}
		
	}
	
	/**
	 * Método responsável pela descrição das loterias disponíveis.
	 * 
	 * @return descrição das loterias
	 * 
	 */
	public String[] getLotteryDescription() {
		
		return new String [] {
			
			"maismilionaria",
			"megasena",
			"lotofacil",
			"quina",
			"lotomania",
			"timemania",
			"duplasena",
			"federal",
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
	public String alterLotteryName(String loteria) {
		
		if (Objects.equals(loteria, getLotteryDescription()[0])) {
			
			return "+ Milionária";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[1])) {
			
			return "Mega Sena";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[2])) {
			
			return "Lotofácil";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[3])) {
			
			return "Quina";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[4])) {
			
			return "Lotomania";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[5])) {
			
			return "Timemania";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[6])) {
			
			return "Dupla Sena";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[7])) {
			
			return "Federal";
			
		}  else if (Objects.equals(loteria, getLotteryDescription()[8])) {
			
			return "Dia de Sorte";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[9])) {
			
			return "Super Sete";
			
		}
		
		return null;
		
	}
	
	/**
	 * Método responsável por obter a cor que simboliza a loteria.
	 * 
	 * @param loteria - {@link String} - loteria que terá a cor incluída
	 * 
	 * @return a cor da loteria
	 * 
	 */
	public String getBackcolorLoterias(String loteria) {
		
		if (Objects.equals(loteria, getLotteryDescription()[0])) {
			
			return "backcolor-maismilionaria";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[1])) {
			
			return "backcolor-megasena";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[2])) {
			
			return "backcolor-lotofacil";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[3])) {
			
			return "backcolor-quina";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[4])) {
			
			return "backcolor-lotomania";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[5])) {
			
			return "backcolor-timemania";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[6])) {
			
			return "backcolor-duplasena";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[7])) {
			
			return "backcolor-federal";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[8])) {
			
			return "backcolor-diadesorte";
			
		} else if (Objects.equals(loteria, getLotteryDescription()[9])) {
			
			return "backcolor-supersete";
			
		}
		
		return null;
		
	}
	
	/**
	 * Método responsável por obter a informação de acúmulo das loterias.
	 * 
	 * @param acumulou - {@link Boolean} - informação de acúmulo da loteria
	 * 
	 * @return informação em {@link String}
	 * 
	 */
	public String getAccumulated(Boolean acumulou) {
		
		return acumulou != false ? "ACUMULOU" : "NÃO ACUMULOU";
		
	}
	
	/**
	 * Método responsável por setar o tempo de inativação da sessão.
	 */
	public void timerSession() {
		
		((HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(true)).setMaxInactiveInterval(1800);
		
	}
	
	/**
	 * Método responsável por colocar String em caixa baixa
	 * e com a primeira letra de cada palavra em maiúscula.
	 * 
	 * @param str - String que será tratada
	 * 
	 * @return String tratada
	 * 
	 */
	public String capitalizeString(String str) {
		
		var capitalizedString = new StringBuilder();
		var words = str.toLowerCase().split(" ");
		
		for (var i = 0; i < words.length; i++) {
			
			var word = words[i];
			
			if (word.isEmpty()) {
				
                capitalizedString.append(" ");
                continue;
                
            }

            capitalizedString.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
            
            if (i < words.length - 1) {
            	
                capitalizedString.append(" ");
                
            }
			
		}
		
		return String.valueOf(capitalizedString);
		
	}
	
}