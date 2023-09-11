package classes;

import java.time.LocalDate;
import java.util.Scanner;
import contantes.Util;

public class Pedido {
	private int idpedido;
	private LocalDate data_ped;
	private int idcliente;
	
	public static Pedido cadastrar() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Pedido pe = new Pedido();
		
		pe.setData_ped(Util.validarData("Insira a data do Pedido: "));
		System.out.println("Insira o código do Cliente: ");
		pe.setIdcliente(input.nextInt());
		
		return pe;
			
	}
	
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public LocalDate getData_ped() {
		return data_ped;
	}
	public void setData_ped(LocalDate data_ped) {
		this.data_ped = data_ped;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	
}
