package Apresentacao;

import Modelo.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Main_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton bCadastrar, bAgendar, bConsultar;

	public Main_Screen() 
	{
		/*Configurações padrão da Janela*/
		this.setTitle("Clinica Veterinária");
		this.setSize(1280, 720);
		this.setLayout(new BorderLayout());
		
		/*Listener*/
		class Sinal extends MouseAdapter {
			public void mouseClicked(MouseEvent evento) {
				if (evento.getSource() == bCadastrar)
				{
					new Animal_Screen();
				}
				
				if (evento.getSource() == bConsultar)
				{
					System.out.println("bConsultar");
				}
				
				if (evento.getSource() == bAgendar)
				{
					System.out.println("Agendar");
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
		
		bCadastrar = new JButton("Cadastrar");
		bCadastrar.addMouseListener(listener);
		
		bConsultar = new JButton("Consultar Histórico");
		bConsultar.addMouseListener(listener);
		
		bAgendar = new JButton("Agendar");
		bAgendar.addMouseListener(listener);

		mainPanel.add(bCadastrar);
		mainPanel.add(bConsultar);
		mainPanel.add(bAgendar);
		
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		this.repaint();
		this.setVisible(true);
	}
}