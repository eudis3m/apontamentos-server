package br.com.ibrowse.projeto.data.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibrowse.projeto.data.repository.query.ApontamentosQuery;
import br.com.ibrowse.projeto.data.repository.query.EmpresaQuery;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public interface ApontamentosRepository extends PagingAndSortingRepository<ApontamentosEntity, Long> {

   
 //   List<ApontamentosEntity> findByOrderByOidApontamentoAsc();


   @Query(value = ApontamentosQuery.FIND_TABELA_Example)
   Page<ApontamentosEntity> findByExample(@Param("nmusuario") String nmusuario,   Pageable pageRequest);

   @Query(value =ApontamentosQuery.FIND_TABELA_Apontamentos)
   List<ApontamentosTabelaDTO> findTabelaApontamentos(int field);
 
   @Query(value = ApontamentosQuery.FIND_Recursos)
   List<ApontamentosEntity> findByNmRecursosAndNmusuarioAndNmProjetos(@Param("nmRecursos") String nmRecursos, @Param("nmusuario") String nmusuario ,  @Param("nmProjetos") String nmProjetos);


	

}
