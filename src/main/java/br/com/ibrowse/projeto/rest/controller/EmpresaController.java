package br.com.ibrowse.projeto.rest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.ibrowse.projeto.business.service.EmpresaService;
import br.com.ibrowse.projeto.business.service.serviceImp.EmpresaServiceImp;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.rest.api.EmpresaAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;


@RestController
public  class EmpresaController extends BaseAbstractControllerResourceImpl<EmpresaEntity>  implements EmpresaAPI {

	@Autowired
	public EmpresaService empresaService;

	@Override
	public ResponseEntity<Page<EmpresaEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue="nmempresa") String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String  nmusuario
	) {
		return ResponseEntity.ok().body(empresaService.findByExample(page, linesPerPage, orderBy, direction, field, nmusuario));
	}
	
	
	@Override
	public ResponseEntity<List<EmpresaTabelaDTO>> findTabelaEmpresa(@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, defaultValue="")  String field) {
		return ResponseEntity.ok().body(empresaService.findTabelaEmpresa(field));
	}

	
	@Override
	public ResponseEntity<List<EmpresaEntity>> findByNmempresa(@PathVariable("nmempresa") String nmempresa) throws Exception {
		return ResponseEntity.ok().body(empresaService.findByNmempresa(nmempresa));
	}

	@Override
	public ResponseEntity<List<EmpresaEntity>> findByNrcnpj(@PathVariable("nrcnpj") String nrCNPJ) throws Exception {
		return ResponseEntity.ok().body(empresaService.findByNrcnpj(nrCNPJ));
	}

	
	/*@Override
	public ResponseEntity<EmpresaEntity> delete(@PathVariable Long oid) throws Exception {
		service.delete(oid);
		return ResponseEntity.noContent().build();
	}*/


}
