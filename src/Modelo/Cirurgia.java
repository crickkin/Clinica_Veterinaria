package Modelo;

public class Cirurgia 
{
	private String urgencia, situacao;
	private int duracao;
	
	//Setters 'n Getters
	public String getUrgencia() 
	{
		return urgencia;
	}
	public void setUrgencia(String urgencia) 
	{
		this.urgencia = urgencia;
	}
	
	public String getSituacao() 
	{
		return situacao;
	}
	public void setSituacao(String situacao) 
	{
		this.situacao = situacao;
	}
	
	public int getDuracao() 
	{
		return duracao;
	}
	public void setDuracao(int duracao) 
	{
		this.duracao = duracao;
	}
}
