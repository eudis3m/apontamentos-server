package br.com.ibrowse.projeto.helper;

import br.com.ibrowse.projeto.entity.UsuarioEntity;
import br.com.ibrowse.projeto.rest.api.response.UsuarioLogado;

public final class LoginHelper {

    public static UsuarioLogado fromUsuario(UsuarioEntity usuario) {
        UsuarioLogado usuarioLogado = new UsuarioLogado();
        usuarioLogado.setSenha(usuario.getDSSenha());
        usuarioLogado.setLogin(usuario.getNMUsuario());
        return usuarioLogado;
    }

}
