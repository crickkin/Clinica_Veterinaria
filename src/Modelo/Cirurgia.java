package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Persistencia.DMCirurgia;

public class Cirurgia extends Procedimento
{
	private String situacao;
	private int duracao, urgencia, idCirurgia;
	
	DMCirurgia dmCir;
	
	//Constructor
	public Cirurgia(String data, String hora, String cpfVeterinario, String nomeAnimal, String cpfCliente ,int urgencia, String situacao, int duracao)
	{
		super(data, hora, cpfVeterinario, nomeAnimal, cpfCliente);
		this.urgencia = urgencia;
		this.situacao = situacao;
		this.duracao = duracao;
	}
	
	public Cirurgia(String data, String hora)
	{
		super(data, hora);
	}
	
	//Setters 'n Getters
	public int getUrgencia() 
	{
		return urgencia;
	}
	public void setUrgencia(int urgencia) 
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
	
	public int getIdCirurgia() 
	{
		return idCirurgia;
	}
	public void setIdCirurgia(int id) 
	{
		this.idCirurgia = id;
	}
	
	//Methods
	void Connect()
	{
		dmCir = new DMCirurgia();
		dmCir.conectaDataBase();
		System.out.println("Conexão com a tabela Cirurgia estabelecida com sucesso");
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
				if (dmCir.consultar(this) == null)
				{
					dmCir.incluir(this);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Já existe uma cirurgia nessa hora e data.", "Erro ao Marcar", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Animal ou Veterinário inexistentes no banco de dados", "Erro de parâmetros", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Boolean buscar()
	{
		Connect();
		Cirurgia cir = (Cirurgia) dmCir.consultar(this);
		if (cir != null)
		{
			String info = "Cirurgia "+cir.getIdCirurgia()+
					"\nData: "+cir.getData()+
					"\nHora: "+cir.getHora()+
					"\nVeterinario: "+cir.getVeterinario().getNome()+
					"\nAnimal: "+cir.getAnimal().getNome()+
					"\nGrau: "+cir.getUrgencia()+
					"\nSituacao: "+cir.getSituacao();
			
			JOptionPane.showMessageDialog(null, "Consulta encontrada!\n"+info, "Sucesso!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("../Clinica_Veterinaria/src/Images/agendamento_icone.png"));
			return true;
		}
		
		JOptionPane.showMessageDialog(null, "Consulta não encontrado!","Erro de Busca", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	public void excluir()
	{
		Connect();
		Cirurgia cir = (Cirurgia) dmCir.consultar(this);
		if (cir != null)
		{
			dmCir.excluir(cir);
			JOptionPane.showMessageDialog(null, "Consulta excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Exclusão de Consulta não realizada!\nFuncionário não encontrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
		}
	}
}
