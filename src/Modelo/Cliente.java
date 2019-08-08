package Modelo;

public class Cliente 
{
	private String nome, cpf, telefone, email;

	//Constructors
	public Cliente(String nome, String cpf, String telefone, String email)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}
	
	//Setters 'n Getters
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCpf() 
	{
		return cpf;
	}
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getTelefone()
	{
		return telefone;
	}
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
