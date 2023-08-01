package br.com.ibrowse.projeto.business.service.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.ProjetosService;
import br.com.ibrowse.projeto.business.service.RecursosService;
import br.com.ibrowse.projeto.data.repository.RecursosRepository;
import br.com.ibrowse.projeto.dto.ProjetosTabelaDTO;
import br.com.ibrowse.projeto.dto.RecursosTabelaDTO;
import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.ibrowse.projeto.entity.ProjetosEntity;
import br.com.ibrowse.projeto.entity.RecursosEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;


@Service
public class RecursosServiceImp extends BaseAbstractServiceAPIImpl<RecursosEntity>  implements RecursosService { 

	@Autowired
private RecursosRepository recursosRepository;

	@Override
	public Page<RecursosEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		String newField = "%"+nmusuario+"%";
		return recursosRepository.findByExample(nmusuario, pageRequest);
	}
	
	
	@Override
	public List<RecursosTabelaDTO> findTabelaRecurso(String field) {
		String newField = "%"+field+"%";
		List<RecursosTabelaDTO> RecursoTabela = recursosRepository.findTabelaRecurso(newField);
		/*for(ProjetosTabelaDTO projetoTabela: projetoTabela) {
			if(empresaTabela.getNRCNPJ() != null && empresaTabela.getNRCNPJ().length() >= 11) {
				empresaTabela.setNRCNPJ(MaskUtils.imprimeCNPJ(empresaTabela.getNRCNPJ()));
			}
		}*/
		return RecursoTabela;
	}

	@Override
	public List<RecursosEntity> findByNmrecursos(String nmrecrusos) {
		return recursosRepository.findByNmrecursos(nmrecrusos);
	}

	@Override
	protected RecursosEntity validateEntity(RecursosEntity obj) throws Exception {
		return obj;
	}
	

	
	
}
