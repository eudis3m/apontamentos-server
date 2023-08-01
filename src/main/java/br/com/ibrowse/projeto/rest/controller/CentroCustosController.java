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

import br.com.ibrowse.projeto.business.service.CentroCustoService;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.AtividadesTabelaDTO;
import br.com.ibrowse.projeto.dto.CentroCustoTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.AtividadesEntity;
import br.com.ibrowse.projeto.entity.CentroCustoEntity;
import br.com.ibrowse.projeto.rest.api.ApontamentosAPI;
import br.com.ibrowse.projeto.rest.api.Centro_CustoAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;
import br.com.ibrowse.projeto.util.ProjetosControllerUtils;


@RestController
public class CentroCustosController extends BaseAbstractControllerResourceImpl<CentroCustoEntity>  implements Centro_CustoAPI {
	
	@Autowired
	private CentroCustoService centrocustoService;

	@Override
	public ResponseEntity<Page<CentroCustoEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue="vrcustoAprovado") String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field, 
			@RequestParam("nmusuario") String  nmusuario
	) {
		return ResponseEntity.ok().body(centrocustoService.findByExample(page, linesPerPage, orderBy, direction, field, nmusuario));
	}


	@Override
	public ResponseEntity<List<CentroCustoTabelaDTO>> findTabelaCentroCusto(Long field) {
		return ResponseEntity.ok().body(centrocustoService.findTabelaCentroCusto(field));
	} 

	
	}
