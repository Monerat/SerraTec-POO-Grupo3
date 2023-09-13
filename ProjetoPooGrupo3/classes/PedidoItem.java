package classes;

import java.util.Scanner;

import conexao.Conexao;
import contantes.Util;
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
		pdi.setIdpedido(Util.validarInteiro("Insira o Id Pedido: "));
		System.out.println();
		
		listaEmpresa.imprimirEmpresas();
		pdi.setIdempresa(Util.validarInteiro("Insira o Id Empresa: "));
		System.out.println();
		
		listaProdutos.imprimirProdutos();
		pdi.setIdproduto(Util.validarInteiro("Insira o Id Produto: "));
		System.out.println();
		
		pdi.setQtd(Util.validarDouble("Insira a quantidade: "));
		
		return pdi;
		
	}
	
	public static PedidoItem alterar(Conexao con, String schema, PedidoItem pi) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		ListaPedido listaPedidos = new ListaPedido(con,schema);
		ListaProduto listaProdutos = new ListaProduto(con,schema);
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,schema);
		
		listaPedidos.imprimirPedidos();
		pi.setIdpedido(Util.validarInteiro("Insira o novo ID pedido: "));
		System.out.println();
		
		listaProdutos.imprimirProdutos();
		pi.setIdproduto(Util.validarInteiro("Insira o novo ID produto: "));
		System.out.println();
		
		listaEmpresa.imprimirEmpresas();
		pi.setIdempresa(Util.validarInteiro("Insira o novo ID empresa: "));
		System.out.println();
		
		pi.setQtd(Util.validarDouble("Insira uma nova quantidade: "));
		
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