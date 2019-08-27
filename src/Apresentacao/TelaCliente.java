package Apresentacao;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaCliente extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lNome, lCpf, lTelefone, lEmail, lCpfBusca;
	private JTextField tNome, tCpf, tTelefone, tEmail, tCpfBusca;
	private JButton bSalvar, bLimpar, bListar, bBuscar, bExcluir, bEditar, bFechar, bLimparCpf;
	private JPanel pCadastro, pBusca;

	String cpf, nome, telefone, email, cpfBusca;
	Cliente objCli, objSalvar;
	
	public TelaCliente()
	{
		this.setSize(630,440);
		this.setTitle("Tela de Gerenciamento de Cliente");
		this.setResizable(false);
		this.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Clinica_Veterinaria/src/Images/cliente_icone_preto.jpg");
		this.setIconImage(img);
		
		//criando classe interna para funcionar como ouvinte dos eventos de mouse
		class Event extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == bSalvar) {					
					nome = tNome.getText();
					cpf = tCpf.getText();
					telefone = tTelefone.getText();
					email = tEmail.getText();
					objSalvar = new Cliente(nome,cpf,telefone, email);	
					objSalvar.incluir(objSalvar);
					dispose();
				}
				
				if (e.getSource() == bLimpar) {
					tNome.setText("");
					tCpf.setText("");
					tTelefone.setText("");
					tEmail.setText("");
				}
				
				if (e.getSource() == bLimparCpf) {
					tCpfBusca.setText("");
				}
				
//				if (e.getSource() == bListar) {	
//					JOptionPane.showMessageDialog(null, message);
//				}
				
				if (e.getSource() == bBuscar) {
					cpfBusca = tCpfBusca.getText();
					objCli = new Cliente(cpfBusca);
					objCli.buscar();
				}
				
				if (e.getSource() == bExcluir) {
					cpfBusca = tCpfBusca.getText();
					objCli = new Cliente(cpfBusca);
					objCli.excluir(objCli);
				}
				
//				if (e.getSource() == bEditar) {
//					nome = tNome.getText();
//					cpf = tCpf.getText();
//					telefone = tTelefone.getText();
//					email = tEmail.getText();
//					objCli = new Cliente(nome,cpf,telefone, email);	
//					objCli.alterar(objCli);
//				}
				
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
		tNome.setLocation(190,25);
		
		lCpf = new JLabel("CPF: ");
		lCpf.setSize(150,30);
		lCpf.setLocation(20,50);
		
		tCpf = new JTextField();
		tCpf.setSize(120,20);
		tCpf.setLocation(190,55);
		
		lTelefone = new JLabel("Telefone: ");
		lTelefone.setSize(150,30);
		lTelefone.setLocation(20,80);
		
		tTelefone = new JTextField();
		tTelefone.setSize(120,20);
		tTelefone.setLocation(190,85);
		
		lEmail = new JLabel("Email: ");
		lEmail.setSize(150,30);
		lEmail.setLocation(20,110);
		
		tEmail = new JTextField();
		tEmail.setSize(400,20);
		tEmail.setLocation(190,115);
		
		lCpfBusca = new JLabel("CPF: ");
		lCpfBusca.setSize(50,30);
		lCpfBusca.setLocation(20,20);
		
		tCpfBusca = new JTextField();
		tCpfBusca.setSize(120,20);
		tCpfBusca.setLocation(90,25);

				
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
		pCadastro.add(lCpf);
		pCadastro.add(lTelefone);
		pCadastro.add(lEmail);
		pCadastro.add(tNome);
		pCadastro.add(tCpf);
		pCadastro.add(tTelefone);
		pCadastro.add(tEmail);
		
		pCadastro.add(bSalvar);
		pCadastro.add(bLimpar);
//		pCadastro.add(bEditar);
		
		this.add(pBusca);
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
