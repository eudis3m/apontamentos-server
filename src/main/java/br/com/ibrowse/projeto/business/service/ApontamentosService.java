package br.com.ibrowse.projeto.business.service;


import java.util.List;

import org.springframework.data.domain.Page;

import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;



public interface ApontamentosService extends BaseServiceAPI<ApontamentosEntity>{
	
    public Page<ApontamentosEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<ApontamentosTabelaDTO> findTabelaApontamentos(int field);

	public List<ApontamentosEntity> findByNmRecursos(String nmRecursos, String nmusuario , String nmProjetos);

	

}
