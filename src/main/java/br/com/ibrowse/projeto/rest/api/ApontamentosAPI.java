package br.com.ibrowse.projeto.rest.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.RecursosEntity;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;

@RequestMapping(value = "/apontamentos")
public interface ApontamentosAPI extends BaseResourceAPI<ApontamentosEntity>  {
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Page<ApontamentosEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue=APIControllersUtils.DEFAULT_ORDER_BY) String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String  nmusuario
	);
	
	@GetMapping(value="/nmRecursos/{nmRecursos}/{nmusuario}/{nmProjetos}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<ApontamentosEntity>> findByNmRecursos(@PathVariable("nmRecursos") String nmRecursos, @PathVariable("nmusuario") String nmusuario, @PathVariable("nmProjetos") String nmProjetos ) throws Exception;
	
	@GetMapping(value="/tabela/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<ApontamentosTabelaDTO>> findTabelaApontamentos(
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, defaultValue="")int field);
	
	

}
