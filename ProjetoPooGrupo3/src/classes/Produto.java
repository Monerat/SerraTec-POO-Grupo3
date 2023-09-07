package classes;

import java.util.Scanner;

public class Produto {
	private int idproduto;
	private String nome_prod;
	private String descricao;
	private double vl_un;
	
	public static Produto cadastra() {
		Scanner input = new Scanner(System.in);
		Produto p = new Produto();
		
		System.out.println("Insira o nome Produto: ");
		p.setNome_prod(input.nextLine());
		System.out.println("Insira o nome Descrição do Produto: ");
		p.setDescricao(input.nextLine());
		System.out.println("Insira o Valor unitário: ");
		p.setVl_un(input.nextDouble());
		
		return p;
			
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
