package classes;

import java.util.Scanner;

import conexao.Conexao;
import lista.ListaEmpresa;
import lista.ListaProduto;

public class ProdEmpr {
	private int idprodempr;
	private double vl_un;
	private int idproduto;
	private int idempresa;
	
	public static ProdEmpr cadastrar(Conexao con, String schema) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		ProdEmpr pdi = new ProdEmpr();
		
		ListaProduto listaProdutos = new ListaProduto(con,schema);
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,schema);
		
		listaEmpresa.imprimirEmpresas();
		System.out.println("Insira o Id Empresa: ");
		pdi.setIdempresa(input.nextInt());
		System.out.println();
		
		listaProdutos.imprimirProdutos();
		System.out.println("Insira o Id Produto: ");
		pdi.setIdproduto(input.nextInt());
		System.out.println();
		
		System.out.println("Insira o Valor unitário do Produto: ");
		pdi.setVl_un(input.nextDouble());
		
		return pdi;
	}
	
	public static ProdEmpr alterar(Conexao con, String schema, ProdEmpr pi) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		ListaProduto listaProdutos = new ListaProduto(con,schema);
		ListaEmpresa listaEmpresa = new ListaEmpresa(con,schema);
		
		listaProdutos.imprimirProdutos();
		System.out.println("Insira o novo ID produto: ");
		pi.setIdproduto(input.nextInt());
		System.out.println();
		
		listaEmpresa.imprimirEmpresas();
		System.out.println("Insira o novo ID empresa: ");
		pi.setIdempresa(input.nextInt());
		System.out.println();
		
		System.out.println("Insira o Valor unitário do Produto: ");
		pi.setVl_un(input.nextDouble());
		
		return pi;
	}
	
	public int getIdprodempr() {
		return idprodempr;
	}
	public void setIdprodempr(int idprodempr) {
		this.idprodempr = idprodempr;
	}
	public double getVl_un() {
		return vl_un;
	}
	public void setVl_un(double vl_un) {
		this.vl_un = vl_un;
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