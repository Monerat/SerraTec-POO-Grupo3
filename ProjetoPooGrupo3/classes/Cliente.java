package classes;

import java.util.Scanner;

public class Cliente extends Pessoa {
	private int idcliente;
	
	
	
	public static Cliente cadastrar() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Cliente c = new Cliente();
		
		System.out.println("Informe o nome do cliente: ");
		c.setNome(input.nextLine());
		
		return c;
	}
	
	
	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
}
