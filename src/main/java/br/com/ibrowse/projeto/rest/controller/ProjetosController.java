package br.com.ibrowse.projeto.rest.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibrowse.projeto.business.service.ProjetosService;
import br.com.ibrowse.projeto.business.service.serviceImp.ProjetosServiceImp;
import br.com.ibrowse.projeto.dto.ProjetosTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.entity.ProjetosEntity;
import br.com.ibrowse.projeto.rest.api.ProjetosAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;
import br.com.ibrowse.projeto.util.ProjetosControllerUtils;


@RestController
public class ProjetosController extends BaseAbstractControllerResourceImpl<ProjetosEntity> implements ProjetosAPI {
	
	@Autowired
	private ProjetosService projetosService;

	@Override
	public ResponseEntity<Page<ProjetosEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue="nmprojeto") String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String  nmusuario
	) {
		return ResponseEntity.ok().body(projetosService.findByExample(page, linesPerPage, orderBy, direction, field, nmusuario));
	}
	

	@Override
	public ResponseEntity<List<ProjetosEntity>> findByNmprojeto(String nmprojeto) throws Exception {
		return ResponseEntity.ok().body(projetosService.findByNmprojeto(nmprojeto));
	}

	@Override
	public ResponseEntity<List<ProjetosEntity>> findByDtprojetoinicio(Date dtprojetoinicio) throws Exception {
		return ResponseEntity.ok().body(projetosService.findByDtprojetoInicio(dtprojetoinicio));
	}

	@Override
	public ResponseEntity<List<ProjetosTabelaDTO>> findTabelaProjetos(String field) {
		return ResponseEntity.ok().body(projetosService.findTabelaProjeto(field));
	}
	
	

}
