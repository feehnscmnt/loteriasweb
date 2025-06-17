package br.com.loteriasweb.dto;

import lombok.AllArgsConstructor;
import java.io.Serializable;
import lombok.Data;

/**
 * Classe DTO para o tráfego dos dados das loterias disponíveis.
 * 
 * @author Felipe Nascimento
 * 
 */

@Data
@AllArgsConstructor
public class LoteriasDTO implements Serializable {
	private static final long serialVersionUID = 6021154402183911320L;
	private String nomeOriginal;
	private String nomeAlterado;
}