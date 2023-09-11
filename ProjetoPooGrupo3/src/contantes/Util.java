package contantes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
	public static Scanner in = new Scanner(System.in);
	public static final String CABECALHO = 	"--------------Amazonia------------";
	public static final String MENU = 		"----------------Menu--------------";
	public static final String LINHA = 		"----------------------------------";
	public static final String LINHAD = 	"==================================";
	public static final String LINHAB = 	"__________________________________";
	public static final String MENUCADASTRO = "------------Cadastro------------";
	public static final String MENUALTERACAO = "------------Alteração-----------";
	public static final String MENUEXCLUIR = "------------Excluir-------------";
	public static final String MENUIMPRIMIR = "------------Imprimir------------";
	public static final String MENUCLIENTE = "------------Cliente-------------";
	public static final String MENUPRODUTO = "------------Produto-------------";
	public static final String MENUPEDIDO = "------------Pedido--------------";
	public static final String MENUPEDIDOITEM = "------------Pedido Item---------";
	public static final String MENUEMPRESA = "------------Empresa------------";
	public static final String MENUFINAL = "------Programa Finalizado------";

	public enum CRUD {
		CADASTRAR,
		ALTERAR,
		EXCLUIR,
		IMPRIMIR
	}
	
	public static void br() {
		System.out.println("");
	}
	
	public static void escrever(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static LocalDate validarData(String mensagem) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate dataConvertida = null;
		String sData; 
		boolean dataValidada = false;
		
		do {
			System.out.println(mensagem);
			sData = in.nextLine();		
			
			try {
				dataConvertida = LocalDate.parse(sData, dtf);   
				dataValidada = true;
				return dataConvertida;
			} catch (Exception e) {
				System.out.println("Data inválida");	
				return null;
			}
		} while (!dataValidada);
	}
	
 	public static int validarInteiro(String mensagem) {
		int numero = 0;
		boolean validado = false;		
		
		do {
			try {
				System.out.println(mensagem);
				String s = in.nextLine();
				numero = Integer.parseInt(s);
				validado = true;
			} catch (Exception e) {
				System.out.println("Informe um número válido - " + e.getMessage());
			}
		} while (!validado);
		
		//in.close();
		
		return numero;
	}
	
	public static double validarDouble() {
		String s;
		double numero = 0.0;
		boolean validado = false;
		Scanner in = new Scanner(System.in);
		
		do {
			try {
				s = in.next();			
				numero = Double.parseDouble(s);
				validado = true;
			} catch (Exception e) {
				System.out.println("Informe um número válido - " + e.getMessage());
			}
		} while (!validado);
		
		in.close();
		
		return numero;
	}
}
