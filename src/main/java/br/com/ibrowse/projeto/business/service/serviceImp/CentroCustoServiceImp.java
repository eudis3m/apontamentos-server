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
import br.com.ibrowse.projeto.business.service.CentroCustoService;
import br.com.ibrowse.projeto.data.repository.CentrosCustosRepository;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.dto.CentroCustoTabelaDTO;
import br.com.ibrowse.projeto.entity.ApontamentosEntity;
import br.com.ibrowse.projeto.entity.CentroCustoEntity;
import br.com.ibrowse.projeto.exceptions.NotFoundException;
import br.com.ibrowse.projeto.util.MaskUtils;


@Service
public class CentroCustoServiceImp extends BaseAbstractServiceAPIImpl<CentroCustoEntity>  implements CentroCustoService{
	
@Autowired
private CentrosCustosRepository centrosCustosRepository;

@Override
public Page<CentroCustoEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
	String newField = "%"+nmusuario+"%";
	return centrosCustosRepository.findByExample(nmusuario, pageRequest);
}

@Override
public List<CentroCustoTabelaDTO> findTabelaCentroCusto(long field) {
	List<CentroCustoTabelaDTO> CentroCustoTabela = centrosCustosRepository.findTabelaCentroCusto(field);
	/*for(ApontamentosTabelaDTO apontamentosTabela: ApontamentosTabela) {
		if(apontamentosTabela.getDTapontamento() != null ) {
			apontamentosTabela.setNRCNPJ(MaskUtils.imprimeCNPJ(empresaTabela.getNRCNPJ()));
		}
	}*/
	return CentroCustoTabela;
}

@Override
protected CentroCustoEntity validateEntity(CentroCustoEntity obj) throws Exception {
	return obj;
}
}
