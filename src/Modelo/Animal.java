package Modelo;

public class Animal 
{
	private String nome, raca, especie;
	private char sexo;
	private Cliente proprietario;
	
	//Construct
	public Animal(){};
	public Animal(String nome, String raca, String especie, boolean sexo)
	{
		this.nome = nome;
		this.raca = raca;
		this.especie = especie;
		this.sexo = (sexo) ? 'M' : 'F';
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
	
	public String getRaca() 
	{
		return raca;
	}
	public void setRaca(String raca) 
	{
		this.raca = raca;
	}
	
	public String getEspecie() 
	{
		return especie;
	}
	public void setEspecie(String especie) 
	{
		this.especie = especie;
	}
	
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) 
	{
		this.sexo = sexo;
	}
	
	public Cliente getProprietario() 
	{
		return proprietario;
	}
	public void setProprietario(Cliente proprietario) 
	{
		this.proprietario = proprietario;
	}
}
