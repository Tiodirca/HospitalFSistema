package br.com.hospitalif.model;

public class Enfermeiro extends Funcionario {
	private String numeroDeRegistro;
	private int idEnfermeiro;

	public int getIdEnfermeiro() {
		return idEnfermeiro;
	}

	public void setIdEnfermeiro(int idEnfermeiro) {
		this.idEnfermeiro = idEnfermeiro;
	}

	public String getNumeroDeRegistro() {
		return numeroDeRegistro;
	}

	public void setNumeroDeRegistro(String nRegistro) {
		this.numeroDeRegistro = nRegistro;
	}
	
}
