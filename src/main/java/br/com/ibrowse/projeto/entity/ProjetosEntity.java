package br.com.ibrowse.projeto.entity;

import java.io.Serializable;
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
@Table(name="projetos")

public class ProjetosEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @Size(max = 500)
    @Column(name="nm_projeto", nullable=false, length=100)
    private String nmprojeto;

    @Temporal(TemporalType.DATE)
    @Column(name="dt_projeto_inicio", nullable=false)
    private Date dtprojetoinicio;

    @Temporal(TemporalType.DATE)
    @Column(name="dt_projeto_final", nullable=false)
    private Date dtProjetoFinal;

    @Size(max = 500)
    @Column(name="ds_descricao_projeto", nullable=false, length=100)
    private String dsDescricaoProjeto;
    
    @Size(max = 500)
    @Column(name="nm_empresa", nullable=false, length=100)
    private String nmEmpresa;
 

	
    @Column(name="vr_custo_aprovado", nullable=false, length=100)
    private long vrcustoAprovado;


	@ManyToOne
    @JoinColumn(name="oid_centro_custo")
    private CentroCustoEntity oidCentroCusto ;

    @ManyToOne
    @JoinColumn(name="oid_empresa")
    private EmpresaEntity oidEmpresa ;
    
	 
    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
    }
   
	  public String getNMProjeto() {
			return nmprojeto;
		}

		public void setNMProjeto(String nmprojeto) {
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
   
   public CentroCustoEntity getCentroCusto() {
		return oidCentroCusto;
	}

	public void setCentrosCustos(CentroCustoEntity oidCentroCusto) {
		this.oidCentroCusto = oidCentroCusto;
    }
    
    public EmpresaEntity getOIDEmpresa() {
		return oidEmpresa;
	}

	public void setOIDEmpresa(EmpresaEntity oidEmpresa) {
		this.oidEmpresa = oidEmpresa;
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
    