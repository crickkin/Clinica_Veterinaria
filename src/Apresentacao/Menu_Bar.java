package Apresentacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Menu_Bar
{
	Object gui;

    public JMenuBar create()
    {           
        JMenuBar BMenu = new JMenuBar();

        // Cria o Menu Gerenciamentos B�sicos na Barra de Menu
        JMenu menu1 = new JMenu("Atividades");
        menu1.setMnemonic(KeyEvent.VK_G); // Sublinha a letra C do Menu Cadastros B�sicos
        menu1.setFont(new Font ("Arial",Font.PLAIN,11));

        // Op��es do Menu Gerenciamentos B�sicos
        // Op��o 1 - Pessoa F�sica
        JMenuItem menu1Item1 = new JMenuItem("Cadastrar");
        menu1Item1.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item1.setMnemonic(KeyEvent.VK_F);
        menu1Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
        menu1Item1.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jPFisica"); }
        });

        // Op��es do Menu Cadastros B�sicos
        // Op��o 2 - Pessoa Jur�dica
        JMenuItem menu1Item2 = new JMenuItem("Consultar");
        menu1Item2.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item2.setMnemonic(KeyEvent.VK_J);
        menu1Item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.CTRL_MASK));
        menu1Item2.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jPJuridica"); }
        });
 
        // Op��es do Menu Cadastros B�sicos
        // Op��o 3 - Sair
        JMenuItem menu1Item3 = new JMenuItem("Sair");
        menu1Item3.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item3.setMnemonic(KeyEvent.VK_F4);
        menu1Item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK));
        menu1Item3.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSair"); }
        });

        // Adiciona os itens criados ao Menu Cadastros B�sicos
        menu1.add(menu1Item1);  // Item Pessoa F�sica
        menu1.add(menu1Item2);  // Item Pessoa Jur�dica
        menu1.addSeparator();   // Separador
        menu1.add(menu1Item3); // Item Sair


      // Cria o Menu Ajuda na Barra de Menu
      JMenu menu2 = new JMenu("Ajuda");
      menu2.setMnemonic(KeyEvent.VK_U);
      menu2.setFont(new Font ("Arial",Font.PLAIN,11));

      // Op�oes do Menu Ajuda
      // Op��o 1 - Sobre
      JMenuItem menu2Item1 = new JMenuItem("Sobre");
      menu2Item1.setFont(new Font("Arial", Font.PLAIN,11));
      menu2Item1.setMnemonic(KeyEvent.VK_A);
      menu2Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
      menu2Item1.addActionListener(
    		  new ActionListener()
		      { 
    			  public void actionPerformed(ActionEvent e)
    			  { 
    				  chamaMetodo(e,"jSobre"); 
				  }
		      }
	  );
     
      // Adiciona os itens criados ao Menu Ajuda
      menu2.add(menu2Item1); // Item Sobre

      // Adiciona os Menus � Barra de Menu
      BMenu.add(menu1); // Cadastros B�sicos
      BMenu.add(menu2); // Ajuda

      return BMenu;
    }

	//********************************************
	//M�todo gen�rico para chamada autom�tica dos
	//m�todos vinculados aos itens de menu
	//********************************************
    public void add(Object gui)
    { this.gui  = gui; }

    private void chamaMetodo(ActionEvent e, String xMetodo)
    {   Method metodo;
        try
        {   
        	metodo = gui.getClass().getMethod(xMetodo, null);
            metodo.invoke(gui, null);
        }
        catch (NoSuchMethodException nsme)
        { JOptionPane.showMessageDialog(null, "Metodo n�o definido para este evento/menu - ERR1"); }
        catch (IllegalAccessException iae)
        {JOptionPane.showMessageDialog(null, "Metodo n�o definido para este evento/menu - ERR2"); }
        catch (InvocationTargetException ite)
        {   ite.getTargetException().printStackTrace();
            JOptionPane.showMessageDialog(null, "Metodo n�o definido para este evento/menu - ERR3");
        }
    }
}