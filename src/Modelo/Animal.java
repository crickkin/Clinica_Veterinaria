package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Persistencia.*;

public class Animal 
{
	private String nome, raca, especie;
	private char sexo;
	private int idade;
	private Cliente proprietario;
	
	private int idAnimal;
	
	private DMAnimal dmAni;
	
	//Construct
	public Animal(String nome, String raca, String especie, char sexo, int idade, String cpfProprietario)
	{
		this.nome = nome;
		this.raca = raca;
		this.especie = especie;
		this.sexo = sexo;
		this.idade = idade;
		this.proprietario = new Cliente(cpfProprietario);
		if (this.proprietario.buscar())
		{
			dmAni = new DMAnimal();
			dmAni.conectaDataBase();
			System.out.println("Conexão com a tabela Animal feita com sucesso!");
			incluir(this);
		}
	}
	
	public Animal(String nome, String cpfProprietario)
	{
		this.nome = nome;
		this.proprietario = new Cliente(cpfProprietario);
		if (this.proprietario.buscar())
		{
			dmAni = new DMAnimal();
			dmAni.conectaDataBase();
			System.out.println("Conexão com a tabela Animal feita com sucesso!");
			buscar();
		}
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
	
	public int getIdade() 
	{
		return idade;
	}
	public void setIdade(int idade) 
	{
		this.idade = idade;
	}
	
	public int getIdAnimal() 
	{
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) 
	{
		this.idAnimal = idAnimal;
	}
	
	//Persistência
	public void incluir(Animal objAni)
	{
		if (objAni.getNome().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"Nome do Animal é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmAni.consultar(this)!= null)
            {   
        		JOptionPane.showMessageDialog(null,"Cadastro de Animal não realizado! \nEste Animal já foi registrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            else
            { 
            	dmAni.incluir(this);
            }
        }
	}
	
	public Boolean buscar() {
		Animal ani = (Animal) dmAni.consultar(this);
		if (ani != null) {
			String info = "Animal "+ani.getIdAnimal()+
					"\nNome: "+ani.getNome()+
					"\nEspécie: "+ani.getEspecie()+
					"\nRaça: "+ani.getRaca()+
					"\nSexo: "+ani.getSexo()+
					"\nIdade: "+ani.getIdade();
			JOptionPane.showMessageDialog(null,"Animal encontrado!\n"+info,"Sucesso!",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("../Clinica_Veterinaria/src/Images/pata_icone.png"));
			return true;
		}
		
		JOptionPane.showMessageDialog(null, "Animal não encontrado!","Mensagem de erro", JOptionPane.ERROR_MESSAGE);
		return false;
	}
}
