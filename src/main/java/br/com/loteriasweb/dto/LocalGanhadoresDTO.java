package br.com.loteriasweb.dto;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe DTO para o tráfego dos dados dos locais dos ganhadores.
 * 
 * @author Felipe Nascimento
 * 
 */

public class LocalGanhadoresDTO implements Comparator<LocalGanhadoresDTO>, Serializable {
	private static final long serialVersionUID = -8383758929365930503L;
	private Integer ganhadores;
	private String municipio;
	private String nomeFantasiaUL;
	private String serie;
	private Integer posicao;
	private String uf;
	
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
	 * Retorna o atributo municipio.
	 * 
	 * @return o nome do município do local dos ganhadores do tipo {@link String}.
	 * 
	 */
	public String getMunicipio() {
		return municipio;
	}
	
	/**
	 * Especifica o atributo municipio.
	 * .
	 * @param municipio {@link String} referente ao nome do município do local dos ganhadores que será setado.
	 * 
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	/**
	 * Retorna o atributo nomeFantasiaUL.
	 * 
	 * @return a o nome fantasia do município UL do local dos ganhadores do tipo {@link String}.
	 * 
	 */
	public String getNomeFantasiaUL() {
		return nomeFantasiaUL;
	}
	
	/**
	 * Especifica o atributo nomeFantasiaUL.
	 * .
	 * @param nomeFantasiaUL {@link String} referente ao nome fantasia UL do município do local dos ganhadores que será setado.
	 * 
	 */
	public void setNomeFantasiaUL(String nomeFantasiaUL) {
		this.nomeFantasiaUL = nomeFantasiaUL;
	}
	
	/**
	 * Retorna o atributo serie.
	 * 
	 * @return a serie do município do local dos ganhadores do tipo {@link String}.
	 * 
	 */
	public String getSerie() {
		return serie;
	}
	
	/**
	 * Especifica o atributo serie.
	 * .
	 * @param serie {@link String} referente à série do município do local dos ganhadores que será setada.
	 * 
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	/**
	 * Retorna o atributo posicao.
	 * 
	 * @return a posição do local de ganhadores da premiação do tipo {@link Integer}.
	 * 
	 */
	public Integer getPosicao() {
		return posicao;
	}
	
	/**
	 * Especifica o atributo posicao.
	 * .
	 * @param posicao {@link Integer} referente à posição do local de ganhadores da premiação que será setado.
	 * 
	 */
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	
	/**
	 * Retorna o atributo uf.
	 * 
	 * @return a UF do local de ganhadores do tipo {@link String}.
	 * 
	 */
    public String getUf() {
    	return uf;
    }
    
    /**
	 * Especifica o atributo uf.
	 * .
	 * @param uf {@link String} referente à UF do local de ganhadores que será setada.
	 * 
	 */
    public void setUf(String uf) {
    	this.uf = uf;
    }
    
    /**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		LocalGanhadoresDTO localGanhadoresDTO = (LocalGanhadoresDTO) object;
		
		return Objects.equals(ganhadores, localGanhadoresDTO.ganhadores)
			&& Objects.equals(municipio, localGanhadoresDTO.municipio)
			&& Objects.equals(nomeFantasiaUL, localGanhadoresDTO.nomeFantasiaUL)
			&& Objects.equals(serie, localGanhadoresDTO.serie)
			&& Objects.equals(posicao, localGanhadoresDTO.posicao)
			&& Objects.equals(uf, localGanhadoresDTO.uf);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			ganhadores,
			municipio,
			nomeFantasiaUL,
			serie,
			posicao,
			uf
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Número de Ganhadores: ").append(ganhadores)
			.append(", Município: ").append(municipio)
			.append(", Nome Fantasia UL: ").append(nomeFantasiaUL)
			.append(", Série: ").append(serie)
			.append(", Posição: ").append(posicao)
			.append(", UF: ").append(uf));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(LocalGanhadoresDTO localGanhadoresDTO1, LocalGanhadoresDTO localGanhadoresDTO2) {
		return localGanhadoresDTO1.getMunicipio().compareTo(localGanhadoresDTO2.getMunicipio());
	}
	
}