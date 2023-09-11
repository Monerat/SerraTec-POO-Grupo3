package classes;

import java.util.Scanner;

	public class PedidoItem {
	private int idpedidoitem;
	private double qtd;
	private int idpedido;
	private int idproduto;
	private int idempresa;

	public static PedidoItem cadastrar() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		PedidoItem pdi = new PedidoItem();
		
		System.out.println("Insira a quantidade: ");
		pdi.setQtd(input.nextDouble());
		
		return pdi;
		
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