package br.com.ibrowse.projeto.rest.api.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.ibrowse.projeto.util.JsonParseable;

public class LoginRequest implements Serializable, JsonParseable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String login;

    @NotEmpty
    private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
