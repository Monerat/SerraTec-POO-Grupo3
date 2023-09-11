package lista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Empresa;
import conexao.Conexao;
import dao.EmpresaDAO;

public class ListaEmpresa {
	private Conexao con;
	private String schema;
	
	ArrayList<Empresa> empresas = new ArrayList<>();
	
	public ListaEmpresa (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaEmpresa();
	}
	
	public void adicionarEmpresaLista(Empresa emp) {
		this.empresas.add(emp);
	}
	
	public Empresa localizarEmpresa(int idEmpresa) {
		Empresa localizado = null;
		
		for (Empresa emp : empresas) {
			if (emp.getIdempresa() == idEmpresa) {
				localizado = emp;
				break;
			}
		}		
	
		return localizado;
	}
	
	private void carregarListaEmpresa() {
		EmpresaDAO edao = new EmpresaDAO(con, schema);
		
		ResultSet tabela = edao.carregarEmpresas();
		this.empresas.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.empresas.add(dadosEmpresa(tabela));				
			}
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Empresa dadosEmpresa(ResultSet tabela) {
		Empresa emp = new Empresa();
		
		try {
			emp.setNome_fantasia(tabela.getString("nome_fantasia"));
			emp.setRazao_social(tabela.getString("razao_social"));
			emp.setIdempresa(tabela.getInt("idempresa"));
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
