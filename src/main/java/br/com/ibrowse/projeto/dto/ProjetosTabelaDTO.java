package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.util.Date;


public class ProjetosTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String nmprojeto;
	Date dtprojetoinicio;
	Date dtProjetoFinal;
	String dsDescricaoProjeto;
	String nmEmpresa;
	long vrcustoAprovado;
	
	public ProjetosTabelaDTO() {
		
	}
	public ProjetosTabelaDTO(String nmprojeto,Date dtprojetoinicio, Date dtProjetoFinal, String dsDescricaoProjeto, String nmEmpresa, long vrcustoAprovado) {
		super();
		this.nmprojeto = nmprojeto;
		this.dtprojetoinicio = dtprojetoinicio;
		this.dtProjetoFinal = dtProjetoFinal;
		this.dsDescricaoProjeto = dsDescricaoProjeto;
		this.nmEmpresa = nmEmpresa;
		this.vrcustoAprovado = vrcustoAprovado;
	}
	

	   
	  public String getNMprojetos() {
			return nmprojeto;
		}

		public void setNMprojeto(String nmprojeto) {
			this.nmprojeto = nmprojeto;
		}

	public String getDSDescricaoProjeto() {
		return dsDescricaoProjeto;
	}

	public void setDSDescricaoProjeto(String dsDescricaoProjeto) {
		this.dsDescricaoProjeto = dsDescricaoProjeto;
	}

	public Date getDTProjetoInicio() {
		return dtprojetoinicio;
  }
  
  public void setDTProjetoInicio(Date dtprojetoinicio) {
		this.dtprojetoinicio = dtprojetoinicio;
  }
  
  public Date getDTProjetoFinal() {
		return dtProjetoFinal;
  }
  
  public void setDTProjetoFinal(Date dtProjetoFinal) {
		this.dtProjetoFinal = dtProjetoFinal;
  }
 
 
	  public String getNmEmpresa() {
			return nmEmpresa;
		}

		public void setNmEmpresa(String nmEmpresa) {
			this.nmEmpresa = nmEmpresa;
		}
		

	    public long getVrcustoAprovado() {
			return vrcustoAprovado;
		}

		public void setVrcustoAprovado(long vrcustoAprovado) {
			this.vrcustoAprovado = vrcustoAprovado;
		}

}
