package Apresentacao;

import Modelo.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import Modelo.Cliente;

import java.awt.*;
import java.awt.event.*;

public class Animal_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel pCadastro, pBusca;
	private JLabel lNome, lRaca, lEspecie, lSexo, lIdade, lProprietario, lCpfBusca, lNomePesquisa;
	private JTextField tNome, tRaca, tEspecie, tSexo, tIdade, tProprietario, tCpfBusca, tNomePesquisa;
	private JButton bSalvar, bListar, bBuscar, bLimpar, bExcluir, bLimparCpf, bFechar;
	
	String nome, raca, especie, proprietario;
	char sexo;
	int idade;
	Animal objAni, objSalvar;
	
	public Animal_Screen()
	{
		this.setSize(630,440);
		this.setTitle("Tela de Gerenciamento de Animal");
		this.setResizable(false);
		this.setLayout(null); 
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Clinica_Veterinaria/src/Images/icone_pata_cruz.png");
		this.setIconImage(img);
		
		//criando classe interna para funcionar como ouvinte dos eventos de mouse
		class Event extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == bSalvar) {					
					nome = tNome.getText();
					raca = tRaca.getText();
					especie = tEspecie.getText();
					sexo = tSexo.getText().charAt(0);
					idade = Integer.parseInt(tIdade.getText());
					proprietario = tProprietario.getText();
					
					objSalvar = new Animal(nome,raca,especie, sexo, idade);	
					objSalvar.incluir(objSalvar);
				}
				
				if (e.getSource() == bLimpar) {
					tNome.setText("");
					tRaca.setText("");
					tSexo.setText("");
					tEspecie.setText("");
					tProprietario.setText("");
					tIdade.setText("");
				}
				
				if (e.getSource() == bLimparCpf) {
					tNomePesquisa.setText("");
					tCpfBusca.setText("");
				}
				
				if (e.getSource() == bBuscar) {
					/*cpfBusca = tCpfBusca.getText();
					objCli = new Cliente(cpfBusca);
					objCli.buscar(objCli);*/
				}
				
				if (e.getSource() == bExcluir) {
					/*cpfBusca = tCpfBusca.getText();
					objCli = new Cliente(cpfBusca);
					objCli.excluir(objCli);*/
				}
				
				if (e.getSource() == bFechar) {
					dispose(); 
				}
			}	
		}
		
		
		//adicionando ouvinte para os botï¿½es
		Event action = new Event();
		
		//criando os panels para estruturar as ï¿½reas na tela 
		pCadastro = new JPanel();
		pCadastro.setSize(610,210);
		pCadastro.setLocation(10,10);
		pCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro de animal:"));
		pCadastro.setLayout(null);
		
		pBusca = new JPanel();
		pBusca.setSize(610,110);
		pBusca.setLocation(10,230);
		pBusca.setBorder(BorderFactory.createTitledBorder("Busca e Exclusão"));
		pBusca.setLayout(null);
		
		//adicionando os labels	e text fields
		
		lNome = new JLabel("Nome: ");
		lNome.setSize(150,30);
		lNome.setLocation(20,20);
		
		tNome = new JTextField();
		tNome.setSize(400,20);
		tNome.setLocation(190,25);
		
		lRaca = new JLabel("Raça: ");
		lRaca.setSize(150,30);
		lRaca.setLocation(20,50);
		
		tRaca = new JTextField();
		tRaca.setSize(120,20);
		tRaca.setLocation(190,55);
		
		lEspecie = new JLabel("Espécie: ");
		lEspecie.setSize(150,30);
		lEspecie.setLocation(20,80);
		
		tEspecie = new JTextField();
		tEspecie.setSize(120,20);
		tEspecie.setLocation(190,85);
		
		lSexo = new JLabel("Sexo: ");
		lSexo.setSize(150,30);
		lSexo.setLocation(20,110);
		
		tSexo = new JTextField();
		tSexo.setSize(15,20);
		tSexo.setLocation(190,115);
		
		lIdade = new JLabel("Idade: ");
		lIdade.setSize(150,30);
		lIdade.setLocation(20,140);
		
		tIdade = new JTextField();
		tIdade.setSize(50,20);
		tIdade.setLocation(190,145);
		
		lProprietario = new JLabel("Proprietário(CPF): ");
		lProprietario.setSize(150,30);
		lProprietario.setLocation(20,170);
		
		tProprietario = new JTextField();
		tProprietario.setSize(150,20);
		tProprietario.setLocation(190,175);
		
		lNomePesquisa = new JLabel("Nome do Animal: ");
		lNomePesquisa.setSize(150,30);
		lNomePesquisa.setLocation(20,20);
		
		tNomePesquisa = new JTextField();
		tNomePesquisa.setSize(120,20);
		tNomePesquisa.setLocation(130,25);
		
		lCpfBusca = new JLabel("CPF: ");
		lCpfBusca.setSize(50,30);
		lCpfBusca.setLocation(20,50);
		
		tCpfBusca = new JTextField();
		tCpfBusca.setSize(120,20);
		tCpfBusca.setLocation(70,55);

				
		//adicionando os buttons
