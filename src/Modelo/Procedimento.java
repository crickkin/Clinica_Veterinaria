package Modelo;

public abstract class Procedimento 
{
	protected String data, hora;
	protected Animal animal;
	protected Funcionario veterinario;
	
	//Constructor
	public Procedimento(String data, String hora, String cpfVeterinario, String nomeAnimal, String cpfCliente)
	{
		this.data = data;
		this.hora = hora;
		this.animal = new Animal(nomeAnimal, cpfCliente).find();
		this.veterinario = new Funcionario(cpfVeterinario).find();
	}
	
	public Procedimento(String data, String hora)
	{
		this.data = data;
		this.hora = hora;
	}
	
	//Setters 'n Getters
	public String getData() 
	{
		return data;
	}
	public void setData(String data) 
	{
		this.data = data;
	}
	
	public String getHora() 
	{
		return hora;
	}
	public void setHora(String hora) 
	{
		this.hora = hora;
	}
	
	public Animal getAnimal() 
	{
		return animal;
	}
	public void setAnimal(Animal animal) 
	{
		this.animal = animal;
	}
	
	public Funcionario getVeterinario() 
	{
		return veterinario;
	}
	public void setVeterinario(Funcionario veterinario) 
	{
		this.veterinario = veterinario;
	}
	
	//Methods
	public void Agendar()
	{
		
	}
	
	public void MostrarHistorico()
	{
		
	}
}
