package br.com.ibrowse.projeto.business.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.dto.ProjetosTabelaDTO;
import br.com.ibrowse.projeto.entity.BaseEntity;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.entity.ProjetosEntity;


public interface ProjetosService extends BaseServiceAPI<ProjetosEntity>{
	
    public Page<ProjetosEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<ProjetosTabelaDTO> findTabelaProjeto(String field);


	public List<ProjetosEntity> findByNmprojeto(String nmprojeto);

	public List<ProjetosEntity> findByDtprojetoInicio(Date dtprojetoinicio);


}
