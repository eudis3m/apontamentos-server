package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ApontamentosTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	int nrApontamento;
	Date dtLancamento;
	Date dtapontamento;
	BigDecimal vratividade;
	String nmRecursos;
	String nmProjetos;
	
	public ApontamentosTabelaDTO() {
		
	}
	public ApontamentosTabelaDTO( int nrApontamento, Date dtLancamento, Date dtapontamento, BigDecimal vratividade, String nmRecursos, String nmProjetos) {
		super();
		this.dtapontamento = dtapontamento;
		this.nrApontamento = nrApontamento;
		this.dtLancamento = dtLancamento;
		this.vratividade = vratividade;
		this.nmRecursos = nmRecursos;
		this.nmProjetos = nmProjetos;
	
	}
	
	public String getNmRecursos() {
		return nmRecursos;
	}

	public void setNmRecursos(String nmRecursos) {
		this.nmRecursos = nmRecursos;
	}
	
	public int getNRApontamento() {
		return nrApontamento;
	}

	public void setNRApontamento(int nrApontamento) {
		this.nrApontamento = nrApontamento;
	}

	public Date getDTapontamento(){
		 return dtapontamento; 
	  
    }
    
    public void setDTapontamento(Date dtapontamento) {
		this.dtapontamento = dtapontamento;
    }
    
    public Date getDTLancamento() {
		return dtLancamento;
    }
    
    public void setDTLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
    }
 
    public BigDecimal getVratividade() {
		return vratividade;
	}

	public void setVratividade(BigDecimal vratividade) {
		this.vratividade = vratividade;
	}
	public String getNmProjetos() {
		return nmProjetos;
	}

	public void setNmProjetos(String nmProjetos) {
		this.nmProjetos = nmProjetos;
	}
    
  

}
