package principal;


import classes.*;
import contantes.Util;
import dao.*;
import dml.*;
import conexao.*;


public class Principal {
	
	public static Conexao con;
	public static DadosConexao dadosCon = new DadosConexao();
	public static final String BANCO = "grupo3_poo";
	public static final String SCHEMA = "sistema";
	public static final String LOCAL = "localhost";
	public static final String USUARIO = "postgres";
	public static final String SENHA = "123456";
	public static final String PORTA = "5432";
	public static final String BD = "PostgreSql";
	
	
	public static void main(String[] args) {

		dadosCon.setBanco(BANCO);
		dadosCon.setLocal(LOCAL);
		dadosCon.setUser(USUARIO);
		dadosCon.setSenha(SENHA);
		dadosCon.setPorta(PORTA);
		dadosCon.setBd(BD);
		
		//Criar o database
		if (CreateDAO.createBD(BANCO, SCHEMA, dadosCon)) {
			con = new Conexao(dadosCon); 
			con.conect();
			opcoes(menu());
		} else {
			System.out.println("Ocorreu um problema na criação do banco de dados");
		}
		
	}
	
	public static int menu() {
		System.out.println(Util.LINHAD);
		System.out.println(Util.CABECALHO);
		System.out.println(Util.MENU);
		System.out.println(Util.LINHAD);
		System.out.println("""
				
				1) Cadastrar
				2) Alterar
				3) Excluir
				4) Listar
				5) Sair
				""");
		System.out.println(Util.LINHAD);
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static void opcoes(int opcao) {
		switch (opcao) {
		case 1:
			cadastrar();
			break;
		case 2:
			//alterar();
			break;
		case 3:
			//exclir();
			break;
		case 4:
			//listar();
			break;
		case 5:
			System.out.println("Sistema finalizado.");
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static void cadastrar() {
		//criar menu cadastrar
		ClienteDML.gravarCliente(con, SCHEMA, Cliente.cadastrar());
	}
	
	public static void alterar() {
		//criar menu alterar
	}
	
	public static void excluir() {
		//criar menu cadastrar
	}
	
	public static void listar() {
		//criar menu listar
	}
	
	public static void cadastrarCliente() {
		ClienteDML.gravarCliente(con, SCHEMA, Cliente.cadastrar());
	}
	
	public static void cadastrarEmpresa() {
		//criar o cadastro
	}
	
	public static void cadastrarPedido() {
		//criar o cadastro
	}
	
	public static void cadastrarPedidoItem() {
		//criar o cadastro
	}
	
	public static void cadastrarProduto() {
		//criar o cadastro
	}
	
	public static void alterarCliente() {
		//criar o Alterar o cadastro
	}
	
	public static void alterarEmpresa() {
		//criar o Alterar o cadastro
	}
	
	public static void alterarPedido() {
		//criar o Alterar o cadastro
	}
	
	public static void alterarPedidoItem() {
		//criar o Alterar o cadastro
	}
	
	public static void alterarProduto() {
		//criar o Alterar o cadastro
	}
	
	public static void excluirCliente() {
		//criar o excluir o cadastro
	}
	
	public static void excluirEmpresa() {
		//criar o excluir o cadastro
	}
	
	public static void excluirPedido() {
		//criar o excluir o cadastro
	}
	
	public static void excluirPedidoItem() {
		//criar o excluir o cadastro
	}
	
	public static void excluirProduto() {
		//criar o excluir o cadastro
	}
	
	public static void listarCliente() {
		//criar o listar de cada entidade
	}
	
	public static void listarEmpresa() {
		//criar o listar de cada entidade
	}
	
	public static void listarPedido() {
		//criar o listar de cada entidade
	}
	
	public static void listarPedidoItem() {
		//criar o listar de cada entidade
	}
	
	public static void listarProduto() {
		//criar o listar de cada entidade
	}
}
