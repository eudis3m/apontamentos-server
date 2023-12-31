package br.com.ibrowse.projeto.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class MaskUtils {

	public static boolean isCPF(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}

	public static String imprimeCNPJ(String CNPJ) {
		return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
	}
	
	public static String imprimeCodigoAcao(String codigoAcao) {
		return (codigoAcao.substring(0, 1) + "-" + codigoAcao.substring(1, 4));
	}

	public static String imprimeCodigoInicialDotacao(String codigoInicialDotacao) {
		return (
			codigoInicialDotacao.substring(0, 1) + "-" + 
			codigoInicialDotacao.substring(1, 3) + "-" + 
			codigoInicialDotacao.substring(3, 4) + "-" + 
			codigoInicialDotacao.substring(4, 6) + "-" +
			codigoInicialDotacao.substring(6, 9) + "-" +
			codigoInicialDotacao.substring(9, 12) + "-" +
			codigoInicialDotacao.substring(12, 13) + "-" +
			codigoInicialDotacao.substring(13, 16)
		);
	}
	
	public static String imprimeCodigoComplementarDotacao(String codigoComplementarDotacao) {
		return (
			codigoComplementarDotacao.substring(0, 4) + "-" + 
			codigoComplementarDotacao.substring(4, 5) + "-" + 
			codigoComplementarDotacao.substring(5, 6) + "-" + 
			codigoComplementarDotacao.substring(6, 8) + "-" +
			codigoComplementarDotacao.substring(8, 10) + "-" +
			codigoComplementarDotacao.substring(10, 12) + "-" +
			codigoComplementarDotacao.substring(12, 13) + "-" +
			codigoComplementarDotacao.substring(13, 15) + "-" +
			codigoComplementarDotacao.substring(15, 16)
		);
	}
	

	public static Date converteDate(Date field){
		 try{SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 String data = sdf.format(field);
		 Date dataI;
		 dataI = sdf.parse(data);
			return  dataI;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  null;
	
	}
	
}
