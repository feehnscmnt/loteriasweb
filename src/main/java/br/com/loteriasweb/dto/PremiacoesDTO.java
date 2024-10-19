package br.com.loteriasweb.dto;

import java.text.NumberFormat;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.Locale;

/**
 * Classe DTO para o tráfego dos dados das premiações sorteadas.
 * 
 * @author Felipe Nascimento
 * 
 */

public class PremiacoesDTO implements Comparator<PremiacoesDTO>, Serializable {
	private static final long serialVersionUID = 9087510673353294096L;
	private String descricao;
	private Integer faixa;
	private Integer ganhadores;
	private Double valorPremio;
	
	/**
	 * Retorna o atributo descricao.
	 * 
	 * @return a descrição da premiação do tipo {@link String}.
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Especifica o atributo descricao.
	 * .
	 * @param descricao {@link String} referente à descrição da premiação que será setada.
	 * 
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Retorna o atributo faixa.
	 * 
	 * @return o número da faixa da premiação do tipo {@link Integer}.
	 * 
	 */
	public Integer getFaixa() {
		return faixa;
	}
	
	/**
	 * Especifica o atributo faixa.
	 * .
	 * @param faixa {@link Integer} referente ao número da faixa da premiação que será setado.
	 * 
	 */
	public void setFaixa(Integer faixa) {
		this.faixa = faixa;
	}
	
	/**
	 * Retorna o atributo ganhadores.
	 * 
	 * @return o número de ganhadores da premiação do tipo {@link Integer}.
	 * 
	 */
	public Integer getGanhadores() {
		return ganhadores;
	}
	
	/**
	 * Especifica o atributo ganhadores.
	 * .
	 * @param ganhadores {@link Integer} referente ao número de ganhadores da premiação que será setado.
	 * 
	 */
	public void setGanhadores(Integer ganhadores) {
		this.ganhadores = ganhadores;
	}
	
	/**
	 * Retorna o atributo valorPremio.
	 * 
	 * @return o valor do prêmio do tipo {@link Double}.
	 * 
	 */
	public Double getValorPremio() {
		return valorPremio;
	}
	
	/**
	 * Especifica o atributo valorPremio.
	 * .
	 * @param valorPremio {@link Double} referente ao valor do prêmio que será setado.
	 * 
	 */
	public void setValorPremio(Double valorPremio) {
		this.valorPremio = valorPremio;
	}
	
	/**
	 * Método responsável pela formatação de valores monetários.
	 * 
	 * @return valor formatado
	 * 
	 */
	public String getValorPremioFormatado() {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valorPremio);
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		PremiacoesDTO premiacoesDTO = (PremiacoesDTO) object;
		
		return Objects.equals(descricao, premiacoesDTO.descricao)
			&& Objects.equals(faixa, premiacoesDTO.faixa)
			&& Objects.equals(ganhadores, premiacoesDTO.ganhadores)
			&& Objects.equals(valorPremio, premiacoesDTO.valorPremio);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			descricao,
			faixa,
			ganhadores,
			valorPremio
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Descrição da Premiação: ").append(descricao)
			.append(", Número da Faixa da Premiação: ").append(faixa)
			.append(", Número de Ganhadores: ").append(ganhadores)
			.append(", Valor do Prêmio: ").append(valorPremio));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(PremiacoesDTO premiacoesDTO1, PremiacoesDTO premiacoesDTO2) {
		return premiacoesDTO1.getDescricao().compareTo(premiacoesDTO2.getDescricao());
	}
	
}