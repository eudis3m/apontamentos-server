package br.com.ibrowse.projeto.rest.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibrowse.projeto.business.service.BaseServiceAPI;
import br.com.ibrowse.projeto.business.service.serviceImp.BaseAbstractServiceAPIImpl;
import br.com.ibrowse.projeto.entity.BaseEntity;
import br.com.ibrowse.projeto.rest.api.BaseResourceAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;


public abstract  class BaseAbstractControllerResourceImpl <T extends BaseEntity> implements BaseResourceAPI<T>  {

	@Autowired
	public  BaseServiceAPI<T> service;
	
	@Override 
	public ResponseEntity<Page<T>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue=APIControllersUtils.DEFAULT_ORDER_BY) String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam(value=APIControllersUtils.DEFINITION_USUARIO, 		defaultValue=APIControllersUtils.DEFINITION_USUARIO) String  nmusuario
	) {
		Page<T> list = service.findAllPage(page, linesPerPage, orderBy, direction, nmusuario );
		return ResponseEntity.ok().body(list);
	} 

	@Override
	public ResponseEntity<T> findById(@PathVariable("oid") Long oid) throws Exception {
		T objEntity = service.findById(oid);
		return ResponseEntity.ok().body(objEntity);		
	}

	@Override
	public ResponseEntity<T> save(@Valid @RequestBody T obj) throws Exception {
		T objEntityNew = service.create(obj);
		
		URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return ResponseEntity.created(uri).body(objEntityNew);
	}

	@Override
	public ResponseEntity<T> update(@Valid @RequestBody T obj) throws Exception {
		T objUpdated = service.update(obj);
		return ResponseEntity.ok().body(objUpdated);
	}

	/*@Override
	public ResponseEntity<T> delete(@PathVariable Long oid) throws Exception {
		T objUpdated = service.findById(oid);
		objUpdated.setIdAtivo("N");
		return ResponseEntity.ok().body(service.update(objUpdated));
	}*/
	@Override
	public ResponseEntity<T> delete(@PathVariable Long oid) throws Exception {
		T objUpdated = service.findById(oid);
		if(objUpdated != null) {
		service.delete(oid);
		return ResponseEntity.noContent().build();
		}
		return null;
	}

}
