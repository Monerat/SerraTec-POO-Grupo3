package principal;

import lista.*;
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
			
			int continuar;
			
			do{
				continuar = opcoes(menu());
			}while(continuar == 1);
			
			System.out.println(Util.MENUFINAL);
			
		} else {
			System.out.println("Ocorreu um problema na criação do banco de dados");
		}
		
	}
	
	public static int  menu() {	
		System.out.println(Util.LINHAD);
		System.out.println(Util.CABECALHO);
		System.out.println(Util.MENU);
		System.out.println(Util.LINHAD);
		System.out.println("""
				
				1) Empresa(CRUD)
				2) Produto(CRUD)
				3) Produto-Empresa(CRUD)
				4) Cliente(CRUD)
				5) Pedido(CRUD)
				6) Itens do Pedido(CRUD)
				7) Querys(Relatórios)
				8) Sair
				""");
		System.out.println(Util.LINHAD);
		return Util.validarInteiro("Informe uma opção:");
		
		}

	
	public static int subMenu(int opcao) {
		System.out.println(Util.LINHAD);
		System.out.println(Util.CABECALHO);
		System.out.println(Util.MENU);
		System.out.println(Util.LINHAD);
		System.out.println("""
					
					1) Cadastrar
					2) Alterar
					3) Excluir
					4) Listar
					""");
		System.out.println(Util.LINHAD);
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static int subMenuQuery() {
		System.out.println(Util.LINHAD);
		System.out.println(Util.CABECALHO);
		System.out.println(Util.MENU);
		System.out.println(Util.LINHAD);
		System.out.println("""
				
				1) Deve permitir selecionar um cliente por código e mostrar todos os pedidos que possui.
				2) Deve permitir selecionar um produto por código e mostrar todos os pedidos que possui.
				3) Deve permitir selecionar um pedido por código e mostrar o seu cliente e todos os produtos que possui.
				""");
		System.out.println(Util.LINHAD);
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static void opcaoCrudCliente(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarCliente();
			break;
		case 2:
			alterarCliente();
			break;
		case 3:
			excluirCliente();
			break;
		case 4:
			listarCliente();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}

	public static void opcaoCrudEmpresa(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarEmpresa();
			break;
		case 2:
			alterarEmpresa();
			break;
		case 3:
			excluirEmpresa();
			break;
		case 4:
			listarEmpresa();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static void opcaoCrudProduto(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarProduto();
			break;
		case 2:
			alterarProduto();
			break;
		case 3:
			excluirProduto();
			break;
		case 4:
			listarProduto();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static void opcaoCrudPedido(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarPedido();
			System.out.println("Selecione o código referente a data do pedido acima para incluir os produtos: ");
			cadastrarPedidoItem();
			break;
		case 2:
			alterarPedido();
			break;
		case 3:
			excluirPedido();
			break;
		case 4:
			listarPedido();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static void opcaoCrudPedidoItem(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarPedidoItem();
			break;
		case 2:
			alterarPedidoItem();
			break;
		case 3:
			excluirPedidoItem();
			break;
		case 4:
			listarPedidoItem();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static void opcaoCrudProdEmpr(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarProdEmpr();
			break;
		case 2:
			alterarProdEmpr();
			break;
		case 3:
			excluirProdEmpr();
			break;
		case 4:
			listarProdEmpr();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static void opcaoQuery(int opcao) {
		switch (opcao) {
		case 1:
			queryTodosPedCliente();
			break;
		case 2:
			queryTodosPedProd();
			break;
		case 3:
			queryPedClienteProdutos();
			break;
		default:
			System.out.println("Opção inválidada");
			break;
		}
	}
	
	public static int opcoes(int opcao) {
		
			switch (opcao) {
			case 1:
				opcaoCrudEmpresa(subMenu(opcao));
				break;
			case 2:
				opcaoCrudProduto(subMenu(opcao));
				break;
			case 3:
				opcaoCrudProdEmpr(subMenu(opcao));
				break;
			case 4:
				opcaoCrudCliente(subMenu(opcao));
				break;
			case 5:
				opcaoCrudPedido(subMenu(opcao));
				break;
			case 6:
				opcaoCrudPedidoItem(subMenu(opcao));
				break;
			case 7:
				opcaoQuery(subMenuQuery());
				break;
			case 8:
				System.out.println(Util.MENUFINAL);
				break;
			default:
				System.out.println("Opção inválidada");
				break;
			}
		return Util.validarInteiro("\nDeseja voltar ao menu inicial? \n1) Voltar \n2) Sair");
	}
	
	public static void cadastrarCliente() {
		ClienteDML.gravarCliente(con, SCHEMA, Cliente.cadastrar());
	}
	
	public static void cadastrarEmpresa() {
		EmpresaDML.gravarEmpresa(con, SCHEMA, Empresa.cadastrar());
	}
	
	public static void cadastrarPedido() {
		PedidoDML.gravarPedido(con, SCHEMA, Pedido.cadastrar(con,SCHEMA));
	}
	
	public static void cadastrarPedidoItem() {
		PedidoItemDML.gravarPedidoItem(con, SCHEMA, PedidoItem.cadastrar(con,SCHEMA));

	}
	
	public static void cadastrarProduto() {
		ProdutoDML.gravarProduto(con, SCHEMA, Produto.cadastrar());
	}
	
	public static void cadastrarProdEmpr() {
		ProdEmprDML.gravarProdEmpr(con, SCHEMA, ProdEmpr.cadastrar(con,SCHEMA));
	}
	
	public static void alterarCliente() {
		ListaCliente listaCliente = new ListaCliente(con,SCHEMA);
		listaCliente.imprimirClientes();
		ClienteDML.alterarCliente(con, SCHEMA, Cliente.alterar(listaCliente.localizarCliente(Util.validarInteiro("Informe o Id do Cliente que deseja alterar:"))));
	}
	
	public static void alterarEmpresa() {
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,SCHEMA);
		listaEmpresa.imprimirEmpresas();
		EmpresaDML.alterarEmpresa(con, SCHEMA, Empresa.alterar(listaEmpresa.localizarEmpresa(Util.validarInteiro("Informe o Id da Empresa que deseja alterar:"))));
	}
	
	public static void alterarPedido() {
		ListaPedido listaPedido = new ListaPedido(con,SCHEMA);
		listaPedido.imprimirPedidos();
		PedidoDML.alterarPedido(con, SCHEMA, Pedido.alterar(con,SCHEMA,listaPedido.localizarPedido(Util.validarInteiro("Informe o Id da Pedido que deseja alterar:"))));
	}
	
	public static void alterarPedidoItem() {
		ListaPedidoItem listaPedidoItem = new ListaPedidoItem(con,SCHEMA);
		listaPedidoItem.imprimirPedidoItens();
		PedidoItemDML.alterarPedidoItem(con, SCHEMA, PedidoItem.alterar(con,SCHEMA,listaPedidoItem.localizarPedidoItem(Util.validarInteiro("Informe o Id do Pedido Item que deseja alterar:"))));
	}
	
	public static void alterarProduto() {
		ListaProduto listaProduto = new ListaProduto(con,SCHEMA);
		listaProduto.imprimirProdutos();
		ProdutoDML.alterarProduto(con, SCHEMA, Produto.alterar(listaProduto.localizarProduto(Util.validarInteiro("Informe o Id da Produto que deseja alterar:"))));
	}
	
	public static void alterarProdEmpr() {
		ListaProdEmpr listaProdEmpr = new ListaProdEmpr(con,SCHEMA);
		listaProdEmpr.imprimirProdEmpr();
		ProdEmprDML.alterarProdEmpr(con, SCHEMA, ProdEmpr.alterar(con,SCHEMA,listaProdEmpr.localizarProdEmpr(Util.validarInteiro("Informe o Id do Produto-Empresa que deseja alterar:"))));
	}
	
	public static void excluirCliente() {
		ListaCliente listaCliente = new ListaCliente(con,SCHEMA);
		listaCliente.imprimirClientes();
		ClienteDML.excluirCliente(con, SCHEMA, listaCliente.localizarCliente(Util.validarInteiro("Informe o Id do Cliente que deseja excluir:")));
		
	}
	
	public static void excluirEmpresa() {
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,SCHEMA);
		listaEmpresa.imprimirEmpresas();
		EmpresaDML.excluirEmpresa(con, SCHEMA, listaEmpresa.localizarEmpresa(Util.validarInteiro("Informe o Id da Empresa que deseja excluir:")));
	}
	
	public static void excluirPedido() {
		ListaPedido listaPedido = new ListaPedido(con,SCHEMA);
		listaPedido.imprimirPedidos();
		PedidoDML.excluirPedido(con, SCHEMA, listaPedido.localizarPedido(Util.validarInteiro("Informe o Id do Pedido que deseja excluir:")));
	}
	
	public static void excluirPedidoItem() {
		ListaPedidoItem listaPedidoItem = new ListaPedidoItem(con,SCHEMA);
		listaPedidoItem.imprimirPedidoItens();
		PedidoItemDML.excluirPedidoItem(con, SCHEMA, listaPedidoItem.localizarPedidoItem(Util.validarInteiro("Informe o Id do Pedido Item que deseja excluir:")));
	}
	
	public static void excluirProduto() {
		ListaProduto listaProduto = new ListaProduto(con,SCHEMA);
		listaProduto.imprimirProdutos();
		ProdutoDML.excluirProduto(con, SCHEMA, listaProduto.localizarProduto(Util.validarInteiro("Informe o Id do Produto que deseja excluir:")));
	}
	
	public static void excluirProdEmpr() {
		ListaProdEmpr listaProdEmpr = new ListaProdEmpr(con,SCHEMA);
		listaProdEmpr.imprimirProdEmpr();
		ProdEmprDML.excluirProdEmpr(con, SCHEMA, listaProdEmpr.localizarProdEmpr(Util.validarInteiro("Informe o Id do Produto-Empresa que deseja excluir:")));
	}
	
	public static void listarCliente() {
		ListaCliente listaCliente = new ListaCliente(con,SCHEMA);
		listaCliente.imprimirClientes();
	}
	
	public static void listarEmpresa() {
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,SCHEMA);
		listaEmpresa.imprimirEmpresas();		
	}
	
	public static void listarPedido() {
		ListaPedido listaPedido = new ListaPedido(con,SCHEMA);
		listaPedido.imprimirPedidos();
	}
	
	public static void listarPedidoItem() {
		ListaPedidoItem listaPedidoItem = new ListaPedidoItem(con,SCHEMA);
		listaPedidoItem.imprimirPedidoItens();		
	}
	
	public static void listarProduto() {
		ListaProduto listaProduto = new ListaProduto(con,SCHEMA);
		listaProduto.imprimirProdutos();
	}
	public static void listarProdEmpr() {
		ListaProdEmpr listaProdEmpr = new ListaProdEmpr(con,SCHEMA);
		listaProdEmpr.imprimirProdEmpr();
	}
	
	public static void queryTodosPedCliente() {
		QueryDML.querySelectCliente(con, SCHEMA, Cliente.select());
	}

	public static void queryTodosPedProd() {
		QueryDML.querySelectProduto(con, SCHEMA, Produto.select());
	}
	
	public static void queryPedClienteProdutos() {
		QueryDML.querySelectPedido(con, SCHEMA, Pedido.select());
	}
	
}