package Modelo;

public class Consulta extends Procedimento
{
	private String sintomas, diagnostico;

	//Constrcutor
	public Consulta(String data, String hora, String sintomas, String diagnostico)
	{
		super(data, hora);
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
}
