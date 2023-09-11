package lista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;
import classes.Pedido;
import conexao.Conexao;
import dao.PedidoDAO;

public class ListaPedidos {
	private Conexao con;
	private String schema;
	
	ArrayList<Pedido> pedidos = new ArrayList<>();
	
	
	public ListaPedidos (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaPedidos();
	}
	
	public void adicionarPedidoLista(Pedido p) {
		this.pedidos.add(p);
	}
	
	public Pedido localizarPedido(int idPedido) {
		Pedido localizado = null;
		
		for (Pedido p : pedidos) {
			if (p.getIdpedido()== idPedido) {
				localizado = p;
				break;
			}
		}
		return localizado;
	}
	
	private void carregarListaPedidos() {
		PedidoDAO pdao = new PedidoDAO(con, schema);
		
		ResultSet tabela = pdao.carregarPedidos();
		this.pedidos.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.pedidos.add(dadosPedido(tabela));				
			}
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Pedido dadosPedido(ResultSet tabela) {
		Pedido p = new Pedido();
		
		try {
			p.setIdpedido(tabela.getInt("idpedido"));
			p.setIdcliente(tabela.getInt("idcliente"));
			p.setData_ped(LocalDate.parse("data_ped"));
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}