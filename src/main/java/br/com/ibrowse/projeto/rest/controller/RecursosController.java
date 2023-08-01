package br.com.ibrowse.projeto.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibrowse.projeto.business.service.RecursosService;
import br.com.ibrowse.projeto.business.service.serviceImp.RecursosServiceImp;
import br.com.ibrowse.projeto.dto.RecursosTabelaDTO;
import br.com.ibrowse.projeto.entity.ProjetosEntity;
import br.com.ibrowse.projeto.entity.RecursosEntity;
import br.com.ibrowse.projeto.rest.api.RecursosAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;
import br.com.ibrowse.projeto.util.ProjetosControllerUtils;


@RestController
public class RecursosController extends BaseAbstractControllerResourceImpl<RecursosEntity> implements RecursosAPI {
	@Autowired
	public RecursosService recursosService;
	
	@Override
	public ResponseEntity<Page<RecursosEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue="nmrecursos") String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String nmusuario
	) {
		return ResponseEntity.ok().body(recursosService.findByExample(page, linesPerPage, orderBy, direction, field, nmusuario));
	}

	@Override
	public ResponseEntity<List<RecursosEntity>> findByNmrecursos(String nmrecursos) throws Exception {
		return ResponseEntity.ok().body(recursosService.findByNmrecursos(nmrecursos));
	}

	@Override
	public ResponseEntity<List<RecursosTabelaDTO>> findTabelaRecursos(String field) {
		return ResponseEntity.ok().body(recursosService.findTabelaRecurso(field));
	}
	
	

}
