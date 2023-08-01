package br.com.ibrowse.projeto.rest.api;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;



@RequestMapping(value = "/empresa")
public interface EmpresaAPI extends BaseResourceAPI<EmpresaEntity>  {

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Page<EmpresaEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue=APIControllersUtils.DEFAULT_ORDER_BY) String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String  nmusuario
	);
	
	
	@GetMapping(value="/nmempresa/{nmempresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<EmpresaEntity>> findByNmempresa(@PathVariable("nmempresa") String Nmempresa) throws Exception;
	
	@GetMapping(value="/nrcnpj/{nrcnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<EmpresaEntity>> findByNrcnpj(@PathVariable("nrcnpj") String Nrcnpj) throws Exception;
	
	@GetMapping(value="/tabela/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<EmpresaTabelaDTO>> findTabelaEmpresa(
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, defaultValue="") String field);
	
	/*@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<EmpresaEntity> delete(@PathVariable int id) throws Exception;*/
	

}
