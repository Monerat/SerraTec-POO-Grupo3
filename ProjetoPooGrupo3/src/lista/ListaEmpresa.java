package lista;

import java.util.ArrayList;

import classes.Empresa;
import conexao.Conexao;

public class ListaEmpresa {
	private Conexao con;
	private String schema;
	
	ArrayList<Empresa> empresas = new ArrayList<>();
}
