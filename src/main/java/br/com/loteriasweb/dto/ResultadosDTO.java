package br.com.loteriasweb.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.List;

/**
 * Classe DTO para o tráfego dos dados das loterias.
 * 
 * @author Felipe Nascimento
 * 
 */

public class ResultadosDTO implements Comparator<ResultadosDTO>, Serializable {
	private static final long serialVersionUID = -4207149325561417080L;
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
	
	/**
	 * Retorna o atributo loteria.
	 * 
	 * @return o nome da loteria do tipo {@link String}.
	 * 
	 */
	public String getLoteria() {
		return loteria;
	}
	
	/**
	 * Especifica o atributo loteria.
	 * .
	 * @param loteria {@link String} referente ao nome da loteria que será setado.
	 * 
	 */
	public void setLoteria(String loteria) {
		this.loteria = loteria;
	}
	
	/**
	 * Retorna o atributo concurso.
	 * 
	 * @return o número do concurso da loteria do tipo {@link Integer}.
	 * 
	 */
	public Integer getConcurso() {
		return concurso;
	}
	
	/**
	 * Especifica o atributo concurso.
	 * .
	 * @param concurso {@link Integer} referente ao número do concurso da loteria que será setado.
	 * 
	 */
	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}
	
	/**
	 * Retorna o atributo data.
	 * 
	 * @return a data do concurso da loteria do tipo {@link String}.
	 * 
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Especifica o atributo data.
	 * .
	 * @param data {@link String} referente à data do concurso da loteria que será setada.
	 * 
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Retorna o atributo local.
	 * 
	 * @return o local do sorteio da loteria do tipo {@link String}.
	 * 
	 */
	public String getLocal() {
		return local;
	}
	
	/**
	 * Especifica o atributo local.
	 * .
	 * @param local {@link String} referente ao local do sorteio da loteria que será setado.
	 * 
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	
	/**
	 * Retorna o atributo dezenasOrdemSorteio.
	 * 
	 * @return as dezenas sorteadas da loteria do tipo {@link List}.
	 * 
	 */
	public List<String> getDezenasOrdemSorteio() {
		return dezenasOrdemSorteio;
	}
	
	/**
	 * Especifica o atributo dezenasOrdemSorteio.
	 * .
	 * @param dezenasOrdemSorteio {@link List} referente à lista de dezenas sorteadas da loteria que será setada.
	 * 
	 */
	public void setDezenasOrdemSorteio(List<String> dezenasOrdemSorteio) {
		this.dezenasOrdemSorteio = dezenasOrdemSorteio;
	}
	
	/**
	 * Retorna o atributo dezenas.
	 * 
	 * @return em ordem crescente as dezenas sorteadas da loteria do tipo {@link List}.
	 * 
	 */
	public List<String> getDezenas() {
		return dezenas;
	}
	
	/**
	 * Especifica o atributo dezenas.
	 * .
	 * @param dezenas {@link List} referente à lista de dezenas sorteadas em ordem crescente da loteria que será setada.
	 * 
	 */
	public void setDezenas(List<String> dezenas) {
		this.dezenas = dezenas;
	}
	
	/**
	 * Retorna o atributo trevos.
	 * 
	 * @return os trevos sorteados da loteria do tipo {@link List}.
	 * 
	 */
	public List<String> getTrevos() {
		return trevos;
	}
	
	/**
	 * Especifica o atributo trevos.
	 * .
	 * @param trevos {@link List} referente à lista de trevos sorteados da loteria que será setada.
	 * 
	 */
	public void setTrevos(List<String> trevos) {
		this.trevos = trevos;
	}
	
	/**
	 * Retorna o atributo timeCoracao.
	 * 
	 * @return o time do coração sorteado da loteria do tipo {@link String}.
	 * 
	 */
	public String getTimeCoracao() {
		return timeCoracao;
	}
	
	/**
	 * Especifica o atributo timeCoracao.
	 * .
	 * @param timeCoracao {@link String} referente ao time do coração sorteado da loteria que será setado.
	 * 
	 */
	public void setTimeCoracao(String timeCoracao) {
		this.timeCoracao = timeCoracao;
	}
	
	/**
	 * Retorna o atributo mesSorte.
	 * 
	 * @return o mês da sorte sorteado da loteria do tipo {@link String}.
	 * 
	 */
	public String getMesSorte() {
		return mesSorte;
	}
	
	/**
	 * Especifica o atributo mesSorte.
	 * .
	 * @param mesSorte {@link String} referente ao mês da sorte sorteado da loteria que será setado.
	 * 
	 */
	public void setMesSorte(String mesSorte) {
		this.mesSorte = mesSorte;
	}
	
	/**
	 * Retorna o atributo premiacoes.
	 * 
	 * @return as premiações sorteadas da loteria do tipo {@link List}.
	 * 
	 */
	public List<PremiacoesDTO> getPremiacoes() {
		return premiacoes;
	}
	
	/**
	 * Especifica o atributo premiacoes.
	 * .
	 * @param premiacoes {@link List} referente à lista de premiações sorteadas da loteria que será setada.
	 * 
	 */
	public void setPremiacoes(List<PremiacoesDTO> premiacoes) {
		this.premiacoes = premiacoes;
	}
	
	/**
	 * Retorna o atributo estadosPremiados.
	 * 
	 * @return os estados premiados da loteria do tipo {@link List}.
	 * 
	 */
	public List<String> getEstadosPremiados() {
		return estadosPremiados;
	}
	
	/**
	 * Especifica o atributo estadosPremiados.
	 * .
	 * @param estadosPremiados {@link List} referente à lista de estados premiados da loteria que será setada.
	 * 
	 */
	public void setEstadosPremiados(List<String> estadosPremiados) {
		this.estadosPremiados = estadosPremiados;
	}
	
	/**
	 * Retorna o atributo observacao.
	 * 
	 * @return a observação da loteria do tipo {@link String}.
	 * 
	 */
	public String getObservacao() {
		return observacao;
	}
	
	/**
	 * Especifica o atributo observacao.
	 * .
	 * @param observacao {@link String} referente à observação da loteria que será setada.
	 * 
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	/**
	 * Retorna o atributo acumulou.
	 * 
	 * @return a informação de acúmulo da loteria do tipo {@link Boolean}.
	 * 
	 */
	public Boolean getAcumulou() {
		return acumulou;
	}
	
	/**
	 * Especifica o atributo acumulou.
	 * .
	 * @param acumulou {@link Boolean} referente à informação de acúmulo da loteria que será setada.
	 * 
	 */
	public void setAcumulou(Boolean acumulou) {
		this.acumulou = acumulou;
	}
	
	/**
	 * Retorna o atributo strAcumulou.
	 * 
	 * @return a informação de acúmulo da loteria do tipo {@link String}.
	 * 
	 */
	public String getStrAcumulou() {
		return strAcumulou;
	}
	
	/**
	 * Especifica o atributo strAcumulou.
	 * .
	 * @param strAcumulou {@link String} referente à informação de acúmulo da loteria que será setada.
	 * 
	 */
	public void setStrAcumulou(String strAcumulou) {
		this.strAcumulou = strAcumulou;
	}
	
	/**
	 * Retorna o atributo proximoConcurso.
	 * 
	 * @return o número do próximo concurso da loteria do tipo {@link Integer}.
	 * 
	 */
	public Integer getProximoConcurso() {
		return proximoConcurso;
	}
	
	/**
	 * Especifica o atributo proximoConcurso.
	 * .
	 * @param proximoConcurso {@link Integer} referente ao número do próximo concurso da loteria que será setado.
	 * 
	 */
	public void setProximoConcurso(Integer proximoConcurso) {
		this.proximoConcurso = proximoConcurso;
	}
	
	/**
	 * Retorna o atributo dataProximoConcurso.
	 * 
	 * @return a data do próximo concurso da loteria do tipo {@link String}.
	 * 
	 */
	public String getDataProximoConcurso() {
		return dataProximoConcurso;
	}
	
	/**
	 * Especifica o atributo dataProximoConcurso.
	 * .
	 * @param dataProximoConcurso {@link String} referente à data do próximo concurso da loteria que será setada.
	 * 
	 */
	public void setDataProximoConcurso(String dataProximoConcurso) {
		this.dataProximoConcurso = dataProximoConcurso;
	}
	
	/**
	 * Retorna o atributo localGanhadores.
	 * 
	 * @return o local dos ganhadores da loteria do tipo {@link List}.
	 * 
	 */
	public List<LocalGanhadoresDTO> getLocalGanhadores() {
		return localGanhadores;
	}
	
	/**
	 * Especifica o atributo localGanhadores.
	 * .
	 * @param localGanhadores {@link List} referente à lista de locais dos ganhadores da loteria que será setada.
	 * 
	 */
	public void setLocalGanhadores(List<LocalGanhadoresDTO> localGanhadores) {
		this.localGanhadores = localGanhadores;
	}
	
	/**
	 * Retorna o atributo valorArrecadado.
	 * 
	 * @return o valor arrecadado pela da loteria do tipo {@link Double}.
	 * 
	 */
	public Double getValorArrecadado() {
		return valorArrecadado;
	}
	
	/**
	 * Especifica o atributo valorArrecadado.
	 * .
	 * @param valorArrecadado {@link Double} referente ao valor arrecadado pela loteria que será setado.
	 * 
	 */
	public void setValorArrecadado(Double valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
	}
	
	/**
	 * Retorna o atributo valorAcumuladoConcurso05.
	 * 
	 * @return o valor acumulado pelo concurso 05 da loteria do tipo {@link Double}.
	 * 
	 */
	public Double getValorAcumuladoConcurso05() {
		return valorAcumuladoConcurso05;
	}
	
	/**
	 * Especifica o atributo valorAcumuladoConcurso05.
	 * .
	 * @param valorAcumuladoConcurso05 {@link Double} referente ao valor acumulado pelo concurso 05 da loteria que será setado.
	 * 
	 */
	public void setValorAcumuladoConcurso05(Double valorAcumuladoConcurso05) {
		this.valorAcumuladoConcurso05 = valorAcumuladoConcurso05;
	}
	
	/**
	 * Retorna o atributo valorAcumuladoConcursoEspecial.
	 * 
	 * @return o valor acumulado pelo concurso especial da loteria do tipo {@link Double}.
	 * 
	 */
	public Double getValorAcumuladoConcursoEspecial() {
		return valorAcumuladoConcursoEspecial;
	}
	
	/**
	 * Especifica o atributo valorAcumuladoConcursoEspecial.
	 * .
	 * @param valorAcumuladoConcursoEspecial {@link Double} referente ao valor acumulado pelo concurso especial da loteria que será setado.
	 * 
	 */
	public void setValorAcumuladoConcursoEspecial(Double valorAcumuladoConcursoEspecial) {
		this.valorAcumuladoConcursoEspecial = valorAcumuladoConcursoEspecial;
	}
	
	/**
	 * Retorna o atributo valorAcumuladoProximoConcurso.
	 * 
	 * @return o valor acumulado para o próximo concurso da loteria do tipo {@link Double}.
	 * 
	 */
	public Double getValorAcumuladoProximoConcurso() {
		return valorAcumuladoProximoConcurso;
	}
	
	/**
	 * Especifica o atributo valorAcumuladoProximoConcurso.
	 * .
	 * @param valorAcumuladoProximoConcurso {@link Double} referente ao valor acumulado para o próximo concurso da loteria que será setado.
	 * 
	 */
	public void setValorAcumuladoProximoConcurso(Double valorAcumuladoProximoConcurso) {
		this.valorAcumuladoProximoConcurso = valorAcumuladoProximoConcurso;
	}
	
	/**
	 * Retorna o atributo valorEstimadoProximoConcurso.
	 * 
	 * @return o valor estimado para o próximo concurso da loteria do tipo {@link Double}.
	 * 
	 */
	public Double getValorEstimadoProximoConcurso() {
		return valorEstimadoProximoConcurso;
	}
	
	/**
	 * Especifica o atributo valorEstimadoProximoConcurso.
	 * .
	 * @param valorEstimadoProximoConcurso {@link Double} referente ao valor estimado para o próximo concurso da loteria que será setado.
	 * 
	 */
	public void setValorEstimadoProximoConcurso(Double valorEstimadoProximoConcurso) {
		this.valorEstimadoProximoConcurso = valorEstimadoProximoConcurso;
	}
	
	/**
	 * Retorna o atributo backcolorLoterias.
	 * 
	 * @return a cor que simboliza a loteria do tipo {@link String}.
	 * 
	 */
	public String getBackcolorLoterias() {
		return backcolorLoterias;
	}
	
	/**
	 * Especifica o atributo backcolorLoterias.
	 * .
	 * @param backcolorLoterias {@link String} referente à cor que simboliza a loteria que será setada.
	 * 
	 */
	public void setBackcolorLoterias(String backcolorLoterias) {
		this.backcolorLoterias = backcolorLoterias;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		ResultadosDTO loteriasDTO = (ResultadosDTO) object;
		
		return Objects.equals(loteria, loteriasDTO.loteria)
			&& Objects.equals(concurso, loteriasDTO.concurso)
			&& Objects.equals(data, loteriasDTO.data)
			&& Objects.equals(local, loteriasDTO.local)
			&& Objects.equals(dezenasOrdemSorteio, loteriasDTO.dezenasOrdemSorteio)
			&& Objects.equals(dezenas, loteriasDTO.dezenas)
			&& Objects.equals(trevos, loteriasDTO.trevos)
			&& Objects.equals(timeCoracao, loteriasDTO.timeCoracao)
			&& Objects.equals(mesSorte, loteriasDTO.mesSorte)
			&& Objects.equals(premiacoes, loteriasDTO.premiacoes)
			&& Objects.equals(estadosPremiados, loteriasDTO.estadosPremiados)
			&& Objects.equals(observacao, loteriasDTO.observacao)
			&& Objects.equals(acumulou, loteriasDTO.acumulou)
			&& Objects.equals(strAcumulou, loteriasDTO.strAcumulou)
			&& Objects.equals(proximoConcurso, loteriasDTO.proximoConcurso)
			&& Objects.equals(dataProximoConcurso, loteriasDTO.dataProximoConcurso)
			&& Objects.equals(localGanhadores, loteriasDTO.localGanhadores)
			&& Objects.equals(valorArrecadado, loteriasDTO.valorArrecadado)
			&& Objects.equals(valorAcumuladoConcurso05, loteriasDTO.valorAcumuladoConcurso05)
			&& Objects.equals(valorAcumuladoConcursoEspecial, loteriasDTO.valorAcumuladoConcursoEspecial)
			&& Objects.equals(valorAcumuladoProximoConcurso, loteriasDTO.valorAcumuladoProximoConcurso)
			&& Objects.equals(valorEstimadoProximoConcurso, loteriasDTO.valorEstimadoProximoConcurso)
			&& Objects.equals(backcolorLoterias, loteriasDTO.backcolorLoterias);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			loteria,
			concurso,
			data,
			local,
			dezenasOrdemSorteio,
			dezenas,
			trevos,
			timeCoracao,
			mesSorte,
			premiacoes,
			estadosPremiados,
			observacao,
			acumulou,
			strAcumulou,
			proximoConcurso,
			dataProximoConcurso,
			localGanhadores,
			valorArrecadado,
			valorAcumuladoConcurso05,
			valorAcumuladoConcursoEspecial,
			valorAcumuladoProximoConcurso,
			valorEstimadoProximoConcurso,
			backcolorLoterias
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Loteria: ").append(loteria)
			.append(", Concurso: ").append(concurso)
			.append(", Data do Concurso: ").append(data)
			.append(", Local do Concurso: ").append(local)
			.append(", Dezenas Sorteadas: ").append(dezenasOrdemSorteio)
			.append(", Dezenas em Ordem Crescente: ").append(dezenas)
			.append(", Trevos Sorteados: ").append(trevos)
			.append(", Dezenas em Ordem Crescente: ").append(dezenas)
			.append(", Time do Coração Sorteado: ").append(timeCoracao)
			.append(", Mês da Sorte Sorteado: ").append(mesSorte)
			.append(", Time do Coração Sorteado: ").append(timeCoracao)
			.append(", Premiações: ").append(premiacoes)
			.append(", Estados Premiados: ").append(estadosPremiados)
			.append(", Observação: ").append(observacao)
			.append(", Acumulou: ").append(acumulou)
			.append(", String Acumulou: ").append(strAcumulou)
			.append(", Próximo Concurso: ").append(proximoConcurso)
			.append(", Data do Próximo Concurso: ").append(dataProximoConcurso)
			.append(", Local dos Ganhadores: ").append(localGanhadores)
			.append(", Valor Arrecadado pela Loteria: ").append(valorArrecadado)
			.append(", Valor Acumulado pelo Concurso 05: ").append(valorAcumuladoConcurso05)
			.append(", Valor Acumulado pelo Concurso Especial: ").append(valorAcumuladoConcursoEspecial)
			.append(", Valor Acumulado para o Próximo Concurso: ").append(valorAcumuladoProximoConcurso)
			.append(", Valor Estimado para o Próximo Concurso: ").append(valorEstimadoProximoConcurso)
			.append(", Cor da Loteria: ").append(backcolorLoterias));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(ResultadosDTO loteriasDTO1, ResultadosDTO loteriasDTO2) {
		return loteriasDTO1.getLoteria().compareTo(loteriasDTO2.getLoteria());
	}
	
}