package br.com.ibrowse.projeto.rest.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.UsuarioEntity;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;


@RequestMapping(value = "/usuarios")
public interface UsuariosAPI extends BaseResourceAPI<UsuarioEntity>  {

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Page<UsuarioEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue=APIControllersUtils.DEFAULT_ORDER_BY) String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String nmusuario
	);
	
	
	@GetMapping(value="/dsLogin/{dsLogin}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<UsuarioEntity>> findByDslogin(@PathVariable("dsLogin") String dslogin) throws Exception;
	
	@GetMapping(value="/nrcpf/{nrcpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<UsuarioEntity>> findByNrCpf(@PathVariable("nrcpf") String nrcpf) throws Exception;
	
	@GetMapping(value="/tabela/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<List<UsuarioTabelaDTO>> findTabelaUsuario(
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, defaultValue="") String field);
	
}