package br.com.ibrowse.projeto.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.ibrowse.projeto.util.JsonParseable;


@Entity
@Table(name="atividades")

public class AtividadesEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name="dt_inicio", nullable=false )
    private Date dtInicio;

    @Temporal(TemporalType.DATE)
    @Column(name="dt_final", nullable=false )
    private Date dtFinal;
    
   

	@Column(name=" nr_horas_atividade", nullable=false)
    private int nrhorasAtividade;
    
    @Size(max = 500)
    @Column(name="nm_recursos", nullable=false)
    private String nmRecursos;
 

	@Size(max = 500)
    @Column(name="nm_projetos", nullable=false)
    private String nmProjetos;

    @ManyToOne
    @JoinColumn(name="oid_recursos")
    private RecursosEntity oidRecursos ;

    @ManyToOne
    @JoinColumn(name="oid_projetos")
    private ProjetosEntity oidProjetos ;

    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
    }
   
    
    public int getNrhorasAtividade() {
		return nrhorasAtividade;
    }
    
    public void setNrhorasAtividade(int nrhorasAtividade) {
		this.nrhorasAtividade = nrhorasAtividade;
    }
    
    public RecursosEntity getOIDRecursos() {
		return oidRecursos;
	}

	public void setOIDRecursos(RecursosEntity oidRecursos) {
		this.oidRecursos = oidRecursos;
    }
    
    public ProjetosEntity getOIDProjeto() {
		return oidProjetos;
	}

	public void setOIDProjeto(ProjetosEntity oidProjetos) {
		this.oidProjetos = oidProjetos;
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
    