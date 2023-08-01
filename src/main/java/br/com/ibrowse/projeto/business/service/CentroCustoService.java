package br.com.ibrowse.projeto.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.ibrowse.projeto.dto.AtividadesTabelaDTO;
import br.com.ibrowse.projeto.dto.CentroCustoTabelaDTO;
import br.com.ibrowse.projeto.entity.AtividadesEntity;
import br.com.ibrowse.projeto.entity.CentroCustoEntity;



public interface CentroCustoService extends BaseServiceAPI<CentroCustoEntity>{
	
    public Page<CentroCustoEntity> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String nmusuario);
	
	public List<CentroCustoTabelaDTO> findTabelaCentroCusto(long field);

}
