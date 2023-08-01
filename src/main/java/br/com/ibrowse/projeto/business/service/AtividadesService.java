package br.com.ibrowse.projeto.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.ibrowse.projeto.dto.AtividadesTabelaDTO;
import br.com.ibrowse.projeto.entity.AtividadesEntity;



public interface AtividadesService extends BaseServiceAPI<AtividadesEntity>{
	
    public Page<AtividadesEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<AtividadesTabelaDTO> findTabelaAtividades(Date field);

	public List<AtividadesEntity> findByNmrecursos(String nmRecursos, String nmProjetos);

	public List<AtividadesEntity>findByNmProjetos(String nmProjetos);



}
