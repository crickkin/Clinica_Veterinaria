package Apresentacao;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.*;

public class Animal_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel pPrincipal ,pInfoPrimaria, pInfoSecudaria, pInfoExterna;
	private JLabel lNome, lRaca, lEspecie, lSexo, lIdade, lProprietario;
	private JTextField tNome, tRaca, tEspecie, tSexo, tIdade, tProprietario;
	
	private String nome, raca, especie, sexo, idade, proprietario;
	
	public Animal_Screen()
	{
		this.setSize(1280, 720);
		this.setTitle("Cadastro de Animal");
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		
		pPrincipal = new JPanel();
		
		pInfoPrimaria = new JPanel();
		pInfoPrimaria.setLocation(10, 10);
		pInfoPrimaria.setSize(600, 200);
		
		lNome = new JLabel("Nome: ");
		tNome = new JTextField();
		
		pInfoPrimaria.add(BorderLayout.WEST ,lNome);
		
		pPrincipal.add(pInfoPrimaria);
		
		this.add(BorderLayout.PAGE_START, pPrincipal);
		
		this.setVisible(true);
		this.repaint();
	}
}
