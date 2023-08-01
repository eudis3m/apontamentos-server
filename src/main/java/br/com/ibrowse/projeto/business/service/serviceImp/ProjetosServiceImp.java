package br.com.ibrowse.projeto.business.service.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.EmpresaService;
import br.com.ibrowse.projeto.business.service.ProjetosService;
import br.com.ibrowse.projeto.data.repository.ProjetosRepository;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.dto.ProjetosTabelaDTO;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.entity.ProjetosEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;
import br.com.ibrowse.projeto.util.MaskUtils;


@Service
public class ProjetosServiceImp extends BaseAbstractServiceAPIImpl<ProjetosEntity>  implements ProjetosService {

	@Autowired
	private ProjetosRepository projetosRepository;
	
	@Override
	public Page<ProjetosEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		String newField = "%"+nmusuario+"%";
		return projetosRepository.findByExample(nmusuario, pageRequest);
	}
	

	@Override
	public List<ProjetosTabelaDTO> findTabelaProjeto(String field) {
		String newField = "%"+field+"%";
		List<ProjetosTabelaDTO> ProjetoTabela = projetosRepository.findTabelaProjetos(newField);
		/*for(ProjetosTabelaDTO projetoTabela: projetoTabela) {
			if(empresaTabela.getNRCNPJ() != null && empresaTabela.getNRCNPJ().length() >= 11) {
				empresaTabela.setNRCNPJ(MaskUtils.imprimeCNPJ(empresaTabela.getNRCNPJ()));
			}
		}*/
		return ProjetoTabela;
	}

	@Override
	public List<ProjetosEntity> findByNmprojeto(String nmprojeto) {
	return projetosRepository.findByNmprojeto(nmprojeto);
	}

	@Override
	public List<ProjetosEntity> findByDtprojetoInicio(Date dtprojetoinicio) {
		return projetosRepository.findByDtprojetoinicio(dtprojetoinicio);
	}

	@Override
	protected ProjetosEntity validateEntity(ProjetosEntity obj) throws Exception {
		return obj;
	}

	
}
