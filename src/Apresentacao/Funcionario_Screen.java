package Apresentacao;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Funcionario_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lNome, lCpf, lCtps, lDtNascimento, lDtContratacao, lRg, lGenero, lSalario, lCpfBusca;
	private JTextField tNome, tCpf, tCtps, tDtNascimento, tDtContratacao, tRg, tGenero, tSalario, tCpfBusca;
	private JButton bSalvar, bLimpar, bListar, bBuscar, bExcluir, bEditar, bFechar, bLimparCpf;
	private JPanel pCadastro, pBusca;
	
	String nome, cpf, ctps, rg, dtNascimento, dtContratacao, genero;
	double salario;
	int idFunc;
	
	Funcionario objSalvar;
	
	public Funcionario_Screen()
	{
		this.setSize(630,440);
		this.setTitle("Tela de Gerenciamento de Funcionário");
		this.setResizable(false);
		this.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Clinica_Veterinaria/src/Images/veterinario_icone.png");
		this.setIconImage(img);
		
		//criando classe interna para funcionar como ouvinte dos eventos de mouse
		class Event extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == bSalvar) {					
					nome = tNome.getText();
					cpf = tCpf.getText();
					ctps = tCtps.getText();
					rg = tRg.getText();
					dtNascimento = tDtNascimento.getText();
					dtContratacao = tDtContratacao.getText();
					genero = tGenero.getText();
					salario = Double.parseDouble(tSalario.getText());
					objSalvar = new Funcionario(nome,cpf,ctps, rg, dtNascimento, dtContratacao, genero, salario);	
					objSalvar.incluir(objSalvar);
					dispose();
				}
				if (e.getSource() == bLimpar) {
					tNome.setText("");
					tCpf.setText("");
				}
				if (e.getSource() == bLimparCpf) {
					//tCpfBusca.setText("");
				}
				if (e.getSource() == bBuscar) {
					//cpfBusca = tCpfBusca.getText();
					//objCli = new Cliente(cpfBusca);
					//objCli.buscar(objCli);
				}
				if (e.getSource() == bExcluir) {
					//cpfBusca = tCpfBusca.getText();
					//objCli = new Cliente(cpfBusca);
					//objCli.excluir(objCli);
				}
				
				if (e.getSource() == bFechar) {
					dispose(); 
				}
			}	
		}
		
		Event action = new Event();
		
		//criando os panels para estruturar as ï¿½reas na tela 
		pCadastro = new JPanel();
		pCadastro.setSize(610,210);
		pCadastro.setLocation(10,10);
		pCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro de cliente:"));
		pCadastro.setLayout(null);
		
		pBusca = new JPanel();
		pBusca.setSize(610,110);
		pBusca.setLocation(10,230);
		pBusca.setBorder(BorderFactory.createTitledBorder("Busca e Exclusão"));
		pBusca.setLayout(null);
		
		//adicionando os labels	e text fields
		
		lNome = new JLabel("Nome Completo: ");
		lNome.setSize(150,30);
		lNome.setLocation(20,20);
		
		tNome = new JTextField();
		tNome.setSize(400,20);
		tNome.setLocation(120,25);
		
		lCpf = new JLabel("CPF: ");
		lCpf.setSize(150,30);
		lCpf.setLocation(20,50);
		
		tCpf = new JTextField();
		tCpf.setSize(120,20);
		tCpf.setLocation(70,55);
		
		lRg = new JLabel("RG: ");
		lRg.setSize(150,30);
		lRg.setLocation(210,50);
		
		tRg = new JTextField();
		tRg.setSize(120,20);
		tRg.setLocation(250,55);
		
		lCtps = new JLabel("CTPS: ");
		lCtps.setSize(150,30);
		lCtps.setLocation(20,80);
		
		tCtps = new JTextField();
		tCtps.setSize(120,20);
		tCtps.setLocation(70,85);
		
		lSalario = new JLabel("Salário: ");
		lSalario.setSize(150,30);
		lSalario.setLocation(210,80);
		
		tSalario = new JTextField();
		tSalario.setSize(170,20);
		tSalario.setLocation(270,85);
		
		lDtNascimento = new JLabel("Data de Nascimento: ");
		lDtNascimento.setSize(150,30);
		lDtNascimento.setLocation(20,110);
		
		tDtNascimento = new JTextField();
		tDtNascimento.setSize(120,20);
		tDtNascimento.setLocation(150,115);
		
		lDtContratacao = new JLabel("Data de Contratação: ");
		lDtContratacao.setSize(150,30);
		lDtContratacao.setLocation(20,140);
		
		tDtContratacao = new JTextField();
		tDtContratacao.setSize(120,20);
		tDtContratacao.setLocation(150,145);
		
		lGenero = new JLabel("Gênero: ");
		lGenero.setSize(50,30);
		lGenero.setLocation(20,170);
		
		tGenero = new JTextField();
		tGenero.setSize(15,20);
		tGenero.setLocation(70,175);
		
		lCpfBusca = new JLabel("CPF: ");
		lCpfBusca.setSize(50,30);
		lCpfBusca.setLocation(20,20);
		
		tCpfBusca = new JTextField();
		tCpfBusca.setSize(120,20);
		tCpfBusca.setLocation(50,25);
		
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
		
		//acrescentando os componentes tela
		this.add(pCadastro);
		pCadastro.add(lNome);
		pCadastro.add(tNome);
		
		pCadastro.add(lCpf);
		pCadastro.add(tCpf);
		
		pCadastro.add(lRg);
		pCadastro.add(tRg);
		
		pCadastro.add(lCtps);
		pCadastro.add(tCtps);
		
		pCadastro.add(lSalario);
		pCadastro.add(tSalario);
		
		pCadastro.add(lDtNascimento);
		pCadastro.add(tDtNascimento);
		
		pCadastro.add(lDtContratacao);
		pCadastro.add(tDtContratacao);
		
		pCadastro.add(lGenero);
		pCadastro.add(tGenero);
		
		pCadastro.add(bSalvar);
		pCadastro.add(bLimpar);
		
		this.add(pBusca);
		pBusca.add(lCpfBusca);
		pBusca.add(tCpfBusca);
		pBusca.add(bBuscar);
		pBusca.add(bExcluir);
		pBusca.add(bLimparCpf);
		
		this.add(bFechar);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.repaint();
	}
}
