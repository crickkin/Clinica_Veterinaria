package Modelo;

import javax.swing.JOptionPane;

import Persistencia.DMCliente;
import modelo.Cliente;
import modelo.Cliente;

public class Cliente
{
	private String nome, cpf, telefone, email;
	
	private DMCliente dmCli;

	//Setters 'n Getters
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCpf() 
	{
		return cpf;
	}
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	public String getTelefone()
	{
		return telefone;
	}
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	//Constructors
	public Cliente(String nome, String cpf, String telefone, String email)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		dmCli = new DMCliente();
    	dmCli.conectaDataBase("db_clinicaVeterinaria","root","root");//Fazer a Conexao com o BD
    	System.out.println("Conex�o feita � tabela Cliente com sucesso!");
        incluir(this);
	}
	
	public Object consultar()
    {
		return dmCli.consultar(this);   
    }
	
	public void incluir(Cliente objCli)
    {   
		if (objCli.getCpf().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"O cpf de Cliente � obrigat�rio!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmCli.consultar(this)!= null)
            {   
        		JOptionPane.showMessageDialog(null,"Cadastro de Cliente n�o realizado!\n J� existe um Cliente com este cpf!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            else
            { 
            	dmCli.incluir(this); 
            }
        }
    }
	
	public void excluir(Cliente objCli)
    {   
		if (objCli.getCpf().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"O cpf da Cliente � obrigat�rio!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmCli.consultar(this)!= null)
            { 
        		int idAnimal = dmCli.temAnimal(this); 
        		if (idAnimal != 0) 
        		{
        			JOptionPane.showMessageDialog(null,"Este Cliente nao pode ser excluido, por ser proprietario de um animal cadastrado. \nSe deseja excluir este cliente, devera excluir o animal de id: " + idAnimal,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
        		}
        		else
        		{
        			dmCli.excluir(this);         			
        		}
        	}
            else
            {   
            	JOptionPane.showMessageDialog(null,"Exclus�o de Cliente n�o realizada!\n Este cliente n�o existe!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
        }    
    }

    public void alterar()
    {   
    	if (dmCli.consultar(this)!= null)
        { 
    		dmCli.alterar(this); 
    	}
        else
        {   
        	JOptionPane.showMessageDialog(null,"Cliente nao encontrado!");
        }
    }
}