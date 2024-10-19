package br.com.loteriasweb.utils.impl;

import static java.util.stream.Collectors.joining;
import javax.enterprise.context.ApplicationScoped;
import br.com.loteriasweb.utils.ConnectUtils;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import br.com.loteriasweb.domain.Bundle;
import javax.net.ssl.X509TrustManager;
import org.apache.log4j.LogManager;
import java.security.SecureRandom;
import java.net.HttpURLConnection;
import javax.net.ssl.TrustManager;
import java.io.InputStreamReader;
import javax.net.ssl.SSLContext;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import java.net.URL;

/**
 * Classe responsável pela comunicação com a loteriascaixa-api.
 * 
 * @author Felipe Nascimento
 *
 */

@Named
@ApplicationScoped
public class ConnectUtilsImpl implements ConnectUtils, Serializable {
	private static final Logger LOG = LogManager.getLogger(ConnectUtilsImpl.class.getName());
	private static final long serialVersionUID = -261258333264235678L;
	private Bundle bundle;
	
	/**
	 * Construtor da classe parametrizado para injeção do serviço.
	 * 
	 * @param bundle - {@link Bundle} - serviço de internacionalização da aplicação
	 * 
	 */
	@Inject
	public ConnectUtilsImpl(Bundle bundle) {
		this.bundle = bundle;
	}
	
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
	@Override
	public String getResponseApi(String urlApi, String headerKey, String headerValue, String method) {
		StringBuilder sb = new StringBuilder();
		
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
	        sc.init(null, getTrustAllCerts(), new SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			HttpURLConnection huc = (HttpURLConnection) new URL(urlApi).openConnection();
			
			huc.setRequestProperty(headerKey, headerValue);
			huc.setRequestMethod(method);
			
			huc.connect();
			
			try (BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()))) {
                sb.append(br.lines().collect(joining()));
            }
			
			huc.disconnect();
		} catch(Exception e) {
			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getResponseApi", e.getClass().getName(), e.getMessage()));
			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getResponseApi", e.getClass().getName(), e.getMessage()));
		}
		
		return String.valueOf(sb);
	}
	
	/**
	 * Método responsável por ignorar a validação de certificados.
	 * Utilizar somente em ambientes de testes e de desenvolvimento.
	 * 
	 * @return um objeto {@link TrustManager} que aceita todos os certificados
	 * 
	 */
	private TrustManager[] getTrustAllCerts() {
		return new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                	try {
                		for (X509Certificate cert : certs) {
	                		cert.checkValidity();
	                		cert.verify(cert.getPublicKey());
	                	}
                	} catch(Exception e) {
            			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getResponseApi", e.getClass().getName(), e.getMessage()));
            			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getResponseApi", e.getClass().getName(), e.getMessage()));
            		}
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                	try {
                		for (X509Certificate cert : certs) {
                			cert.checkValidity();
                		}
                	} catch(Exception e) {
            			LOG.error(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getResponseApi", e.getClass().getName(), e.getMessage()));
            			throw new IllegalArgumentException(bundle.getChaveMensagemComParametro("ERROR_EXCEPTION", "getResponseApi", e.getClass().getName(), e.getMessage()));
            		}
                }
            }
        };
	}
	
}