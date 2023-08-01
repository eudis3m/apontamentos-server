package br.com.ibrowse.projeto.business.service.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.TipoAtividadeService;
import br.com.ibrowse.projeto.business.service.UsuarioService;
import br.com.ibrowse.projeto.data.repository.TiposAtividadesRepository;
import br.com.ibrowse.projeto.dto.TipoAtividadeTabelaDTO;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.TipoAtividadeEntity;
import br.com.ibrowse.projeto.entity.UsuarioEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;
import br.com.ibrowse.projeto.util.MaskUtils;

@Service
public class TipoAtividadeServiceImp extends BaseAbstractServiceAPIImpl<TipoAtividadeEntity>  implements TipoAtividadeService {

	@Autowired
private TiposAtividadesRepository tiposAtividadesRepository;

	@Override
	public List<TipoAtividadeTabelaDTO> findTabelaTipoAtividade(String field) {
		String newField = "%"+field+"%";
		List<TipoAtividadeTabelaDTO> TipoAtividadeTabela = tiposAtividadesRepository.findTabelaUsuario(newField);
		
		return TipoAtividadeTabela;
	}

	@Override
	protected TipoAtividadeEntity validateEntity(TipoAtividadeEntity obj) throws Exception {
		return obj;
	}
	
	@Override
	public Page<TipoAtividadeEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		String newField = "%"+nmusuario+"%";
		return tiposAtividadesRepository.findByExample(nmusuario, pageRequest);
	}
	
	
}
