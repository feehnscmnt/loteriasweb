package br.com.loteriasweb.dto;

import java.text.NumberFormat;
import java.io.Serializable;
import java.util.Locale;
import lombok.Data;

/**
 * Classe DTO para o tráfego dos dados das premiações sorteadas.
 * 
 * @author Felipe Nascimento
 * 
 */

@Data
public class PremiacoesDTO implements Serializable {
	private static final long serialVersionUID = -3927005568823769884L;
	private String descricao;
	private Integer faixa;
	private Integer ganhadores;
	private Double valorPremio;
	
	/**
	 * Método responsável pela formatação de valores monetários.
	 * 
	 * @return valor formatado
	 * 
	 */
	public String getValorPremioFormatado() {
		return NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(valorPremio);
	}
	
}