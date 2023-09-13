package classes;

import java.util.Scanner;

import conexao.Conexao;
import lista.ListaEmpresa;
import lista.ListaProduto;
import lista.ListaPedido;

	public class PedidoItem {
	private int idpedidoitem;
	private double qtd;
	private int idpedido;
	private int idproduto;
	private int idempresa;

	public static PedidoItem cadastrar(Conexao con, String schema) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		PedidoItem pdi = new PedidoItem();
		
		ListaPedido listaPedidos = new ListaPedido(con,schema);
		ListaProduto listaProdutos = new ListaProduto(con,schema);
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,schema);
		
		
		listaPedidos.imprimirPedidos();
		System.out.println("Insira o Id Pedido: ");
		pdi.setIdpedido(input.nextInt());
		System.out.println();
		
		listaEmpresa.imprimirEmpresas();
		System.out.println("Insira o Id Empresa: ");
		pdi.setIdempresa(input.nextInt());
		System.out.println();
		
		listaProdutos.imprimirProdutos();
		System.out.println("Insira o Id Produto: ");
		pdi.setIdproduto(input.nextInt());
		System.out.println();
		
		System.out.println("Insira a quantidade: ");
		pdi.setQtd(input.nextDouble());
		
		return pdi;
		
	}
	
	public static PedidoItem alterar(Conexao con, String schema, PedidoItem pi) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		ListaPedido listaPedidos = new ListaPedido(con,schema);
		ListaProduto listaProdutos = new ListaProduto(con,schema);
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,schema);
		
		listaPedidos.imprimirPedidos();
		System.out.println("Insira o novo ID pedido: ");
		pi.setIdpedido(input.nextInt());
		System.out.println();
		
		listaProdutos.imprimirProdutos();
		System.out.println("Insira o novo ID produto: ");
		pi.setIdproduto(input.nextInt());
		System.out.println();
		
		listaEmpresa.imprimirEmpresas();
		System.out.println("Insira o novo ID empresa: ");
		pi.setIdempresa(input.nextInt());
		System.out.println();
		
		System.out.println("Insira uma nova quantidade: ");
		pi.setQtd(input.nextDouble());
		
		return pi;
	}
	
	public int getIdpedidoitem() {
		return idpedidoitem;
	}

	public void setIdpedidoitem(int idpedidoitem) {
		this.idpedidoitem = idpedidoitem;
	}

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) {
		this.qtd = qtd;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	
}