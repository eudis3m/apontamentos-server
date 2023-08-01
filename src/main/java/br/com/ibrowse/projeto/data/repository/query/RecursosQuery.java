package br.com.ibrowse.projeto.data.repository.query;

public class RecursosQuery {
	public static final String FIND_TABELA_Example = 
    		" SELECT u"+
    		" FROM RecursosEntity u  "+
    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";

public static final String FIND_TABELA_Recursos = 
		" SELECT new br.com.ibrowse.projeto.dto.RecursosTabelaDTO("
		+ " u.nmrecursos"+
		" ) " +
		" FROM RecursosEntity u "+
		"WHERE (upper(u.nmrecursos) LIKE upper(:field))";

}
