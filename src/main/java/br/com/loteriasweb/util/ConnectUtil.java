package br.com.loteriasweb.util;

import jakarta.enterprise.context.ApplicationScoped;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import javax.net.ssl.TrustManager;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import javax.net.ssl.SSLContext;
import java.net.http.HttpClient;
import jakarta.inject.Named;
import java.io.Serializable;
import java.io.IOException;
import java.time.Duration;
import java.net.URI;

/**
 * Classe responsável pela comunicação com a loteriascaixa-api.
 * 
 * @author Felipe Nascimento
 *
 */

@Named
@ApplicationScoped
public class ConnectUtil implements Serializable {
	private static final long serialVersionUID = -1854300798474002096L;
	
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
	public String getResponseApi(String urlApi, String headerKey, String headerValue, String method) {
		
		try {
			
			var sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, getTrustAllCerts(), new SecureRandom());
			
			var client = HttpClient.newBuilder()
				.sslContext(sslContext)
                .connectTimeout(Duration.ofSeconds(30))
                .build();
			
			var requestBuilder = HttpRequest.newBuilder()
				.uri(URI.create(urlApi))
                .header(headerKey, headerValue)
                .timeout(Duration.ofSeconds(30));
			
			switch (method) {
			
				case "GET":
					
					return client.send(requestBuilder.GET().build(), HttpResponse.BodyHandlers.ofString()).body();
                    
				case "POST":
					
					return client.send(requestBuilder.POST(HttpRequest.BodyPublishers.noBody()).build(), HttpResponse.BodyHandlers.ofString()).body();
                    
				case "PUT":
					
					return client.send(requestBuilder.PUT(HttpRequest.BodyPublishers.noBody()).build(), HttpResponse.BodyHandlers.ofString()).body();
                    
				case "DELETE":
					
					return client.send(requestBuilder.DELETE().build(), HttpResponse.BodyHandlers.ofString()).body();
                    
                default:
                	
                	throw new IllegalArgumentException(String.format("O método HTTP %s não é suportado.", method));
			
			}
			
		} catch (IOException | InterruptedException | NoSuchAlgorithmException | KeyManagementException e) {
			
			throw new IllegalArgumentException(e.getMessage(), e.getCause());
			
		}
		
	}
	
	/**
	 * Método responsável por ignorar a validação de certificados.
	 * Utilizar somente em ambientes de testes e de desenvolvimento.
	 * 
	 * @return um objeto {@link TrustManager} que aceita todos os certificados
	 * 
	 */
	private static TrustManager[] getTrustAllCerts() {
		
		return new TrustManager[] {
				
            new X509TrustManager() {
            	
                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                	
                	try {
                		
                		for (X509Certificate cert : certs) {
                			
	                		cert.checkValidity();
	                		cert.verify(cert.getPublicKey());
	                		
	                	}
                		
                	} catch (Exception e) {
                		
                		throw new IllegalArgumentException(e.getMessage(), e.getCause());
                		
                	}
                	
                }
                
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                	
                	try {
                		
                		for (X509Certificate cert : certs) {
                			
                			cert.checkValidity();
                			
                		}
                		
                	} catch (Exception e) {
                		
                		throw new IllegalArgumentException(e.getMessage(), e.getCause());
                		
                	}
                	
                }
                
            }
            
        };
		
	}
	
}