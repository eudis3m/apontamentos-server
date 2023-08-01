package br.com.ibrowse.projeto.business.service.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.UsuarioService;
import br.com.ibrowse.projeto.data.repository.UsuarioRepository;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.entity.UsuarioEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;
import br.com.ibrowse.projeto.util.CryptoUtils;
import br.com.ibrowse.projeto.util.MaskUtils;



@Service
public class UsuarioServiceImp  extends BaseAbstractServiceAPIImpl<UsuarioEntity>  implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioTabelaDTO> findTabelaUsuario(String field) {
		String newField = "%"+field+"%";
		List<UsuarioTabelaDTO> UsuarioTabela = usuarioRepository.findTabelaUsuario(newField);
		for(UsuarioTabelaDTO usuarioTabela: UsuarioTabela) {
			if(usuarioTabela.getNrcpf() != null && usuarioTabela.getNrcpf().length() >= 11) {
				usuarioTabela.setNrcpf((MaskUtils.imprimeCPF(usuarioTabela.getNrcpf())));
			}
		}
		return UsuarioTabela;
	}
	
	@Override
	public Page<UsuarioEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		String newField = "%"+nmusuario+"%";
		return usuarioRepository.findByExample(nmusuario, pageRequest);
	}

	@Override
	public List<UsuarioEntity> findByDslogin(String dsLogin) {
		return usuarioRepository.findByDsLogin(dsLogin);
	}

	@Override
	public List<UsuarioEntity> findByNrcpf(String dssenha) {
		return usuarioRepository.findByNrcpf(dssenha);
	}

	@Override
	protected UsuarioEntity validateEntity(UsuarioEntity obj) throws Exception {
		return obj;
	}
	
	

}