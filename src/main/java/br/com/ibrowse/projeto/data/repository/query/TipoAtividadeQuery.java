package br.com.ibrowse.projeto.data.repository.query;

public class TipoAtividadeQuery {
	public static final String FIND_TABELA_Example = 
    		" SELECT u"+
    		" FROM TipoAtividadeEntity u "+
    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";

public static final String FIND_TABELA_TipoAtividade = 
		" SELECT new br.com.ibrowse.projeto.dto.TipoAtividadeTabelaDTO("
		+ " u.nmtipoAtividade, u.vrAtividade"+
		" ) " +
		" FROM TipoAtividadeEntity u "+
		"WHERE (upper(u.nmtipoAtividade) LIKE upper(:field))";

}
