package br.com.ibrowse.projeto.data.repository.query;

public class ApontamentosQuery {
 public static final String FIND_TABELA_Example = 
	    		" SELECT u"+
	    		" FROM ApontamentosEntity u "+
	    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";
 
 public static final String FIND_TABELA_Apontamentos = 
 		" SELECT new br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO("
 		+ " u.nrApontamento, u.dtLancamento, u.dtapontamento, u.vratividade, u.nmRecursos, u.nmProjetos"+
 		" ) " +
 		" FROM ApontamentosEntity u ";
 		//"WHERE (db_projetos_ib.remove_acento(upper(u.oid)) LIKE db_projetos_ib.remove_acento(upper(:field)))";
 public static final String FIND_Recursos = 
		 " SELECT u "+
		 " FROM ApontamentosEntity u  "+
		 "WHERE ( upper(u.nmRecursos) LIKE upper(:nmRecursos) "
		 + " AND upper(u.nmusuario) LIKE upper(:nmusuario) "
		 + " AND upper(u.nmProjetos) LIKE upper(:nmProjetos) ) ";
}
