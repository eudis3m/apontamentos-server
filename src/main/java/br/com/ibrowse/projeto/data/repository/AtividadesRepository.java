package br.com.ibrowse.projeto.data.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.ibrowse.projeto.data.repository.query.ApontamentosQuery;
import br.com.ibrowse.projeto.data.repository.query.AtividadesQuery;
import br.com.ibrowse.projeto.dto.AtividadesTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.AtividadesEntity;



public interface AtividadesRepository extends PagingAndSortingRepository<AtividadesEntity, Long> {

@Query(value = AtividadesQuery.FIND_TABELA_Example)
Page<AtividadesEntity> findByExample(@Param("nmusuario") String nmusuario,   Pageable pageRequest);

@Query(value =AtividadesQuery.FIND_TABELA_Atividades)
List<AtividadesTabelaDTO> findTabelaAtividades(Date field);

//@Query(value = AtividadesQuery.FIND_Recursos)
List<AtividadesEntity> findByNmRecursosAndNmProjetos(@Param("nmRecursos")String nmRecursos , @Param("nmProjetos")String nmProjetos );


List<AtividadesEntity> findByNmProjetos(@Param("nmProjetos")String nmProjetos );
  
List<AtividadesEntity> findByNmRecursos(@Param("nmRecursos")String nmRecursos );
}
