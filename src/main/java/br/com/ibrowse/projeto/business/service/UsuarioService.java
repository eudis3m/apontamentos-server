package br.com.ibrowse.projeto.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.UsuarioEntity;


public interface UsuarioService extends BaseServiceAPI<UsuarioEntity>{
	
    public Page<UsuarioEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<UsuarioTabelaDTO> findTabelaUsuario(String field);

	public List<UsuarioEntity> findByDslogin(String dslogin);

	public List<UsuarioEntity> findByNrcpf(String nrcnpj);

}
