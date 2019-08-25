package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Persistencia.DMCliente;

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
    	dmCli.conectaDataBase("db_clinicaVeterinaria","root","7224");//Fazer a Conexao com o BD
    	System.out.println("Conex�o feita � tabela Cliente com sucesso!");
        incluir(this);
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
		dmCli.conectaDataBase("db_clinicaVeterinaria","root","7224");//Fazer a Conexao com o BD
    	System.out.println("Conex�o feita � tabela Cliente com sucesso!");
	}
	
	public void buscar(String cpf) {
		String info = dmCli.buscar(cpf);
		if (info != "") {
			JOptionPane.showMessageDialog(null,"Cliente encontrado!\n" + info,"Sucesso!",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("../Clinica_Veterinaria/src/Images/cliente_icone.png"));
		} else {
			JOptionPane.showMessageDialog(null, "Cliente nao encontrado!","Erro!", JOptionPane.ERROR_MESSAGE);			
		}
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
            	JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
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
        			JOptionPane.showMessageDialog(null,"Este Cliente nao pode ser excluido, por ser proprietario de um animal cadastrado. "
        					+ "\nSe deseja excluir este cliente, devera excluir o animal de id: " + idAnimal,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
        		}
        		else
        		{
        			dmCli.excluir(this);
        			JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
            else
            {   
            	JOptionPane.showMessageDialog(null,"Exclus�o de Cliente n�o realizada!\nCliente nao encontrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
        }    
    }

    public void alterar()
    {   
    	if (dmCli.consultar(this)!= null)
        { 
    		dmCli.alterar(this);
    		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    	}
        else
        {   
        	JOptionPane.showMessageDialog(null,"Alteracao de Cliente n�o realizada!\nCliente nao encontrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void shutDown()
    {   
    	dmCli.shutDown();   
    }
}