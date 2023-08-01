package br.com.ibrowse.projeto.dto;

import java.io.Serializable;

public class EmpresaTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private String nmempresa;
	 private String nrCNPJ;
	 private String nrTelefone;
	 String dsrua;
	 String dsbairro;
	 String dscidade;
	 long dsnumero;
	 String dscomplemento;
	
	 
	 public EmpresaTabelaDTO() {
		 
	 }
	 
	 public EmpresaTabelaDTO( String nmEmpresa,String nrCNPJ, String nrTelefone, String dsrua,String dsbairro,String dscidade,long dsnumero,String dscomplemento) {
		 super();
		 this.nmempresa = nmEmpresa;
		 this.nrCNPJ = nrCNPJ;
		 this.nrTelefone = nrTelefone;
		 this.dsrua = dsrua;
		 this.dsbairro = dsbairro;
		 this.dscidade = dscidade;
		 this.dscomplemento = dscomplemento;
		 this.dsnumero =dsnumero;
	 }
	 
	
	 public String getNMEmpresa() {
			return nmempresa;
		}

		public void setNMEmpresa(String nmempresa) {
		 	this.nmempresa = nmempresa;
		}

		public String getNRCNPJ() {
			return nrCNPJ;
	    }
	    
	    public void setNRCNPJ(String nrCNPJ) {
			this.nrCNPJ = nrCNPJ;
	    }
	    
	    public String getNRTelefone() {
			return nrTelefone;
	    }
	    
	    public void setNRTelefone(String nrTelefone) {
			this.nrTelefone = nrTelefone;
	    }
	    
	    public String getDsRua() {
			return dsrua;
		}

		public void setDsRua(String dsrua) {
			this.dsrua = dsrua;
		}

		public String getDsBairro() {
			return dsbairro;
		}

		public void setDsBairro(String dsbairro) {
			this.dsbairro = dsbairro;
		}

		public String getDsCidade() {
			return dscidade;
		}

		public void setDsCidade(String dscidade) {
			this.dscidade = dscidade;
		}

		public long getDsNumero() {
			return dsnumero;
		}

		public void setDsNumero(long dsnumero) {
			this.dsnumero = dsnumero;
		}

		public String getDsComplemento() {
			return dscomplemento;
		}

		public void setDsComplemento(String dscomplemento) {
			this.dscomplemento = dscomplemento;
		}

}
