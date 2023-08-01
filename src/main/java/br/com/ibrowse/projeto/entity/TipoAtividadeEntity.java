package br.com.ibrowse.projeto.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.ibrowse.projeto.util.JsonParseable;


@Entity
@Table(name="tipo_Atividades")

public class TipoAtividadeEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(max = 500)
    @Column(name="nm_tipo_atividade", nullable=false , length=100)
    private String nmtipoAtividade;

  
    @Column(name="vr_atividade", nullable=false , length=100)
    private BigDecimal vrAtividade;
    
    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
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
    