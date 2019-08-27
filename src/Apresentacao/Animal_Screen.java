package Apresentacao;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class Animal_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel pPrincipal ,pInfoPrimaria, pInfoSecudaria, pInfoExterna;
	private JLabel lNome, lRaca, lEspecie, lSexo, lIdade, lProprietario;
	private JTextField tNome, tRaca, tEspecie, tSexo, tIdade, tProprietario;
	private JComboBox cbSexo;
	private JButton bCadastrar;
	
	private String nome, raca, especie, sexo, idade, proprietario;
	
	public Animal_Screen()
	{
		this.setSize(768, 432);
		this.setTitle("Cadastro de Animal");
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel pTitle = new JPanel();
		pTitle.setSize(200, 50);
		JLabel lTitle = new JLabel("Preencha as informações do Animal");
		lTitle.setFont( lTitle.getFont().deriveFont(32.0f) );
		pTitle.add(lTitle);
		
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new GridLayout(2, 1));
		
		pInfoPrimaria = new JPanel();
		pInfoPrimaria.setLocation(10, 10);
		pInfoPrimaria.setLayout(new GridLayout(6, 2));
		pInfoPrimaria.setSize(400, 200);
		
		lNome = new JLabel("Nome: ");
		tNome = new JTextField(20);
		
		pInfoPrimaria.add(lNome);
		pInfoPrimaria.add(tNome);
		
		lRaca = new JLabel("Raça: ");
		tRaca = new JTextField(20);
		
		pInfoPrimaria.add(lRaca);
		pInfoPrimaria.add(tRaca);
		
		lEspecie = new JLabel("Espécie: ");
		tEspecie = new JTextField(20);
		
		pInfoPrimaria.add(lEspecie);
		pInfoPrimaria.add(tEspecie);
		
		lSexo = new JLabel("Sexo: ");
		tSexo = new JTextField(1);
		
		pInfoPrimaria.add(lSexo);
		pInfoPrimaria.add(tSexo);
		
		lIdade = new JLabel("Idade: ");
		tIdade = new JTextField(10);
		
		pInfoPrimaria.add(lIdade);
		pInfoPrimaria.add(tIdade);
		
		/*Listener*/
		class Sinal extends MouseAdapter {
			public void mouseClicked(MouseEvent evento) {
				if (evento.getSource() == bCadastrar)
				{
					JOptionPane.showMessageDialog(null, "Seu Animal!");
				}
			}
		}
		
		Sinal listener = new Sinal();
		
		JPanel pButton = new JPanel();
		bCadastrar = new JButton("Cadastrar");
		bCadastrar.addMouseListener(listener);
		
		pButton.add(bCadastrar);
		
		pPrincipal.add(pInfoPrimaria);
		pPrincipal.add(pButton);
		
		this.add(BorderLayout.NORTH, pTitle);
		this.add(BorderLayout.CENTER, pPrincipal);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.repaint();
	}
}
