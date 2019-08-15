package Apresentacao;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Main_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Main_Screen() 
	{
		/*Configurações padrão da Janela*/
		this.setTitle("Clinica Veterinária");
		this.setSize(1280, 720);
		this.setLayout(new BorderLayout());
		
		Container contentPane = getContentPane();
		
		Menu_Bar barraMenu = new Menu_Bar();
		barraMenu.add(this);
		this.setJMenuBar(barraMenu.create());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(200, 200);
		
		JButton cadastrar = new JButton("Cadastrar");
		mainPanel.add(cadastrar);
		
		JButton consultar = new JButton("Consultar Histórico");
		mainPanel.add(consultar);
		
		JButton agendar = new JButton("Agendar");
		mainPanel.add(agendar);
		
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}