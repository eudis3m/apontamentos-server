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

import br.com.ibrowse.projeto.data.repository.query.AtividadesQuery;
import br.com.ibrowse.projeto.data.repository.query.CentroCustoQuery;
import br.com.ibrowse.projeto.dto.CentroCustoTabelaDTO;
import br.com.ibrowse.projeto.entity.CentroCustoEntity;



public interface CentrosCustosRepository extends PagingAndSortingRepository<CentroCustoEntity, Long> {
	@Query(value =CentroCustoQuery.FIND_TABELA_CentroCusto)
	List<CentroCustoTabelaDTO> findTabelaCentroCusto(Long field);

	@Query(value = CentroCustoQuery.FIND_TABELA_Example)
	Page<CentroCustoEntity> findByExample(@Param("nmusuario") String nmusuario,   Pageable pageRequest);



}
