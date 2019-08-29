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
		System.out.println("Conexão com a tabela Consulta estabelecida com sucesso");
	}
	
	public void incluir()
	{
		if (this.animal != null && this.veterinario != null)
		{
			Connect();
			if (this.data == null || this.hora == null)
			{
				JOptionPane.showMessageDialog(null, "Os campos Data e Hora são obrigatórios.", "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (dmCon.consultar(this) == null)
				{
					dmCon.incluir(this);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Já existe uma consulta nessa hora e data.", "Erro ao Marcar", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Animal ou Veterinário inexistentes no banco de dados", "Erro de parâmetros", JOptionPane.ERROR_MESSAGE);
		}
	}
}
