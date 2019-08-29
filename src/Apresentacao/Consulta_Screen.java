package Apresentacao;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Consulta_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lData, lHora, lNomeVeterinario, lNomeAnimal, lCpfCliente, lSintomas, lDiagnostico;
	private JTextField tData, tHora, tNomeVeterinario, tNomeAnimal, tCpfCliente, tSintomas, tDiagnostico;
	private JButton bMarcar, bLimpar, bListar, bBuscar, bExcluir, bEditar, bCancelar, bLimparCpf;
	private JPanel pFormulario, pBusca;
	
	String data, hora, nomeVeterinario, nomeAnimal, cpfCliente, sintomas, diagnostico;
	Consulta objCon, objSalvar;
	
	public Consulta_Screen()
	{
		this.setSize(630, 460);
		this.setTitle("Marcar Consulta");
		this.setResizable(false);
		this.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Clinica_Veterinaria/src/Images/agendamento_icone.png");
		this.setIconImage(img);
		
		class Event extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == bMarcar) {					
					data = tData.getText();
					hora = tHora.getText();
					nomeVeterinario = tNomeVeterinario.getText();
					nomeAnimal = tNomeAnimal.getText();
					cpfCliente = tCpfCliente.getText();
					sintomas = tSintomas.getText();
					diagnostico = tDiagnostico.getText();
					objSalvar = new Consulta(data, hora, nomeVeterinario, nomeAnimal, cpfCliente, sintomas, diagnostico);	
					objSalvar.incluir();
					dispose();
				}
				
				if (e.getSource() == bLimpar) {
					tData.setText("");
					tHora.setText("");
					tNomeVeterinario.setText("");
					tNomeAnimal.setText("");
					tSintomas.setText("");
					tDiagnostico.setText("");
				}
				
				if (e.getSource() == bLimparCpf) {
					//
				}
				
//				if (e.getSource() == bListar) {	
//					JOptionPane.showMessageDialog(null, message);
//				}
				
				if (e.getSource() == bBuscar) {
					/*cpfBusca = tCpfBusca.getText();
					objCli = new Cliente(cpfBusca);
					objCli.buscar(true);*/
				}
				
				if (e.getSource() == bExcluir) {
					/*cpfBusca = tCpfBusca.getText();
					objCli = new Cliente(cpfBusca);
					objCli.excluir(objCli);*/
				}
				
//				if (e.getSource() == bEditar) {
//					nome = tNome.getText();
//					cpf = tCpf.getText();
//					telefone = tTelefone.getText();
//					email = tEmail.getText();
//					objCli = new Cliente(nome,cpf,telefone, email);	
//					objCli.alterar(objCli);
//				}
				
				if (e.getSource() == bCancelar) {
					dispose(); 
				}
			}	
		}
		
		Event action = new Event();
		
		pFormulario = new JPanel();
		pFormulario.setSize(610,230);
		pFormulario.setLocation(10,10);
		pFormulario.setBorder(BorderFactory.createTitledBorder("Formulário de Consulta:"));
		pFormulario.setLayout(null);
		
		pBusca = new JPanel();
		pBusca.setSize(610,110);
		pBusca.setLocation(10,250);
		pBusca.setBorder(BorderFactory.createTitledBorder("Busca e Exclusão"));
		pBusca.setLayout(null);
		
		lData = new JLabel("Data da Consulta: ");
		lData.setSize(150,30);
		lData.setLocation(70,20);
		
		tData = new JTextField();
		tData.setSize(90,20);
		tData.setLocation(190,25);
		
		lHora = new JLabel("Hora da Consulta: ");
		lHora.setSize(150,30);
		lHora.setLocation(290,20);
		
		tHora = new JTextField();
		tHora.setSize(70,20);
		tHora.setLocation(410,25);
		
		lNomeVeterinario = new JLabel("CPF do Veterinario: ");
		lNomeVeterinario.setSize(150,30);
		lNomeVeterinario.setLocation(70,50);
		
		tNomeVeterinario = new JTextField();
		tNomeVeterinario.setSize(270,20);
		tNomeVeterinario.setLocation(210,55);
		
		lNomeAnimal = new JLabel("Nome do Animal: ");
		lNomeAnimal.setSize(150,30);
		lNomeAnimal.setLocation(20,80);
		
		tNomeAnimal = new JTextField();
		tNomeAnimal.setSize(190,20);
		tNomeAnimal.setLocation(130,85);
		
		lCpfCliente = new JLabel("CPF do Cliente: ");
		lCpfCliente.setSize(150,30);
		lCpfCliente.setLocation(350,80);
		
		tCpfCliente = new JTextField();
		tCpfCliente.setSize(90,20);
		tCpfCliente.setLocation(460,85);
		
		lSintomas = new JLabel("Sintomas: ");
		lSintomas.setSize(150,30);
		lSintomas.setLocation(70,110);
		
		tSintomas = new JTextField();
		tSintomas.setSize(270,20);
		tSintomas.setLocation(210,115);
		
		lDiagnostico = new JLabel("Diagnóstico: ");
		lDiagnostico.setSize(150,30);
		lDiagnostico.setLocation(70,140);
		
		tDiagnostico = new JTextField();
		tDiagnostico.setSize(270,20);
		tDiagnostico.setLocation(210,145);
		
		/*BOTÕES*/
		bMarcar = new JButton("Marcar");
		bMarcar.setSize(85,30);
		bMarcar.setLocation(160,190);
		bMarcar.setForeground(Color.white);
		bMarcar.setBackground(Color.gray);
		bMarcar.addMouseListener(action);
		
		bLimpar = new JButton("Limpar");
		bLimpar.setSize(85,30);
		bLimpar.setLocation(265,190);
		bLimpar.setForeground(Color.white);
		bLimpar.setBackground(Color.gray);
		bLimpar.addMouseListener(action);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setSize(85,30);
		bCancelar.setLocation(370,190);
		bCancelar.setForeground(Color.white);
		bCancelar.setBackground(Color.gray);
		bCancelar.addMouseListener(action);
		
		pFormulario.add(lData);
		pFormulario.add(tData);
		
		pFormulario.add(lHora);
		pFormulario.add(tHora);
		
		pFormulario.add(lNomeVeterinario);
		pFormulario.add(tNomeVeterinario);
		
		pFormulario.add(lNomeAnimal);
		pFormulario.add(tNomeAnimal);
		
		pFormulario.add(lCpfCliente);
		pFormulario.add(tCpfCliente);
		
		pFormulario.add(lSintomas);
		pFormulario.add(tSintomas);
		
		pFormulario.add(lDiagnostico);
		pFormulario.add(tDiagnostico);
		
		pFormulario.add(bMarcar);
		pFormulario.add(bLimpar);
		pFormulario.add(bCancelar);
		
		this.add(pFormulario);
		this.add(pBusca);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.repaint();
	}
}
