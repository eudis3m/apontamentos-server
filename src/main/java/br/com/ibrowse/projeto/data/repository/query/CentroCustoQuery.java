package br.com.ibrowse.projeto.data.repository.query;

public class CentroCustoQuery {
	 public static final String FIND_TABELA_Example = 
	    		" SELECT u"+
	    		" FROM CentroCustoEntity u  "+
	    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";

public static final String FIND_TABELA_CentroCusto = 
		" SELECT new br.com.ibrowse.projeto.dto.CentroCustoTabelaDTO("
		+ " u.vrcustoPrevisto, u.vrcustoAprovado, u.dscentroCusto, u.nmprojeto"+
		" ) " +
		" FROM CentroCustoEntity u ";
		//"WHERE (db_projetos_ib.remove_acento(upper(u.vrCustoPrevisto)) LIKE db_projetos_ib.remove_acento(upper(:field)))";
}
