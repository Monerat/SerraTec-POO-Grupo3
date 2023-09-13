package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	private void prepararSqlPedido() {
		String sql = "SELECT c.nome, pd.nome_prod, p.idpedido FROM "+ this.schema + ".pedido p";
		sql += " JOIN "+ this.schema + ".cliente c ON c.idcliente = p.idcliente";
		sql += " JOIN "+ this.schema + ".pedidoitem pi ON pi.idpedido = p.idpedido";
		sql += " JOIN "+ this.schema + ".prodempr pe ON pe.idprodempr = pi.idprodempr";
		sql += " JOIN "+ this.schema + ".produto pd ON pd.idproduto = pe.idproduto";
		sql += " JOIN "+ this.schema + ".empresa em ON em.idempresa = pe.idempresa";
		sql += " WHERE p.idpedido = ?";
		
		try {
			this.pSelectPedido = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlCliente() {
		String sql = "SELECT c.nome, p.idpedido, p.data_ped FROM "+ this.schema + ".pedido pe";
		sql += " JOIN "+ this.schema + ".pedido p ON p.idpedido = pe.idpedido";
		sql += " JOIN "+ this.schema + ".cliente c ON c.idcliente = p.idcliente";
		sql += " WHERE p.idcliente = ?";
		try {
			this.pSelectCliente = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlProduto() {
		String sql = "SELECT prd.idproduto, prd.nome_prod, p.idpedido FROM "+ this.schema + ".produto pr";
		sql += " JOIN "+ this.schema + ".produto prd on prd.idproduto = pr.idproduto";
		sql += " JOIN "+ this.schema + ".prodempr pe on pe.idproduto = prd.idproduto";
		sql += " JOIN "+ this.schema + ".pedidoitem pi on pr.idproduto = prd.idproduto";
		sql += " JOIN "+ this.schema + ".pedido p on p.idpedido = pi.idpedido";
		sql += " WHERE prd.idproduto = ?";
		try {
			this.pSelectProduto = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void selectCliente(Cliente cliente) {
		ResultSet tabela;
		try {
			pSelectCliente.setInt(1, cliente.getIdcliente());
			
			tabela=pSelectCliente.executeQuery();
			tabela.beforeFirst();
			
			while(tabela.next()) {
				System.out.println(tabela.getString("nome"));
			}
			
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nCliente não encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
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
				System.err.println("\nPedido não encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	
}