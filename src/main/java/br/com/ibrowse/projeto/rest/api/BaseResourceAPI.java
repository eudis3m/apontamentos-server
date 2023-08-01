package br.com.ibrowse.projeto.rest.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.ibrowse.projeto.entity.BaseEntity;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;


public interface BaseResourceAPI<T extends BaseEntity> {

 //public abstract ResponseEntity<Page<T>> findAllElements(Integer page, Integer linesPerPage, String orderBy, String direction);
	
//	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Page<T>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue=APIControllersUtils.DEFAULT_ORDER_BY) String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam(value=APIControllersUtils.DEFINITION_USUARIO, 		defaultValue=APIControllersUtils.DEFINITION_USUARIO) String  nmusuario
	);

	@GetMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<T> findById(@PathVariable("oid") Long id) throws Exception;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<T> save(@Valid @RequestBody T obj) throws Exception;
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<T> update(@Valid @RequestBody T obj) throws Exception;
	
	@DeleteMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<T> delete(@PathVariable Long id) throws Exception;


}
