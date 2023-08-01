package br.com.ibrowse.projeto.business.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.BaseEntity;
import br.com.ibrowse.projeto.entity.EmpresaEntity;


public interface EmpresaService extends BaseServiceAPI<EmpresaEntity>{
	
    public Page<EmpresaEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<EmpresaTabelaDTO> findTabelaEmpresa(String nmEmpresa);


	public List<EmpresaEntity> findByNmempresa(String nmempresa);

	public List<EmpresaEntity> findByNrcnpj(String nrCNPJ);

}
