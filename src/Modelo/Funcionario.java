package Modelo;

public class Funcionario 
{
	private String nome, cpf, ctps, rg, dtNascimento, dtContratacao;
	private char genero;
	private double salario;
	
	//Constructors
	public Funcionario(String nome, String cpf, String ctps, String rg, String dtNascimento, String dtContratacao, boolean genero, String salario)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.ctps = ctps;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.dtContratacao = dtContratacao;
		this.genero = (genero) ? 'M' : 'F';
		this.salario = Double.parseDouble(salario);
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
	
	public String getCtps() 
	{
		return ctps;
	}
	public void setCtps(String ctps) 
	{
		this.ctps = ctps;
	}
	
	public String getRg() 
	{
		return rg;
	}
	public void setRg(String rg) 
	{
		this.rg = rg;
	}
	
	public String getDtNascimento() 
	{
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) 
	{
		this.dtNascimento = dtNascimento;
	}
	
	public String getDtContratacao() 
	{
		return dtContratacao;
	}
	public void setDtContratacao(String dtContratacao) 
	{
		this.dtContratacao = dtContratacao;
	}
	
	public char getGenero() 
	{
		return genero;
	}
	public void setGenero(char genero) 
	{
		this.genero = genero;
	}
	
	public double getSalario() 
	{
		return salario;
	}
	public void setSalario(double salario)
	{
		this.salario = salario;
	}
}
