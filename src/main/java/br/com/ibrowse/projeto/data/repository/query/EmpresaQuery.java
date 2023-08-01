package br.com.ibrowse.projeto.data.repository.query;

public class EmpresaQuery {
	 public static final String FIND_TABELA_Example = 
	    		" SELECT u "+
	    		" FROM EmpresaEntity u "+
	    		"WHERE (upper(u.nmusuario) LIKE upper(:nmusuario))";
    
    public static final String FIND_TABELA_Empresa = 
    		" SELECT new br.com.ibrowse.projeto.dto.EmpresaTabelaDTO("
    		+ " u.nmempresa, u.nrCNPJ, u.nrTelefone, u.dsrua, "
    		+ "u.dsbairro , u.dscidade, u.dsnumero, u.dscomplemento "+
    		" ) " +
    		" FROM EmpresaEntity u "+
    		"WHERE (upper(u.nmempresa) LIKE  upper(:field))";
}

