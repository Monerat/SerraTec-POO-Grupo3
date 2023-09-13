package dml;

import classes.ProdEmpr;
import conexao.Conexao;
import dao.ProdemprDAO;

public class ProdemprDML {
	public static void gravarPedidoItem(Conexao con, String schema, ProdEmpr pdi) {
		ProdemprDAO cdao = new ProdemprDAO(con, schema);
		
		cdao.incluirProdEmpr(pdi);
	}
	
	public static void alterarPedidoItem(Conexao con, String schema, ProdEmpr pdi) {
		ProdemprDAO cdao = new ProdemprDAO(con, schema);
		
		cdao.alterarProdEmpr(pdi);
	}
	
	public static void excluirPedidoItem(Conexao con, String schema, ProdEmpr pdi) {
		ProdemprDAO cdao = new ProdemprDAO(con, schema);
		
		cdao.excluirProdEmpr(pdi);
	}
}
