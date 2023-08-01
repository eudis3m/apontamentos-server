package br.com.ibrowse.projeto.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.ibrowse.projeto.data.repository.query.ProjetosQuery;
import br.com.ibrowse.projeto.data.repository.query.RecursosQuery;
import br.com.ibrowse.projeto.dto.ProjetosTabelaDTO;
import br.com.ibrowse.projeto.dto.RecursosTabelaDTO;
import br.com.ibrowse.projeto.entity.RecursosEntity;



public interface RecursosRepository extends PagingAndSortingRepository<RecursosEntity, Long> {


	@Query(value = RecursosQuery.FIND_TABELA_Example)
	Page<RecursosEntity> findByExample(@Param("nmusuario") String nmusuario,  Pageable pageRequest);

	@Query(value = RecursosQuery.FIND_TABELA_Recursos)
	List<RecursosTabelaDTO> findTabelaRecurso(String field);

	List<RecursosEntity> findByNmrecursos(String nmrecursos);
	
}