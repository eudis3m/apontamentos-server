package br.com.ibrowse.projeto.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import br.com.ibrowse.projeto.dto.RecursosTabelaDTO;
import br.com.ibrowse.projeto.entity.RecursosEntity;



public interface RecursosService extends BaseServiceAPI<RecursosEntity>{
	
    public Page<RecursosEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<RecursosTabelaDTO> findTabelaRecurso(String field);

	public List<RecursosEntity> findByNmrecursos(String nmrecursos);


}
