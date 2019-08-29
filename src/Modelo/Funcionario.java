package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Persistencia.DMFuncionario;

public class Funcionario 
{
	private String nome, cpf, ctps, rg, dtNascimento, dtContratacao, genero;
	private double salario;
	private int idFunc;
	
	private DMFuncionario dmFun;

	
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
	
	public String getCtps() 
	{
		return ctps;
	}
	public void setCtps(String ctps) 
	{
		this.ctps = ctps;
	}
	
	public String getRg() 
	{
		return rg;
	}
	public void setRg(String rg) 
	{
		this.rg = rg;
	}
	
	public String getDtNascimento() 
	{
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) 
	{
		this.dtNascimento = dtNascimento;
	}
	
	public String getDtContratacao() 
	{
		return dtContratacao;
	}
	public void setDtContratacao(String dtContratacao) 
	{
		this.dtContratacao = dtContratacao;
	}
	
	public String getGenero() 
	{
		return genero;
	}
	public void setGenero(String genero) 
	{
		this.genero = genero;
	}
	
	public double getSalario() 
	{
		return salario;
	}
	public void setSalario(double salario)
	{
		this.salario = salario;
	}
	public int getIdFunc() {
		return idFunc;
	}
	
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	
	//Constructors
	public Funcionario(String nome, String cpf, String ctps, String rg, String dtNascimento, String dtContratacao, String genero, double salario)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.ctps = ctps;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.dtContratacao = dtContratacao;
		this.genero = genero;
		this.salario = salario;
		dmFun = new DMFuncionario();
    	dmFun.conectaDataBase();
    	System.out.println("Conexão com a tabela Funcionario feita com sucesso!");
	}
	
	public Funcionario(String cpf)
	{
		this.cpf = cpf;
		Connect();
	}
	
	public Funcionario(int id)
	{
		this.idFunc = id;
		Connect();
	}
	
	void Connect()
	{
		dmFun = new DMFuncionario();
    	dmFun.conectaDataBase();
    	System.out.println("Conexão com a tabela Funcionario feita com sucesso!");
	}
	
	public void buscar(Funcionario objFun) {
		Funcionario fun = (Funcionario) dmFun.consultar(this);
		if (fun != null) {
			String info = "Funcionario "+fun.getIdFunc()+
					"\nNome: "+fun.getNome()+
					"\nCPF: "+fun.getCpf()+
					"\nCTPS: "+fun.getCtps()+
					"\nRG: "+fun.getRg()+
					"\nData de Nascimento: "+fun.getDtNascimento()+
					"\nGênero: "+fun.getGenero()+
					"\nSalário: "+fun.getSalario()+
					"\nData de Contratação: "+fun.getDtContratacao();
			JOptionPane.showMessageDialog(null,"Funcionário encontrado!\n"+info,"Sucesso!",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("../clinica_Veterinaria/src/Images/veterinario_icone.png"));
		} else {
			JOptionPane.showMessageDialog(null, "Funcionário não encontrado!","Mensagem de erro", JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	public Funcionario find() {
		if (!this.cpf.equals(""))
		{
			Funcionario fun = (Funcionario) dmFun.consultar(this);
			if (fun != null) {
				String info = "Funcionario "+fun.getIdFunc()+
						"\nNome: "+fun.getNome()+
						"\nCPF: "+fun.getCpf()+
						"\nCTPS: "+fun.getCtps()+
						"\nRG: "+fun.getRg()+
						"\nData de Nascimento: "+fun.getDtNascimento()+
						"\nGênero: "+fun.getGenero()+
						"\nSalário: "+fun.getSalario()+
						"\nData de Contratação: "+fun.getDtContratacao();
				System.out.println(info);
				
				return fun;
			}
		}
		return null;
	}
	
	public Funcionario findById() 
	{
		Funcionario fun = (Funcionario) dmFun.consultaID(this);
		if (fun != null) {
			String info = "Funcionario "+fun.getIdFunc()+
					"\nNome: "+fun.getNome()+
					"\nCPF: "+fun.getCpf()+
					"\nCTPS: "+fun.getCtps()+
					"\nRG: "+fun.getRg()+
					"\nData de Nascimento: "+fun.getDtNascimento()+
					"\nGênero: "+fun.getGenero()+
					"\nSalário: "+fun.getSalario()+
					"\nData de Contratação: "+fun.getDtContratacao();
			System.out.println(info);
			
			return fun;
		}	
		return null;
	}
	
	public void incluir(Funcionario objFun)
    {   
		if (objFun.getCpf().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"CPF é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmFun.consultar(this)!= null)
            {   
        		JOptionPane.showMessageDialog(null,"Cadastro de Funcionário não realizado! \nJá existe um Funcionário com este CPF!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
            else
            { 
            	dmFun.incluir(this);
            }
        }
    }
	
	public void excluir(Funcionario objFun)
    {   
		if (objFun.getCpf().equals(""))
        {   
			JOptionPane.showMessageDialog(null,"CPF é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
        	if (dmFun.consultar(this)!= null)
            { 
    			dmFun.excluir(this);
    			JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        	}
            else
            {   
            	JOptionPane.showMessageDialog(null,"Exclusão de Funcionário não realizada!\nFuncionário não encontrado!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            }
        }    
    }
	
	public void shutDown()
    {   
    	dmFun.shutDown();   
    }
	
}
