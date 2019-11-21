package br.com.hospitalif.model;

import java.time.LocalDate;

public class Atendimento{
	
	private int idAtendimento;
	private String comentarioEnfermeiro;
	private String comentarioMedico;
	private Float peso;
	private float altura;
	private LocalDate data;
	private String doenca;
	
	public int getIdAtendimento() {
		return idAtendimento;
	}
	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	public String getComentarioEnfermeiro() {
		return comentarioEnfermeiro;
	}
	public void setComentarioEnfermeiro(String comentarioEnfermeiro) {
		this.comentarioEnfermeiro = comentarioEnfermeiro;
	}
	public String getComentarioMedico() {
		return comentarioMedico;
	}
	public void setComentarioMedico(String comentarioMedico) {
		this.comentarioMedico = comentarioMedico;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso2) {
		this.peso = peso2;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura2) {
		this.altura = altura2;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate dataEntrada) {
		this.data = dataEntrada;
	}
	public String getDoenca() {
		return doenca;
	}
	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	public void setLong(LocalDate dataAtendimento) {
		// TODO Auto-generated method stub
		
	}
}