//		bEditar = new JButton("Editar");
//		bEditar.setSize(85,30);
//		bEditar.setLocation(325,160);
//		bEditar.setForeground(Color.white);
//		bEditar.setBackground(Color.gray);
//		bEditar.addMouseListener(action);
		
		bSalvar = new JButton("Salvar");
		bSalvar.setSize(85,30);
		bSalvar.setLocation(415,160);
		bSalvar.setForeground(Color.white);
		bSalvar.setBackground(Color.gray);
		bSalvar.addMouseListener(action);
		
		bLimpar = new JButton("Limpar");
		bLimpar.setSize(85,30);
		bLimpar.setLocation(505,160);
		bLimpar.setForeground(Color.white);
		bLimpar.setBackground(Color.gray);
		bLimpar.addMouseListener(action);
		
//		bListar = new JButton("Listar");
//		bListar.setSize(85,30);
//		bListar.setLocation(235,60);
//		bListar.setForeground(Color.white);
//		bListar.setBackground(Color.gray);
//		bListar.addMouseListener(action);
				
		bBuscar = new JButton("Buscar");
		bBuscar.setSize(85,30);
		bBuscar.setLocation(325,60);
		bBuscar.setForeground(Color.white);
		bBuscar.setBackground(Color.gray);
		bBuscar.addMouseListener(action);

		bExcluir = new JButton("Excluir");
		bExcluir.setSize(85,30);
		bExcluir.setLocation(415,60);
		bExcluir.setForeground(Color.white);
		bExcluir.setBackground(Color.gray);
		bExcluir.addMouseListener(action);
		
		bLimparCpf = new JButton("Limpar");
		bLimparCpf.setSize(85,30);
		bLimparCpf.setLocation(505,60);
		bLimparCpf.setForeground(Color.white);
		bLimparCpf.setBackground(Color.gray);
		bLimparCpf.addMouseListener(action);
		
		bFechar = new JButton("Fechar");
		bFechar.setSize(85,30);
		bFechar.setLocation(515,360);
		bFechar.setForeground(Color.white);
		bFechar.setBackground(Color.gray);
		bFechar.addMouseListener(action);
		
		//acrescentando os componentes ï¿½ tela
		this.add(pCadastro);
		pCadastro.add(lNome);
		pCadastro.add(tNome);

		pCadastro.add(lRaca);
		pCadastro.add(tRaca);
		
		pCadastro.add(lEspecie);
		pCadastro.add(tEspecie);
		
		pCadastro.add(lSexo);
		pCadastro.add(tSexo);
		
		pCadastro.add(lIdade);
		pCadastro.add(tIdade);
		
		pCadastro.add(lProprietario);
		pCadastro.add(tProprietario);
		
		pCadastro.add(bSalvar);
		pCadastro.add(bLimpar);
//		pCadastro.add(bEditar);
		
		this.add(pBusca);
		pBusca.add(lNomePesquisa);
		pBusca.add(tNomePesquisa);
		
		pBusca.add(lCpfBusca);
		pBusca.add(tCpfBusca);
//		pBusca.add(bListar);
		pBusca.add(bBuscar);
		pBusca.add(bExcluir);
		pBusca.add(bLimparCpf);
		
		this.add(bFechar);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.repaint();
	}
}
