package br.com.ibrowse.projeto.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibrowse.projeto.business.service.UsuarioService;
import br.com.ibrowse.projeto.business.service.serviceImp.UsuarioServiceImp;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.entity.UsuarioEntity;
import br.com.ibrowse.projeto.rest.api.UsuariosAPI;
import br.com.ibrowse.projeto.rest.api.utils.APIControllersUtils;
import br.com.ibrowse.projeto.util.ProjetosControllerUtils;

@RestController
public class UsuariosController extends BaseAbstractControllerResourceImpl<UsuarioEntity> implements UsuariosAPI {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public ResponseEntity<Page<UsuarioEntity>> findAll(
			@RequestParam(value=APIControllersUtils.DEFINITION_PAGE, 			defaultValue=APIControllersUtils.DEFAULT_PAGE) Integer page, 
			@RequestParam(value=APIControllersUtils.DEFINITION_LINES_PER_PAGE, 	defaultValue=APIControllersUtils.DEFAULT_LINES_PER_PAGES) Integer linesPerPage, 
			@RequestParam(value=APIControllersUtils.DEFINITION_ORDER_BY, 		defaultValue="nmusuario") String orderBy, 
			@RequestParam(value=APIControllersUtils.DEFINITION_DIRECTION, 		defaultValue=APIControllersUtils.DEFAULT_DIRECTION) String direction,
			@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, 			defaultValue=APIControllersUtils.DEFAULT_FIELD) String field,
			@RequestParam("nmusuario") String nmusuario
	) {
		return ResponseEntity.ok().body(usuarioService.findByExample(page, linesPerPage, orderBy, direction, field,nmusuario));
	}

	@Override
	public ResponseEntity<List<UsuarioEntity>> findByDslogin(@PathVariable("dsLogin") String dsLogin) throws Exception {
		return ResponseEntity.ok().body(usuarioService.findByDslogin(dsLogin));
	}

	@Override
	public ResponseEntity<List<UsuarioEntity>> findByNrCpf(@PathVariable("nrcnpj") String nrcnpj) throws Exception {
		return ResponseEntity.ok().body(usuarioService.findByNrcpf(nrcnpj));
	}

	@Override
	public ResponseEntity<List<UsuarioTabelaDTO>> findTabelaUsuario(@RequestParam(value=APIControllersUtils.DEFINITION_FIELD, defaultValue="") String field) {
		return ResponseEntity.ok().body(usuarioService.findTabelaUsuario(field));
	}
	
	

}