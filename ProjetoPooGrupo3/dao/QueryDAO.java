package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import conexao.Conexao;
import contantes.Util;

public class QueryDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pSelectCliente;
	PreparedStatement pSelectPedido;
	PreparedStatement pSelectProduto;
	
	
	public QueryDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
	}	
	public void selectCliente(Cliente cliente) {
		ResultSet tabela;
		String sql = "SELECT c.nome, p.idpedido, p.data_ped FROM "+ this.schema + ".pedido pe";
		sql += " JOIN "+ this.schema + ".pedido p ON p.idpedido = pe.idpedido";
		sql += " JOIN "+ this.schema + ".cliente c ON c.idcliente = p.idcliente";
		sql += " WHERE p.idcliente = "+cliente.getIdcliente();
		
		try {
			tabela=conexao.query(sql);
			tabela.beforeFirst();
			
			while(tabela.next()) {
				System.out.println(tabela.getString("nome") +" "+ tabela.getString("idpedido") +" "+ Util.validaDataTransString(tabela.getDate("data_ped").toLocalDate()));
				
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
	
	public void selectProduto(Produto produto) {
		ResultSet tabela;
		String sql = "SELECT prd.idproduto, prd.nome_prod, p.idpedido FROM "+ this.schema + ".pedido p";
		sql += " JOIN "+ this.schema + ".pedido pd ON pd.idpedido = p.idpedido";
		sql += " JOIN "+ this.schema + ".produto prd ON prd.idproduto = prd.idproduto";
		sql += " JOIN "+ this.schema + ".prodempr pe ON pe.idproduto = prd.idproduto";
		sql += " WHERE prd.idproduto = " + produto.getIdproduto();
		
		try {
			tabela=conexao.query(sql);
			tabela.beforeFirst();
			
			while(tabela.next()) {
				System.out.println(tabela.getString("idproduto") +" "+ tabela.getString("nome_prod") +" "+ tabela.getString("idpedido"));
				
			}
			
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nProduto não encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
		}
	}
	
	public void selectPedido(Pedido pedido) {
		ResultSet tabela;
		String sql = "SELECT c.nome, pd.nome_prod, p.idpedido FROM "+ this.schema + ".pedido p";
		sql += " JOIN "+ this.schema + ".cliente c ON c.idcliente = p.idcliente";
		sql += " JOIN "+ this.schema + ".pedidoitem pi ON pi.idpedido = p.idpedido";
		sql += " JOIN "+ this.schema + ".prodempr pe ON pe.idprodempr = pi.idprodempr";
		sql += " JOIN "+ this.schema + ".produto pd ON pd.idproduto = pe.idproduto";
		sql += " JOIN "+ this.schema + ".empresa em ON em.idempresa = pe.idempresa";
		sql += " WHERE p.idpedido = " + pedido.getIdpedido();
		
		try {
			tabela=conexao.query(sql);
			tabela.beforeFirst();
			
			while(tabela.next()) {
				System.out.println(tabela.getString("nome") + " " + tabela.getString("nome_prod") + " " + tabela.getString("idpedido"));	
			}
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nPedido não encontrado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
		}
	}
}