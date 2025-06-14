package br.com.loteriasweb.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Classe DTO para o tráfego dos dados das loterias.
 * 
 * @author Felipe Nascimento
 * 
 */

@Data
public class ResultadosDTO implements Serializable {
	private static final long serialVersionUID = 2131297030311179579L;
	private String loteria;
	private Integer concurso;
	private String data;
	private String local;
	private List<String> dezenasOrdemSorteio;
	private List<String> dezenas;
	private List<String> trevos;
	private String timeCoracao;
	private String mesSorte;
	private List<PremiacoesDTO> premiacoes;
	private List<String> estadosPremiados;
	private String observacao;
	private Boolean acumulou;
	private String strAcumulou;
	private Integer proximoConcurso;
	private String dataProximoConcurso;
	private List<LocalGanhadoresDTO> localGanhadores;
	private Double valorArrecadado;
	
	@SerializedName("valorAcumuladoConcurso_0_5")
	private Double valorAcumuladoConcurso05;
	
	private Double valorAcumuladoConcursoEspecial;
	private Double valorAcumuladoProximoConcurso;
	private Double valorEstimadoProximoConcurso;
	
	private String backcolorLoterias;
}