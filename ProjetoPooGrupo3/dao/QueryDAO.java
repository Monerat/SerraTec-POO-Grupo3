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
		String sql = "SELECT cli.nome, pe.idpedido, pe.data_ped, em.nome_fantasia, em.razao_social FROM "+ this.schema + ".cliente cli";
		sql += " LEFT JOIN "+ this.schema + ".pedido pe ON pe.idcliente = cli.idcliente";
		sql += " LEFT JOIN "+ this.schema + ".pedidoitem peit ON peit.idpedido = pe.idpedido";
		sql += " LEFT JOIN "+ this.schema + ".prodempr prem ON prem.idprodempr = peit.idprodempr";
		sql += " LEFT JOIN "+ this.schema + ".empresa em ON em.idempresa = prem.idempresa";
		sql += " WHERE cli.idcliente = "+cliente.getIdcliente();
		
		try {
			tabela=conexao.query(sql);
			tabela.beforeFirst();
			System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | \n","Nome do Cliente","Id Pedido","Data do Pedido","Empresa: Nome Fantasia","Empresa: Razão Social");
			for(int i = 0; i < 5; i++) {
				System.out.print(Util.LINHAD);
			}
			System.out.println();
			while(tabela.next()) {
				System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | ",tabela.getString("nome"),tabela.getString("idpedido"),Util.validaDataTransString(tabela.getDate("data_ped").toLocalDate()),tabela.getString("nome_fantasia"),tabela.getString("razao_social"));
				System.out.println();
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
		String sql = "SELECT pr.idproduto, pr.nome_prod, p.idpedido, em.nome_fantasia, em.razao_social FROM "+ this.schema + ".produto pr";
		sql += " LEFT JOIN "+ this.schema + ".prodempr pe ON pe.idproduto = pr.idproduto";
		sql += " LEFT JOIN "+ this.schema + ".empresa em ON em.idempresa = pe.idempresa";
		sql += " LEFT JOIN "+ this.schema + ".pedidoitem pi ON pi.idprodempr = pe.idprodempr";
		sql += " LEFT JOIN "+ this.schema + ".pedido p ON p.idpedido = pi.idpedido";
		sql += " WHERE pr.idproduto = " + produto.getIdproduto();
		
		try {
			tabela=conexao.query(sql);
			tabela.beforeFirst();
			System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | \n","Id Produto","Nome do Produto","Id Pedido","Empresa: Nome Fantasia","Empresa: Razão Social");
			for(int i = 0; i < 5; i++) {
				System.out.print(Util.LINHAD);
			}
			System.out.println();
			while(tabela.next()) {
				System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | ",tabela.getString("idproduto"),tabela.getString("nome_prod"),tabela.getString("idpedido"),tabela.getString("nome_fantasia"),tabela.getString("razao_social"));
				System.out.println();
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
		String sql = "SELECT c.nome, pd.nome_prod, p.idpedido, em.nome_fantasia, em.razao_social FROM "+ this.schema + ".pedido p";
		sql += " LEFT JOIN "+ this.schema + ".cliente c ON c.idcliente = p.idcliente";
		sql += " LEFT JOIN "+ this.schema + ".pedidoitem pi ON pi.idpedido = p.idpedido";
		sql += " LEFT JOIN "+ this.schema + ".prodempr pe ON pe.idprodempr = pi.idprodempr";
		sql += " LEFT JOIN "+ this.schema + ".produto pd ON pd.idproduto = pe.idproduto";
		sql += " LEFT JOIN "+ this.schema + ".empresa em ON em.idempresa = pe.idempresa";
		sql += " WHERE p.idpedido = " + pedido.getIdpedido();
		
		try {
			tabela=conexao.query(sql);
			tabela.beforeFirst();
			System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | \n","Nome do Cliente","Nome do Produto","Id Pedido","Empresa: Nome Fantasia","Empresa: Razão Social");
			for(int i = 0; i < 5; i++) {
				System.out.print(Util.LINHAD);
			}
			System.out.println();
			while(tabela.next()) {
				System.out.format("%-30s | %-30s | %-30s | %-30s | %-30s | ",tabela.getString("nome"),tabela.getString("nome_prod"),tabela.getString("idpedido"),tabela.getString("nome_fantasia"),tabela.getString("razao_social"));
				System.out.println();
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