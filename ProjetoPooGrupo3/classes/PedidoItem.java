package classes;

import java.util.Scanner;

import conexao.Conexao;
import lista.ListaProdEmpr;
import lista.ListaPedido;

	public class PedidoItem {
	private int idpedidoitem;
	private double qtd;
	private int idpedido;
	private int idprodempr;

	public static PedidoItem cadastrar(Conexao con, String schema) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		PedidoItem pdi = new PedidoItem();
		
		ListaPedido listaPedidos = new ListaPedido(con,schema);
		ListaProdEmpr listaProdEmpr = new ListaProdEmpr(con,schema);
		
		listaPedidos.imprimirPedidos();
		System.out.println("Insira o Id Pedido: ");
		pdi.setIdpedido(input.nextInt());
		System.out.println();
		
		listaProdEmpr.imprimirProdEmpr();
		System.out.println("Insira o Id Produto-Empresa: ");
		pdi.setIdprodempr(input.nextInt());
		System.out.println();
			
		System.out.println("Insira a quantidade: ");
		pdi.setQtd(input.nextDouble());
		
		return pdi;
	}
	
	public static PedidoItem alterar(Conexao con, String schema, PedidoItem pi) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		ListaPedido listaPedidos = new ListaPedido(con,schema);
		ListaProdEmpr listaProdEmpr = new ListaProdEmpr(con,schema);
		
		listaPedidos.imprimirPedidos();
		System.out.println("Insira o novo ID pedido: ");
		pi.setIdpedido(input.nextInt());
		System.out.println();
		
		listaProdEmpr.imprimirProdEmpr();
		System.out.println("Insira o Id Produto-Empresa: ");
		pi.setIdprodempr(input.nextInt());
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

	public int getIdprodempr() {
		return idprodempr;
	}

	public void setIdprodempr(int idprodempr) {
		this.idprodempr = idprodempr;
	}

	
}