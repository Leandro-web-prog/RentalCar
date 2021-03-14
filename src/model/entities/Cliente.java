package model.entities;

public class Cliente {
	
	private String nome;
	private String CPF = "000.000.000-00";
	private String telefone = "(00)00000-0000";
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cPF, String telefone) {
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CPF=" + CPF + ", telefone=" + telefone + "]";
	}
			
}
