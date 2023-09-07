package dml;

import classes.Pedido;
import conexao.Conexao;
import dao.PedidoDAO;

public class PedidoDML {
	public static void gravarProduto(Conexao con, String schema, Pedido pe) {
		PedidoDAO cdao = new PedidoDAO(con, schema);
		
		cdao.incluirPedido(pe);
	}
	
	public static void alterarProduto(Conexao con, String schema, Pedido pe) {
		PedidoDAO cdao = new PedidoDAO(con, schema);
		
		cdao.alterarPedido(pe);
	}
	
	public static void excluirProduto(Conexao con, String schema, Pedido pe) {
		PedidoDAO cdao = new PedidoDAO(con, schema);
		
		cdao.excluirPedido(pe);
	}
}
