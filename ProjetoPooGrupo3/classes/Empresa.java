package classes;

import java.util.Scanner;

public class Empresa {
	private int idempresa;
	private String nome_fantasia;
	private String razao_social;
	

	public static Empresa cadastrar() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Empresa e = new Empresa();
		
		System.out.println("Insira o Nome Fantasia: ");
		e.setNome_fantasia(input.nextLine());
		System.out.println("Insira a Razão Social: ");
		e.setRazao_social(input.nextLine());
		
		return e;		
	}
	
	public static Empresa alterar(Empresa empre) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira o Nome Fantasia: ");
		empre.setNome_fantasia(input.nextLine());
		System.out.println("Insira a Razão Social: ");
		empre.setRazao_social(input.nextLine());
		
		return empre;		
	}
	
	public int getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(int idEmpresa) {
		this.idempresa = idEmpresa;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
			
}