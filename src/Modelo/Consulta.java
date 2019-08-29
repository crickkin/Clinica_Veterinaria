package Modelo;

import javax.swing.JOptionPane;

import Persistencia.DMConsulta;

public class Consulta extends Procedimento
{
	private String sintomas, diagnostico;
	private int idConsulta;
	
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
	
	public int getIdConsulta() 
	{
		return idConsulta;
	}
	public void setIdConsulta(int id) 
	{
		this.idConsulta = id;
	}
	
	//Methods
	void Connect()
	{
		dmCon = new DMConsulta();
		dmCon.conectaDataBase();
		System.out.println("Conex�o com a tabela Consulta estabelecida com sucesso");
	}
	
	public void incluir()
	{
		if (this.animal != null && this.veterinario != null)
		{
			Connect();
			if (this.data == null || this.hora == null)
			{
				JOptionPane.showMessageDialog(null, "Os campos Data e Hora s�o obrigat�rios.", "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (dmCon.consultar(this) == null)
				{
					dmCon.incluir(this);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "J� existe uma consulta nessa hora e data.", "Erro ao Marcar", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Animal ou Veterin�rio inexistentes no banco de dados", "Erro de par�metros", JOptionPane.ERROR_MESSAGE);
		}
	}
}
