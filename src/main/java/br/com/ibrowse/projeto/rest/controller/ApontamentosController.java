package br.com.ibrowse.projeto.rest.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import br.com.ibrowse.projeto.business.service.ApontamentosService;
import br.com.ibrowse.projeto.business.service.serviceImp.ApontamentosServiceImp;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.rest.api.ApontamentosAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;
import br.com.ibrowse.projeto.util.ProjetosControllerUtils;


@RestController
public  class ApontamentosController extends BaseAbstractControllerResourceImpl<ApontamentosEntity> implements ApontamentosAPI{

	@Autowired
	public ApontamentosService  apontamentosService;
	
	@Override
	public ResponseEntity<Page<ApontamentosEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue="dtapontamento") String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String  nmusuario
	) {
		return ResponseEntity.ok().body(apontamentosService.findByExample(page, linesPerPage, orderBy, direction, field, nmusuario));
	}

	

	@Override
	public ResponseEntity<List<ApontamentosTabelaDTO>> findTabelaApontamentos(int field) {
		return ResponseEntity.ok().body(apontamentosService.findTabelaApontamentos(field));
	}


	@Override
	public ResponseEntity<List<ApontamentosEntity>> findByNmRecursos(@PathVariable String nmRecursos , @PathVariable String nmusuario , @PathVariable String nmProjetos) throws Exception {
		return ResponseEntity.ok().body(apontamentosService.findByNmRecursos(nmRecursos, nmusuario, nmProjetos));
	} 
	
	

}
