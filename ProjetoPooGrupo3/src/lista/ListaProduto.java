package lista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Produto;
import conexao.Conexao;
import dao.ProdutoDAO;

public class ListaProduto {
	private Conexao con;
	private String schema;
	
	ArrayList<Produto> produto = new ArrayList<>();
	
	public ListaProduto (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaProdutos();
	}
	
	public void adicionarProdutoLista(Produto p) {
		this.produto.add(p);
	}
	
	public Produto localizarProdutos(int idProduto) {
		Produto localizado = null;
		
		for (Produto p : produto) {
			if (p.getIdproduto() == idProduto) {
				localizado = p;
				break;
			}
		}
		return localizado;
	}
	
	private void carregarListaProdutos() {
		ProdutoDAO cdao = new ProdutoDAO(con, schema);
		
		ResultSet tabela = cdao.carregarProdutos();
		this.produto.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.produto.add(dadosProduto(tabela));				
			}
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Produto dadosProduto(ResultSet tabela) {
		Produto p = new Produto();
		
		try {
			p.setNome_prod(tabela.getString("nome"));
			p.setDescricao(tabela.getString("descrição"));
			p.setVl_un(tabela.getDouble("vl_uni"));
			p.setIdproduto(tabela.getInt("idproduto"));
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
