package Modelo;

public abstract class Procedimento 
{
	protected String data, hora;
	protected Animal animal;
	protected String veterinario;
	
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
	
	public String getVeterinario() 
	{
		return veterinario;
	}
	public void setVeterinario(String veterinario) 
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
