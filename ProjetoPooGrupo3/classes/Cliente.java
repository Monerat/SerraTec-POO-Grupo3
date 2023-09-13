package classes;

import java.time.LocalDate;
import java.util.Scanner;
import contantes.Util;

public class Cliente extends Pessoa {
	private int idcliente;
	private String cpf;
	private String telefone;
	private String endereco;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String Uf;
	private String email;
	private LocalDate data_nasc;
	
	public static Cliente cadastrar() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Cliente c = new Cliente();

		//System.out.println("Informe o Nome do Cliente: ");
		c.setNome(Util.validarString("Informe o Nome do Cliente: "));
		//System.out.println("Informe o CPF do Cliente: ");
		c.setCpf(Util.validarCPF("Informe o CPF do Cliente: "));
		//System.out.println("Informe o Telefone do Cliente: ");
		c.setTelefone(Util.validarTelefone("Informe o Telefone do Cliente: "));
		System.out.println("Informe o Email do Cliente: ");
		c.setEmail(Util.validarEmail("Informe o Email do Cliente: "));
		c.setData_nasc(Util.validarData("Informe a Data de Nascimento do Cliente: "));
		
		// Pega o logradouro
		c.setLogradouro(Util.validarString("Logradouro: "));

		// Pega o número
		c.setNumero(Util.validarInteiro("Número: "));

		// Pega o bairro
		c.setBairro(Util.validarString("Bairro: "));

		// Pega a cidade
		c.setCidade(Util.validarString("Cidade: "));

		// Pega o UF
		c.setUf(Util.validarString("UF: "));

		// Junta as partes do endereço
		c.setEndereco(c.getLogradouro() + ", " + c.getNumero() + ", " + c.getBairro() + ", " + c.getCidade() + ", " + c.getUf());
		
		
		return c;
	}
	
	public static Cliente alterar(Cliente c) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira o Nome: ");
		c.setNome(input.nextLine());
		System.out.println("Insira o CPF: ");
		c.setCpf(input.nextLine());
		System.out.println("Insira o Telefone: ");
		c.setTelefone(input.nextLine());
		System.out.println("Insira o Endereco: ");
		c.setEndereco(input.nextLine());
		System.out.println("Insira o Email: ");
		c.setEmail(input.nextLine());
		c.setData_nasc(Util.validarData("Informe a Data de Nascimento do Cliente: "));

		return c;		
	}
	
	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return Uf;
	}

	public void setUf(String uF) {
		Uf = uF;
	}
}
