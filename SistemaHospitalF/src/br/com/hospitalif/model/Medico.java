package br.com.hospitalif.model;

public class Medico extends Funcionario {
	//Atributos de Medico
	private int numeroDeRegistro;
	private String especialidade;
	//Gets e sets de Medico
	public int getNumeroDeRegistro() {
		return numeroDeRegistro;
	}
	public void setNumeroDeRegistro(int i) {
		
		this.numeroDeRegistro = i;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialiade) {
		this.especialidade = especialiade;
	}
}
