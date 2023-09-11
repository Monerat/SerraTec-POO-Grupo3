package lista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.PedidoItem;
import conexao.Conexao;
import dao.PedidoItemDAO;

public class ListaPedidoItem {
	private Conexao con;
	private String schema;
	
	ArrayList<PedidoItem> pedidoItens = new ArrayList<>();
	
	public ListaPedidoItem (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaPedidoItem();
	}
	
	public void adicionarPedidoItemLista(PedidoItem pdi) {
		this.pedidoItens.add(pdi);
	}
	
	public PedidoItem localizarPedidoItem(int Idpedidoitem) {
		PedidoItem localizado = null;
		
		for (PedidoItem pdi : pedidoItens) {
			if (pdi.getIdpedidoitem() == Idpedidoitem) {
				localizado = pdi;
				break;
			}
		}
		return localizado;
	}
	
	private void carregarListaPedidoItem() {
		PedidoItemDAO cdao = new PedidoItemDAO(con, schema);
		
		ResultSet tabela = cdao.carregarPedidoItem();
		this.pedidoItens.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.pedidoItens.add(dadosPedidoItem(tabela));				
			}
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private PedidoItem dadosPedidoItem(ResultSet tabela) {
		PedidoItem pdi = new PedidoItem();
		
		try {
			pdi.setQtd(tabela.getDouble("Quantidade"));
			pdi.setIdpedidoitem(tabela.getInt("idpedidoitem"));
			pdi.setIdproduto(tabela.getInt("idproduto"));
			pdi.setIdpedido(tabela.getInt("idpedido"));
			pdi.setIdempresa(tabela.getInt("idempresa"));
			return pdi;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
