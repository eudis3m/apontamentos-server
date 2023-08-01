package br.com.ibrowse.projeto.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibrowse.projeto.data.repository.query.ProjetosQuery;
import br.com.ibrowse.projeto.data.repository.query.UsuarioQuery;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.dto.ProjetosTabelaDTO;
import br.com.ibrowse.projeto.entity.ProjetosEntity;



public interface ProjetosRepository extends PagingAndSortingRepository<ProjetosEntity, Long> {
	
	@Query(value = ProjetosQuery.FIND_TABELA_Projetos)
	List<ProjetosTabelaDTO> findTabelaProjetos(String field);


	List<ProjetosEntity> findByNmprojeto(String nmprojeto);


	List<ProjetosEntity> findByDtprojetoinicio(Date dtprojetoinicio);

	@Query(value = ProjetosQuery.FIND_TABELA_Example)
	Page<ProjetosEntity> findByExample(@Param("nmusuario") String nmusuario,  Pageable pageRequest);



}
