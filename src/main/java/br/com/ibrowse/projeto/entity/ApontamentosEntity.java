package br.com.ibrowse.projeto.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.ibrowse.projeto.util.JsonParseable;

 

@Entity
@Table(name="apontamentos")
public class ApontamentosEntity extends BaseEntity implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
  
    @Column(name="nr_apontamento", nullable=false)
    private int nrApontamento;
    
   
    @Size(max = 500)
    @Column(name="nm_recursos", nullable=false)
    private String nmRecursos;


	@Temporal(TemporalType.DATE)
    @Column(name="dt_Lancamento", nullable=false, length=100)
    private Date dtLancamento;

    @Temporal(TemporalType.DATE)
    @Column(name="dt_apontamento", nullable=false, length=100)
    private Date dtapontamento;

    @Column(name="vr_atividade", nullable=false, length=100)
    private BigDecimal vratividade;
  
    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;
    
    @Size(max = 500)
    @Column(name="nm_projetos", nullable=false)
    private String nmProjetos;
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
    }
   
   
    public BigDecimal getVratividade() {
		return vratividade;
	}

	public void setVratividade(BigDecimal vratividade) {
		this.vratividade = vratividade;
	}

	@ManyToOne
    @JoinColumn(name="oid_atividade")
    private AtividadesEntity oidAtividade ;


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
 
   public AtividadesEntity getOIDAtividade() {
		return oidAtividade;
	}

	public void setOIDAtividade(AtividadesEntity oidAtividade) {
		this.oidAtividade = oidAtividade;
    }
    
	public String getNmProjetos() {
		return nmProjetos;
	}

	public void setNmProjetos(String nmProjetos) {
		this.nmProjetos = nmProjetos;
	}
    
    
	
}
    