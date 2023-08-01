package br.com.ibrowse.projeto.data.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibrowse.projeto.data.repository.query.EmpresaQuery;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;


public interface EmpresaRepository extends PagingAndSortingRepository<EmpresaEntity, Long> {

	@Query(value = EmpresaQuery.FIND_TABELA_Empresa)
	List<EmpresaTabelaDTO> findTabelaEmpresa(@Param("field") String field);

	List<EmpresaEntity> findByNmempresa(String nmempresa);

	List<EmpresaEntity> findByNrCNPJ(String nrCNPJ);

	@Query(value = EmpresaQuery.FIND_TABELA_Example)
     Page<EmpresaEntity> findByExample(@Param("nmusuario") String nmusuario,  Pageable pageRequest);
	

}
