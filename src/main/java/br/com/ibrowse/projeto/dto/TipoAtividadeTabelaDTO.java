package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TipoAtividadeTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String nmtipoAtividade;
	BigDecimal vrAtividade;
	
	public TipoAtividadeTabelaDTO() {
		
	}
	public TipoAtividadeTabelaDTO(String nmtipoAtividade , BigDecimal vrAtividade) {
		super();
		this.nmtipoAtividade  = nmtipoAtividade;
		this.vrAtividade = vrAtividade;

	}
	
	public String getNMTipoAtividade() {
		return nmtipoAtividade;
	}

	public void setNMTipoAtividade(String nmtipoAtividade) {
		this.nmtipoAtividade = nmtipoAtividade;
    }

	 public BigDecimal getVRAtividade() {
			return vrAtividade;
		}

		public void setVRAtividade(BigDecimal vrAtividade) {
			this.vrAtividade = vrAtividade;
		}
}
