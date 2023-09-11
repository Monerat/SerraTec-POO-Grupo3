package lista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import classes.Cliente;
import conexao.Conexao;
import dao.ClienteDAO;

public class ListaClientes {
	private Conexao con;
	private String schema;
	
	ArrayList<Cliente> clientes = new ArrayList<>();
	
	public ListaClientes (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaClientes();
	}
	
	public void adicionarClienteLista(Cliente c) {
		this.clientes.add(c);
	}
	
	public Cliente localizarCliente(int idCliente) {
		Cliente localizado = null;
		
		for (Cliente c : clientes) {
			if (c.getIdcliente() == idCliente) {
				localizado = c;
				break;
			}
		}		
	
		return localizado;
	}
	
	private void carregarListaClientes() {
		ClienteDAO cdao = new ClienteDAO(con, schema);
		
		ResultSet tabela = cdao.carregarClientes();
		this.clientes.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.clientes.add(dadosCliente(tabela));				
			}
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Cliente dadosCliente(ResultSet tabela) {
		Cliente c = new Cliente();
		
		try {
			c.setNome(tabela.getString("nome"));
			c.setIdcliente(tabela.getInt("idcliente"));
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
