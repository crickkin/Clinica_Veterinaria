package Apresentacao;

import javax.swing.JToolBar;

public class Tool_Bar 
{
	//TODO Implementar Barra de Ferramentas
	Object gui;
	
	public JToolBar create()
	{
		JToolBar barraFerramenta = new JToolBar();
		barraFerramenta.setFloatable(true);
		
		
		return barraFerramenta;
	}
}