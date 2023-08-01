package br.com.ibrowse.projeto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ibrowse.projeto.util.JsonParseable;

@Entity
@Table(name="empresa")
public class EmpresaEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
   
    
    @NotEmpty
    @Size(max = 500)
    @Column(name="nm_empresa", nullable=false)
    private String nmempresa;

    @NotEmpty
    @Size(max = 500)
    @Column(name="nr_cnpj", nullable=false)
    private String nrCNPJ;

    @NotEmpty
    @Size(max = 500)
    @Column(name="nr_telefone", nullable=false)
    private String nrTelefone;

    @NotEmpty
    @Size(max = 500)
    @Column(name="ds_rua", nullable=false)
    private String dsrua;
    
    @NotEmpty
    @Size(max = 500)
    @Column(name="ds_bairro", nullable=false)
    private String dsbairro;
    
    @NotEmpty
    @Size(max = 500)
    @Column(name="ds_cidade", nullable=false)
    private String dscidade;
    
 
    @Column(name="ds_numero", nullable=false)
    private long dsnumero;
    
   
    @Size(max = 500)
    @Column(name="ds_complemento", nullable=false)
    private String dscomplemento;
    
    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
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

	public void setDsNumero(long dsNumero) {
		this.dsnumero = dsNumero;
	}

	public String getDsComplemento() {
		return dscomplemento;
	}

	public void setDsComplemento(String dscomplemento) {
		this.dscomplemento = dscomplemento;
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
    
   
}
    