package Apresentacao;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cirurgia_Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lData, lHora, lNomeVeterinario, lNomeAnimal, lCpfCliente, lUrgencia, lSituacao, lDuracao, lDtBusca, lHrBusca;
	private JTextField tData, tHora, tNomeVeterinario, tNomeAnimal, tCpfCliente, tUrgencia, tSituacao, tDuracao, tDtBusca, tHrBusca;
	private JButton bMarcar, bLimpar, bListar, bBuscar, bExcluir, bEditar, bCancelar, bLimparDtHr;
	private JPanel pFormulario, pBusca;
	
	String data, hora, nomeVeterinario, nomeAnimal, cpfCliente, situacao, dtBusca, hrBusca;
	int urgencia, duracao;
	Cirurgia objCir, objSalvar;
	
	public Cirurgia_Screen()
	{
		this.setSize(630, 460);
		this.setTitle("Marcar Cirurgia");
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
					urgencia = Integer.parseInt(tUrgencia.getText());
					situacao = tSituacao.getText();
					duracao = Integer.parseInt(tDuracao.getText());
					objSalvar = new Cirurgia(data, hora, nomeVeterinario, nomeAnimal, cpfCliente, urgencia, situacao, duracao);	
					objSalvar.incluir();
					dispose();
				}
				
				if (e.getSource() == bLimpar) {
					tData.setText("");
					tHora.setText("");
					tNomeVeterinario.setText("");
					tNomeAnimal.setText("");
					tUrgencia.setText("");
					tSituacao.setText("");
					tDuracao.setText("");
				}
				
				if (e.getSource() == bLimparDtHr) {
					tDtBusca.setText("");
					tHrBusca.setText("");
				}
				
				if (e.getSource() == bBuscar) {
					dtBusca = tDtBusca.getText();
					hrBusca = tHrBusca.getText();
					objCir = new Cirurgia(dtBusca, hrBusca);
					objCir.buscar();
				}
				
				if (e.getSource() == bExcluir) 
				{
					dtBusca = tDtBusca.getText();
					hrBusca = tHrBusca.getText();
					objCir = new Cirurgia(dtBusca, hrBusca);
					objCir.excluir();
				}
				
				if (e.getSource() == bCancelar) {
					dispose(); 
				}
			}	
		}
		
		Event action = new Event();
		
		pFormulario = new JPanel();
		pFormulario.setSize(610,230);
		pFormulario.setLocation(10,10);
		pFormulario.setBorder(BorderFactory.createTitledBorder("Formulário de Cirurgia:"));
		pFormulario.setLayout(null);
		
		pBusca = new JPanel();
		pBusca.setSize(610,110);
		pBusca.setLocation(10,250);
		pBusca.setBorder(BorderFactory.createTitledBorder("Busca e Exclusão"));
		pBusca.setLayout(null);
		
		lData = new JLabel("Data da Cirurgia: ");
		lData.setSize(150,30);
		lData.setLocation(70,20);
		
		tData = new JTextField();
		tData.setSize(90,20);
		tData.setLocation(190,25);
		
		lHora = new JLabel("Hora da Cirurgia: ");
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
		
		lUrgencia = new JLabel("Grau de Urgência: ");
		lUrgencia.setSize(150,30);
		lUrgencia.setLocation(70,110);
		
		tUrgencia = new JTextField();
		tUrgencia.setSize(270,20);
		tUrgencia.setLocation(210,115);
		
		lSituacao = new JLabel("Situação: ");
		lSituacao.setSize(150,30);
		lSituacao.setLocation(20,140);
		
		tSituacao = new JTextField();
		tSituacao.setSize(210,20);
		tSituacao.setLocation(90,145);
		
		lDuracao = new JLabel("Duração: ");
		lDuracao.setSize(150,30);
		lDuracao.setLocation(320,140);
		
		tDuracao = new JTextField();
		tDuracao.setSize(100,20);
		tDuracao.setLocation(390,145);
		
		lDtBusca = new JLabel("Data da Cirurgia: ");
		lDtBusca.setSize(150, 30);
		lDtBusca.setLocation(30, 20);
		
		tDtBusca = new JTextField();
		tDtBusca.setSize(90, 20);
		tDtBusca.setLocation(150, 25);
		
		lHrBusca = new JLabel("Hora da Cirurgia: ");
		lHrBusca.setSize(150, 30);
		lHrBusca.setLocation(270, 20);
		
		tHrBusca = new JTextField();
		tHrBusca.setSize(90, 20);
		tHrBusca.setLocation(390, 25);
		
		
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
		
		bBuscar = new JButton("Buscar");
		bBuscar.setSize(85,30);
		bBuscar.setLocation(160, 70);
		bBuscar.setForeground(Color.white);
		bBuscar.setBackground(Color.gray);
		bBuscar.addMouseListener(action);
		
		bLimparDtHr = new JButton("Limpar");
		bLimparDtHr.setSize(85,30);
		bLimparDtHr.setLocation(265, 70);
		bLimparDtHr.setForeground(Color.white);
		bLimparDtHr.setBackground(Color.gray);
		bLimparDtHr.addMouseListener(action);
		
		bExcluir = new JButton("Excluir");
		bExcluir.setSize(85,30);
		bExcluir.setLocation(370, 70);
		bExcluir.setForeground(Color.white);
		bExcluir.setBackground(Color.gray);
		bExcluir.addMouseListener(action);
		
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
		
		pFormulario.add(lUrgencia);
		pFormulario.add(tUrgencia);
		
		pFormulario.add(lSituacao);
		pFormulario.add(tSituacao);
		
		pFormulario.add(lDuracao);
		pFormulario.add(tDuracao);
		
		pFormulario.add(bMarcar);
		pFormulario.add(bLimpar);
		pFormulario.add(bCancelar);
		
		this.add(pFormulario);
		
		pBusca.add(lDtBusca);
		pBusca.add(tDtBusca);
		
		pBusca.add(lHrBusca);
		pBusca.add(tHrBusca);
		
		pBusca.add(bBuscar);
		pBusca.add(bLimparDtHr);
		pBusca.add(bExcluir);
		
		this.add(pBusca);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.repaint();
	}
}
