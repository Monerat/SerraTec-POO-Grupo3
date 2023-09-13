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
		
		System.out.println("Insira o nome Produto: ");
		p.setNome_prod(input.nextLine());
		System.out.println("Insira o nome Descrição do Produto: ");
		p.setDescricao(input.nextLine());
		Util.validarDouble("Insira o Valor unitário: ");
		//System.out.println("Insira o Valor unitário: ");
		//p.setVl_un(input.nextDouble());
		
		return p;
			
	}
	
	public static Produto alterar(Produto prod) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira o nome Produto: ");
		prod.setNome_prod(input.nextLine());
		System.out.println("Insira o nome Descrição do Produto: ");
		prod.setDescricao(input.nextLine());
		System.out.println("Insira o Valor unitário: ");
		prod.setVl_un(input.nextDouble());
		
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
