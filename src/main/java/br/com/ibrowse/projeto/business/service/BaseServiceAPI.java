package br.com.ibrowse.projeto.business.service;

import org.springframework.data.domain.Page;

import br.com.ibrowse.projeto.entity.BaseEntity;


public interface BaseServiceAPI<T extends BaseEntity> {
	
	public Page<T> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction, String nmusuario);
	
	public Page<T> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public T findById(Long oid) throws Exception;
	
	public T create(T obj) throws Exception;
	
	public T update(T obj) throws Exception;
	
	public void delete(Long oid) throws Exception;
}
