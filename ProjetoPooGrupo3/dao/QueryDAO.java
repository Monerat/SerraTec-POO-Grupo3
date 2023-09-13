package dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import conexao.Conexao;

public class QueryDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pSelectCliente;
	PreparedStatement pSelectPedido;
	PreparedStatement pSelectProduto;
	
	
	public QueryDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlCliente();
		prepararSqlPedido();
		prepararSqlProduto();
	}
	
	private void prepararSqlCliente() {
		String sql = "SELECT FROM "+ this.schema + ".cliente";
		sql += " WHERE idcliente = ?";
		
		try {
			this.pSelectCliente = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlPedido() {
		String sql = "SELECT FROM "+ this.schema + ".cliente";
		sql += " WHERE idpedido = ?";
		
		try {
			this.pSelectPedido = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlProduto() {
		String sql = "SELECT FROM "+ this.schema + ".cliente";
		sql += " WHERE idproduto = ?";
		
		try {
			this.pSelectProduto = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public int selectCliente(Cliente cliente) {
		try {
			pSelectCliente.setInt(1, cliente.getIdcliente());
			
			return pSelectCliente.executeUpdate();
			
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nCliente não encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	public int selectProduto(Produto produto) {
		try {
			pSelectProduto.setInt(1, produto.getIdproduto());
			
			return pSelectProduto.executeUpdate();
			
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nProduto não encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	public int selectPedido(Pedido pedido) {
		try {
			pSelectProduto.setInt(1, pedido.getIdpedido());
			
			return pSelectProduto.executeUpdate();
			
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nPedidonão encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	
}