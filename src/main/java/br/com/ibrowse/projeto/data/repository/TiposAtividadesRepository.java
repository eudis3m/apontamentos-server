package br.com.ibrowse.projeto.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibrowse.projeto.data.repository.query.RecursosQuery;
import br.com.ibrowse.projeto.data.repository.query.TipoAtividadeQuery;
import br.com.ibrowse.projeto.dto.TipoAtividadeTabelaDTO;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.TipoAtividadeEntity;


public interface TiposAtividadesRepository extends PagingAndSortingRepository<TipoAtividadeEntity, Long> {

	@Query(value = TipoAtividadeQuery.FIND_TABELA_TipoAtividade)
	List<TipoAtividadeTabelaDTO> findTabelaUsuario(String field);

	@Query(value = TipoAtividadeQuery.FIND_TABELA_Example)
	Page<TipoAtividadeEntity> findByExample(@Param("nmusuario") String nmusuario, Pageable pageRequest);




	
}
