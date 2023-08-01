package br.com.ibrowse.projeto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ibrowse.projeto.util.JsonParseable;


@Entity
@Table(name="recursos")
public class RecursosEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotEmpty
    @Size(max = 500)
    @Column(name="nm_recursos", nullable=false)
    private String nmrecursos;
    
    @Size(max = 500)
    @Column(name="nm_usuario", nullable=false, length=100)
    private String nmusuario;
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
    }
   
	public String getNMrecursos() {
		return nmrecursos;
	}

	public void setNMrecursos(String nmrecursos) {
		this.nmrecursos = nmrecursos;
	}

    
}
    