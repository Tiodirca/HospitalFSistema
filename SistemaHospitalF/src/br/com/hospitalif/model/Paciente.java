package br.com.hospitalif.model;
public class Paciente extends Pessoa{
	//atributos da classe paciente
	private int idPaciente;
	private String doenca;
	private String historico;
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getDoenca() {
		return doenca;
	}
	public void setDoenca(String string) {
		this.doenca = string;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String string) {
		this.historico = string;
	}
}
