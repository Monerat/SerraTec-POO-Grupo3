package classes;

import java.time.LocalDate;
import java.util.Scanner;
import conexao.Conexao;
import contantes.Util;
import lista.ListaCliente;

public class Pedido {
	private int idpedido;
	private LocalDate data_ped;
	private int idcliente;
	

	public static Pedido cadastrar(Conexao con, String schema) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Pedido pe = new Pedido();
		
		ListaCliente listaClientes = new ListaCliente(con,schema);
		
		pe.setData_ped(Util.validarData("Insira a data do Pedido: "));
		listaClientes.imprimirClientes();
		pe.setIdcliente(Util.validarInteiro("Insira o código do Cliente: "));
		
		return pe;
			
	}
	
	public static Pedido alterar(Conexao con, String schema, Pedido pe) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		ListaCliente listaClientes = new ListaCliente(con,schema);
		
		pe.setData_ped(Util.validarData("Insira a data do Pedido: "));
		listaClientes.imprimirClientes();
		pe.setIdcliente(Util.validarInteiro("Insira o código do Cliente: "));
		
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
