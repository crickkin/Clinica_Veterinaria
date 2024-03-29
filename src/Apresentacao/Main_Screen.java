package Apresentacao;

import Persistencia.DMFuncionario;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Main_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton bCadastrar, bAgendar, bConsultar;
	
	private String bdLogin, bdSenha;

	public Main_Screen() 
	{
		/*Configura��es padr�o da Janela*/
		this.setTitle("Clinica Veterin�ria");
		this.setSize(1280, 720);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Clinica_Veterinaria/src/Images/clinica_icone.png");
		this.setIconImage(img);
		
		this.bdLogin = "root";
		this.bdSenha = "petricor";
		BdInitialize();
		
		/*Listener*/
		class Sinal extends MouseAdapter {
			public void mouseClicked(MouseEvent evento) {
				if (evento.getSource() == bCadastrar)
				{
					String[] options = new String[] {"Animal", "Cliente", "Funcion�rio", "Cancelar"};
				    int response = JOptionPane.showOptionDialog(null, "Selecione 1 tipo de cadastro", "Novo Cadastro",
				        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				        null, options, options[0]);
				    switch (response)
				    {
				    	case 0:
				    		new Animal_Screen();	
				    		break;
				    	case 1:
				    		new TelaCliente();
				    		break;
				    	case 2:
				    		new Funcionario_Screen();
				    		break;
				    	default:
				    		break;
				    }
				}
				
				if (evento.getSource() == bConsultar)
				{
					System.out.println("bConsultar");
				}
				
				if (evento.getSource() == bAgendar)
				{
					String[] options = new String[] {"Consulta", "Cirurgia", "Cancelar"};
				    int response = JOptionPane.showOptionDialog(null, "Selecione 1 tipo de procedimento", "Novo Cadastro",
				        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				        null, options, options[0]);
				    
				    if (response == 0)
				    {
				    	new Consulta_Screen();
				    }
				    else if (response == 1)
				    {
				    	new Cirurgia_Screen();
				    }
				}
			}
		}
		
		Sinal listener = new Sinal();
		
		Container contentPane = getContentPane();
		
		Menu_Bar barraMenu = new Menu_Bar();
		barraMenu.add(this);
		this.setJMenuBar(barraMenu.create());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(200, 200);
		
		bCadastrar = new JButton("Gerencia de Cadastro");
		bCadastrar.addMouseListener(listener);
		
		bConsultar = new JButton("Consultar Hist�rico");
		bConsultar.addMouseListener(listener);
		
		bAgendar = new JButton("Agendar Procedimento");
		bAgendar.addMouseListener(listener);

		mainPanel.add(bCadastrar);
		//mainPanel.add(bConsultar);
		mainPanel.add(bAgendar);
		
		contentPane.add(mainPanel, BorderLayout.CENTER);
		contentPane.add(new Status_Bar(), BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.repaint();
	}
	
	//Login e Senha Banco de Dados
	public void BdInitialize(){
		new DMFuncionario().ChangeDataBaseInfo("db_clinicaVeterinaria", this.bdLogin, this.bdSenha);
	}
	
	public void LoginDataBase(){
		this.bdLogin = JOptionPane.showInputDialog("Login do Banco de Dados");
		this.bdSenha = JOptionPane.showInputDialog("Senha do Banco de Dados");
		BdInitialize();
	}
	
	/*Defini��o de M�todos chamados no Menu Bar*/
	public void CadastrarAnimal()
	{
		new Animal_Screen();
	}
	
	public void CadastrarCliente()
	{
		new TelaCliente();
	}
	
	public void CadastrarFuncionario()
	{
		new Funcionario_Screen();
	}
	
	public void Sair()
	{
		dispose();
	}
	
	public void AgendarConsulta()
	{
		new Consulta_Screen();
	}
	
	public void Sobre(){
		JOptionPane.showMessageDialog(null, "Instituto Federal Fluminense campus Campos Centro\n"
				+ "Desenvolvedores: N�colas Souza & Danielly Dantos\n"
				+ "Trabalho de Programa��o Orientada o Objeto\n"
				+ "Bacharelado em Sistemas de Informa��o - 4� Per�odo");
	}
}