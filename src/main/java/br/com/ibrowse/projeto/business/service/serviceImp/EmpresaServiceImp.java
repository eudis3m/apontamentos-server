package br.com.ibrowse.projeto.business.service.serviceImp;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.EmpresaService;
import br.com.ibrowse.projeto.data.repository.EmpresaRepository;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;
import br.com.ibrowse.projeto.util.MaskUtils;

@Service
public  class EmpresaServiceImp  extends BaseAbstractServiceAPIImpl<EmpresaEntity>  implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Page<EmpresaEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		String newField = "%"+nmusuario+"%";
		return empresaRepository.findByExample(nmusuario, pageRequest);
	}
	
	
	@Override
	public List<EmpresaTabelaDTO> findTabelaEmpresa(String field) {
		String newField = "%"+field+"%";
		List<EmpresaTabelaDTO> EmpresaTabela = empresaRepository.findTabelaEmpresa(newField);
		for(EmpresaTabelaDTO empresaTabela: EmpresaTabela) {
			if(empresaTabela.getNRCNPJ() != null && empresaTabela.getNRCNPJ().length() >= 11) {
				empresaTabela.setNRCNPJ(MaskUtils.imprimeCNPJ(empresaTabela.getNRCNPJ()));
			}
		}
		return EmpresaTabela;
	}



	@Override
	public List<EmpresaEntity> findByNmempresa(String nmempresa) {
		return empresaRepository.findByNmempresa(nmempresa);
	}

	@Override
	public List<EmpresaEntity> findByNrcnpj(String nrCNPJ) {
		return empresaRepository.findByNrCNPJ(nrCNPJ);
	}


	@Override
	protected EmpresaEntity validateEntity(EmpresaEntity obj) throws Exception {
		return obj;
	}
	
	
		
		
}
