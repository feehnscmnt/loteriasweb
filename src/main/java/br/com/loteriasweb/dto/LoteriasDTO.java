package br.com.loteriasweb.dto;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe DTO para o tráfego dos dados das loterias disponíveis.
 * 
 * @author Felipe Nascimento
 * 
 */

public class LoteriasDTO implements Comparator<LoteriasDTO>, Serializable {
	private static final long serialVersionUID = 2607791240962595541L;
	private String loterias;
	
	/**
	 * Retorna o atributo loterias.
	 * 
	 * @return as loterias disponíveis do tipo {@link String}.
	 * 
	 */
	public String getLoterias() {
		return loterias;
	}
	
	/**
	 * Especifica o atributo loterias.
	 * .
	 * @param loterias {@link String} referente ao nome das loterias disponíveis que será setado.
	 * 
	 */
	public void setLoterias(String loterias) {
		this.loterias = loterias;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		LoteriasDTO loteriasDTO = (LoteriasDTO) object;
		
		return Objects.equals(loterias, loteriasDTO.loterias);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			loterias
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Loterias Disponíveis: ").append(loterias));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(LoteriasDTO loteriasDTO1, LoteriasDTO loteriasDTO2) {
		return loteriasDTO1.getLoterias().compareTo(loteriasDTO2.getLoterias());
	}
	
}