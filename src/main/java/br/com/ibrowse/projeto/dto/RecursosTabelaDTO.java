package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.util.Date;

public class RecursosTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String nmrecursos;
	
	public RecursosTabelaDTO() {
		
	}
	public RecursosTabelaDTO(String nmrecursos ) {
		super();
		this.nmrecursos  = nmrecursos ;

	}
	
	public String getNMrecursos() {
		return nmrecursos;
	}

	public void setNMrecursos(String nmrecursos) {
		this.nmrecursos = nmrecursos;
	}

}
