package br.com.loteriasweb.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * Classe DTO para o tráfego dos dados dos locais dos ganhadores.
 * 
 * @author Felipe Nascimento
 * 
 */

@Data
public class LocalGanhadoresDTO implements Serializable {
	private static final long serialVersionUID = 4027384813376448305L;
	private Integer ganhadores;
	private String municipio;
	private String nomeFantasiaUL;
	private String serie;
	private Integer posicao;
	private String uf;
}