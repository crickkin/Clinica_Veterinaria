package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Persistencia.DMCliente;

public class Cliente
{
	private String nome, cpf, telefone, email;
	
	private int idCliente;
	
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
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	//Constructors
	public Cliente(String nome, String cpf, String telefone, String email)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		dmCli = new DMCliente();
    	dmCli.conectaDataBase();
    	System.out.println("Conexão com a tabela Cliente feita com sucesso!");
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
		dmCli = new DMCliente();
		dmCli.conectaDataBase();
		System.out.println("Conexão com a tabela Cliente feita com sucesso!");
	}
	
	public void buscar(Cliente objCli) {
		Cliente cli = (Cliente) dmCli.consultar(this);
		if (cli != null) {
			String info = "Cliente "+cli.getIdCliente()+
					"\nNome: "+cli.getNome()+
					"\nCPF: "+cli.getCpf()+
					"\nTelefone: "+cli.getTelefone()+
					"\nEmail: "+cli.getEmail();
			JOptionPane.showMessageDialog(null,"Cliente encontrado!\n"+info,"Sucesso!",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("../Clinica_Veterinaria/src/Images/icone-clienteV.png"));
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado!","Mensagem de erro", JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	public void incluir(Cliente objCli)
    {   
		if (objCli.getCpf().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"CPF é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmCli.consultar(this)!= null)
            {   
        		JOptionPane.showMessageDialog(null,"Cadastro de Cliente não realizado! \nJá existe um Cliente com este CPF!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            else
            { 
            	dmCli.incluir(this); 
            	JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
	
	public void excluir(Cliente objCli)
    {   
		if (objCli.getCpf().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"CPF é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmCli.consultar(this)!= null)
            { 
        		int idAnimal = dmCli.temAnimal(this); 
        		if (idAnimal != 0) 
        		{
        			JOptionPane.showMessageDialog(null,"Este Cliente não pode ser excluído, por ser proprietário de um animal cadastrado. "
        					+ "\nSe deseja excluir este cliente, deverá excluir o animal de id: " + idAnimal,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
        		}
        		else
        		{
        			dmCli.excluir(this);
        			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
            else
            {   
            	JOptionPane.showMessageDialog(null,"Exclusão de Cliente não realizada!\nCliente não encontrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
        }    
    }

//    public void alterar(Cliente objCli)
//    {   
//    	System.out.println(objCli.getNome());
//    	if (objCli.getCpf().equals(""))
//        {   
//			JOptionPane.showMessageDialog(null,"CPF é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
//        }
//        else
//        { 
//        	Object consulta = dmCli.consultar(this);
//	    	if (consulta != null)
//	        { 
//	    		dmCli.alterar(objCli);
//	    		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
//	    	}
//	        else
//	        {   
//	        	JOptionPane.showMessageDialog(null,"Alteração de Cliente não realizada!\nCliente não encontrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
//	        }
//        }
//    }

    public void shutDown()
    {   
    	dmCli.shutDown();   
    }
}