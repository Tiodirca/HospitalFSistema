package br.com.hospitalif.model;

public class EnfermidadePessoal extends Enfermidade{
		private int idEnfermidadePessoal;
		private String comentario;
		private String statusDeEnfermidade;
		
		public int getIdEnfermidadePessoal() {
			return idEnfermidadePessoal;
		}
		public void setIdEnfermidadePessoal(int idEnfermidadePessoal) {
			this.idEnfermidadePessoal = idEnfermidadePessoal;
		}
		public String getComentario() {
			return comentario;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}
		public String getStatusDeEnfermidade() {
			return statusDeEnfermidade;
		}
		public void setStatusDeEnfermidade(String statusDeEnfermidade) {
			this.statusDeEnfermidade = statusDeEnfermidade;
		}
		
		
}
