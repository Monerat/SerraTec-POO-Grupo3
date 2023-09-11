package lista;

import java.util.ArrayList;

import classes.PedidoItem;
import conexao.Conexao;

public class ListaPedidoItem {
	private Conexao con;
	private String schema;
	
	ArrayList<PedidoItem> pedidoItens = new ArrayList<>();
}
