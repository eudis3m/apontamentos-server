package br.com.ibrowse.projeto.data.repository.query;

public class ProjetosQuery {
	public static final String FIND_TABELA_Example = 
    		" SELECT u"+
    		" FROM ProjetosEntity u  "+
    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";

public static final String FIND_TABELA_Projetos = 
		" SELECT new br.com.ibrowse.projeto.dto.ProjetosTabelaDTO("
		+ " u.nmprojeto, u.dtprojetoinicio, u.dtProjetoFinal, u.dsDescricaoProjeto , u.nmEmpresa, u.vrcustoAprovado"+
		" ) " +
		" FROM ProjetosEntity u "+
		"WHERE (upper(u.nmprojeto) LIKE upper(:field))";
}
