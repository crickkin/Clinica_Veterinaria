package Modelo;

import Persistencia.DMConsulta;

public class Consulta extends Procedimento
{
	private String sintomas, diagnostico;
	
	private DMConsulta dmCon;

	//Constrcutor
	public Consulta(String data, String hora, String nomeVeterinario, String nomeAnimal, String cpfCliente, String sintomas, String diagnostico)
	{
		super(data, hora, nomeVeterinario, nomeAnimal, cpfCliente);
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
	}
	
	//Setters 'n Getters
	public String getSintomas() 
	{
		return sintomas;
	}
	public void setSintomas(String sintomas) 
	{
		this.sintomas = sintomas;
	}

	public String getDiagnostico() 
	{
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) 
	{
		this.diagnostico = diagnostico;
	}
	
	//Methods
	public void incluir(Consulta objCon)
	{
		if (this.animal != null && this.veterinario != null)
		{
			dmCon = new DMConsulta();
			dmCon.conectaDataBase();
			System.out.println("Conexão com a tabela Consulta estabelecida com sucesso");
		}
	}
}
