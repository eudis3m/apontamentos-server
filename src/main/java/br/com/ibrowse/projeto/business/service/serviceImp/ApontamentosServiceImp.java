package br.com.ibrowse.projeto.business.service.serviceImp;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.ApontamentosService;
import br.com.ibrowse.projeto.business.service.EmpresaService;
import br.com.ibrowse.projeto.data.repository.ApontamentosRepository;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.EmpresaTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.EmpresaEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;
import br.com.ibrowse.projeto.util.MaskUtils;


@Service
public class ApontamentosServiceImp extends BaseAbstractServiceAPIImpl<ApontamentosEntity>  implements ApontamentosService{
	
	@Autowired
 private ApontamentosRepository apontamentosRepository;

	@Override
	public Page<ApontamentosEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field,String nmusuario) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		String newField = "%"+nmusuario+"%";
		return apontamentosRepository.findByExample(nmusuario, pageRequest);
	}

	@Override
	public List<ApontamentosTabelaDTO> findTabelaApontamentos(int field) {
		//MaskUtils.converteDate(field);
		List<ApontamentosTabelaDTO> ApontamentosTabela = apontamentosRepository.findTabelaApontamentos(field);
		/*for(ApontamentosTabelaDTO apontamentosTabela: ApontamentosTabela) {
			if(apontamentosTabela.getDTapontamento() != null ) {
				apontamentosTabela.setDTapontamento(MaskUtils.converteDate(apontamentosTabela.getDTapontamento()));
			}
		}*/
		return ApontamentosTabela;

	}


	@Override
	protected ApontamentosEntity validateEntity(ApontamentosEntity obj) throws Exception {
		return obj;
	}

	@Override
	public List<ApontamentosEntity> findByNmRecursos(String nmRecursos, String nmusuario , String nmProjetos) {
		return apontamentosRepository.findByNmRecursosAndNmusuarioAndNmProjetos(nmRecursos, nmusuario , nmProjetos);
	}

	
	
	
}
