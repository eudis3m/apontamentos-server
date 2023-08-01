package br.com.ibrowse.projeto.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioTabelaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String dssenha;
	String nmusuario;
	String nrcpf;
	String dsLogin;
	String nmrecursos;
	
	public UsuarioTabelaDTO() {
		
	}
	public UsuarioTabelaDTO(String dssenha, String nmusuario, String nrcpf, String dsLogin,String nmrecursos) {
		super();
		this.dssenha = dssenha;
		this.nmusuario = nmusuario;
		this.nrcpf = nrcpf;
		this.dsLogin = dsLogin;
		this.nmrecursos = nmrecursos;
	}
	
	public String getDSSenha() {
		return dssenha;
	}

	public void setDSSenha(String dssenha) {
		this.dssenha = dssenha;
	}

	public String getNrcpf() {
		return nrcpf;
	}

	public void setNrcpf(String nrcpf) {
		this.nrcpf = nrcpf;
	}
    
    public String getNMUsuario() {
		return nmusuario;
    }
    
    public void setNMUsuario(String nmusuario) {
		this.nmusuario = nmusuario;
    }
    
    public String getNmRecursos() {
		return nmrecursos;
	}

	public void setNmRecursos(String nmrecursos) {
		this.nmrecursos = nmrecursos;
	}
	public String getDsLogin() {
		return dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}

    
}
