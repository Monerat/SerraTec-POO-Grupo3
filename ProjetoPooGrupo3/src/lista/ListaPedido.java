package lista;

import java.util.ArrayList;

import classes.Pedido;
import conexao.Conexao;

public class ListaPedido {
	private Conexao con;
	private String schema;
	
	ArrayList<Pedido> pedidos = new ArrayList<>();
}
