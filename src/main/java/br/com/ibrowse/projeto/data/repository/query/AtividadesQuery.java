package br.com.ibrowse.projeto.data.repository.query;

public class AtividadesQuery {
	 public static final String FIND_TABELA_Example = 
	    		" SELECT u"+
	    		" FROM AtividadesEntity u "+
	    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";

public static final String FIND_TABELA_Atividades = 
		" SELECT new br.com.ibrowse.projeto.dto.AtividadesTabelaDTO("
		+ " u.dtInicio, u.dtFinal, u.nrhorasAtividade, u.nmRecursos, u.nmProjetos"+
		" ) " +
		" FROM AtividadesEntity u ";
		//"WHERE (db_projetos_ib.remove_acento(upper(u.dtInicio)) LIKE db_projetos_ib.remove_acento(upper(:field)))";
public static final String FIND_Recursos = 
" SELECT u"+
" FROM AtividadesEntity u "+
"WHERE ( upper(u.nmRecursos) LIKE upper(:nmRecursos))";
}
