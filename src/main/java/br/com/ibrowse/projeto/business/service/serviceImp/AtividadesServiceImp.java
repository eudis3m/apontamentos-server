package br.com.ibrowse.projeto.business.service.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.ibrowse.projeto.business.service.ApontamentosService;
import br.com.ibrowse.projeto.business.service.AtividadesService;
import br.com.ibrowse.projeto.data.repository.AtividadesRepository;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.AtividadesTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.AtividadesEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;


@Service
public class AtividadesServiceImp extends BaseAbstractServiceAPIImpl<AtividadesEntity>  implements AtividadesService{

@Autowired
private AtividadesRepository atividadesRepository;
	
@Override
public Page<AtividadesEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
	String newField = "%"+nmusuario+"%";
	return atividadesRepository.findByExample(nmusuario, pageRequest);
}

@Override
public List<AtividadesTabelaDTO> findTabelaAtividades(Date field) {
	List<AtividadesTabelaDTO> AtividadesTabelaDTO = atividadesRepository.findTabelaAtividades(field);
	/*for(ApontamentosTabelaDTO apontamentosTabela: ApontamentosTabela) {
		if(apontamentosTabela.getDTApontamento() != null ) {
			apontamentosTabela.setNRCNPJ(MaskUtils.imprimeCNPJ(empresaTabela.getNRCNPJ()));
		}
	}*/
	return AtividadesTabelaDTO;
}

@Override
protected AtividadesEntity validateEntity(AtividadesEntity obj) throws Exception {
	return obj;
}

@Override
public List<AtividadesEntity> findByNmrecursos(String nmRecursos , String nmProjetos) {
	return atividadesRepository.findByNmRecursosAndNmProjetos(nmRecursos , nmProjetos);
}

@Override
public List<AtividadesEntity> findByNmProjetos(String nmProjetos) {
	return atividadesRepository.findByNmProjetos(nmProjetos);
}



}
