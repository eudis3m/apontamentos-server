package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.ibrowse.projeto.entity.ProjetosEntity;
import br.com.ibrowse.projeto.entity.RecursosEntity;

public class AtividadesTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private Date dtInicio;
	 private Date dtFinal;
	 private int nrhorasAtividade;
	 private String nmRecursos;
	 private String nmProjetos;
	
	 
	 public AtividadesTabelaDTO() {
		 
	 }
	 
	 public AtividadesTabelaDTO(Date dtInicio,Date dtFinal,  int nrhorasAtividade,String nmRecursos, String nmProjetos) {
		 super();
		 this.dtInicio = dtInicio;
		 this.dtFinal = dtFinal;
		 this.nrhorasAtividade = nrhorasAtividade;
		 this.nmRecursos = nmRecursos;
		 this.nmProjetos = nmProjetos;
	 }
	 
	
	   
	    public int getNrhorasAtividade() {
			return nrhorasAtividade;
	    }
	    
	    public void setNrhorasAtividade(int nrhorasAtividade) {
			this.nrhorasAtividade = nrhorasAtividade;
	    }
	    
	 
		public String getNmProjetos() {
			return nmProjetos;
		}

		public void setNmProjetos(String nmProjetos) {
			this.nmProjetos = nmProjetos;
		}
	    
		public String getNmRecursos() {
				return nmRecursos;
			}

		public void setNmRecursos(String nmRecursos) {
				this.nmRecursos = nmRecursos;
			}
			
	    public Date getDtInicio() {
					return dtInicio;
				}

		public void setDtInicio(Date dtInicio) {
					this.dtInicio = dtInicio;
				}

		public Date getDtFinal() {
					return dtFinal;
				}

		public void setDtFinal(Date dtFinal) {
					this.dtFinal = dtFinal;
				}

}
