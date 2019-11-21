package br.com.hospitalif.model;

import java.time.LocalDate;

public class Entrada extends Atendimento{

	private int idEntrada;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String StatusDeEntrada;
	private String situacaoDePaciente;
	public int getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada2) {
		this.dataEntrada = dataEntrada2;
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida2) {
		this.dataSaida = dataSaida2;
	}
	public String getStatusDeEntrada() {
		return StatusDeEntrada;
	}
	public void setStatusDeEntrada(String statusDeEntrada) {
		StatusDeEntrada = statusDeEntrada;
	}
	public String getSituacaoDePaciente() {
		return situacaoDePaciente;
	}
	public void setSituacaoDePaciente(String situacaoDePaciente) {
		this.situacaoDePaciente = situacaoDePaciente;
	}
}
