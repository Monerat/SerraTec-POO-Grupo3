package classes;

import java.util.Scanner;

import contantes.Util;

public class Produto {
	private int idproduto;
	private String nome_prod;
	private String descricao;
	private double vl_un;
	
	public static Produto cadastrar() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Produto p = new Produto();
		
		p.setNome_prod(Util.validarString("Insira o nome Produto: "));
		p.setDescricao(Util.validarString("Insira a Descrição do Produto: "));
		p.setVl_un(Util.validarDouble("Insira o Valor unitário: "));
		
		return p;
			
	}
	
	public static Produto alterar(Produto prod) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		prod.setNome_prod(Util.validarString("Insira o nome Produto: "));
		prod.setDescricao(Util.validarString("Insira a Descrição do Produto: "));
		prod.setVl_un(Util.validarDouble("Insira o Valor unitário: "));
		
		return prod;
	}

	public int getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getVl_un() {
		return vl_un;
	}

	public void setVl_un(double vl_un) {
		this.vl_un = vl_un;
	}
	
}
