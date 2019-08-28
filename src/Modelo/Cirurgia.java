package Modelo;

public class Cirurgia extends Procedimento
{
	private String urgencia, situacao;
	private int duracao;
	
	//Constructor
	public Cirurgia(String data, String hora, String urgencia, String situacao, String duracao)
	{
		super(data, hora, "", "", "");
		this.urgencia = urgencia;
		this.situacao = situacao;
		this.duracao = Integer.parseInt(duracao);
	}
	
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
