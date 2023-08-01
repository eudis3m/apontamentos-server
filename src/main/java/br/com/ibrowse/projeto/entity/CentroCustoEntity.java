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
@Table(name="centro_custo")
public class CentroCustoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

   
    @Column(name="vr_custo_previsto", nullable=false, length=100)
    private BigDecimal vrcustoPrevisto;
    
  
    @Column(name="vr_custo_aprovado", nullable=false, length=100)
    private BigDecimal vrcustoAprovado;

    @Size(max = 500)
    @Column(name="ds_centro_custo", nullable=false)
    private String dscentroCusto;

    @Size(max = 500)
    @Column(name="nm_projeto", nullable=false, length=100)
    private String nmprojeto;
    
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
    