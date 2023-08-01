package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CentroCustoTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	BigDecimal vrcustoPrevisto;
	BigDecimal vrcustoAprovado;
	String dscentroCusto;
	String nmprojeto;
	
	public CentroCustoTabelaDTO() {
		
	}
	public CentroCustoTabelaDTO(BigDecimal vrcustoPrevisto,BigDecimal vrcustoAprovado, String dscentroCusto, String nmprojeto ) {
		super();
		this.vrcustoPrevisto = vrcustoPrevisto;
		this.vrcustoAprovado = vrcustoAprovado;
		this.dscentroCusto = dscentroCusto;
		this.nmprojeto = nmprojeto;
		
	}
	
	 public String getNMProjeto() {
			return nmprojeto;
		}

		public void setNMProjeto(String nmprojeto) {
			this.nmprojeto = nmprojeto;
		}
		
	public BigDecimal getVRCustoPrevisto() {
		return vrcustoPrevisto;
	}

	public void setVRCustoPrevisto(BigDecimal vrcustoPrevisto) {
		this.vrcustoPrevisto = vrcustoPrevisto;
	}

	public BigDecimal getVRCustoAprovado() {
		return vrcustoAprovado;
    }
    
    public void setVRCustoAprovado(BigDecimal vrcustoAprovado) {
		this.vrcustoAprovado = vrcustoAprovado;
    }
    
    public String getDSCentroCusto() {
		return dscentroCusto;
    }
    
    public void setDSCentroCusto(String dscentroCusto) {
		this.dscentroCusto = dscentroCusto;
    }

}
