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
        JMenuItem menu1Item1 = new JMenuItem("Cadastrar Animal");
        menu1Item1.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item1.setMnemonic(KeyEvent.VK_A);
        menu1Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        menu1Item1.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"CadastrarAnimal"); }
        });

        // Op��es do Menu Cadastros B�sicos
        // Op��o 2 - Consultar
        JMenuItem menu1Item2 = new JMenuItem("Cadastrar Cliente");
        menu1Item2.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item2.setMnemonic(KeyEvent.VK_C);
        menu1Item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        menu1Item2.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"CadastrarCliente"); }
        });
        
        JMenuItem menu1Item3 = new JMenuItem("Cadastrar Funcion�rio");
        menu1Item3.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item3.setMnemonic(KeyEvent.VK_F);
        menu1Item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
        menu1Item3.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"CadastrarFuncionario"); }
        });
        
        JMenuItem menu1Item4 = new JMenuItem("Agendar Consulta");
        menu1Item4.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item4.setMnemonic(KeyEvent.VK_J);
        menu1Item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.CTRL_MASK));
        menu1Item4.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"AgendarConsulta"); }
        });
 
        // Op��es do Menu Cadastros B�sicos
        // Op��o 5 - Sair
        JMenuItem menu1Item5 = new JMenuItem("Sair");
        menu1Item5.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item5.setMnemonic(KeyEvent.VK_F4);
        menu1Item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK));
        menu1Item5.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"Sair"); }
        });

        // Adiciona os itens criados ao Menu Cadastros B�sicos
        menu1.add(menu1Item1);
        menu1.add(menu1Item2);
        menu1.add(menu1Item3);
        menu1.addSeparator();
        menu1.add(menu1Item4);
        menu1.addSeparator();
        menu1.add(menu1Item5);


        //Cria o Menu de Banco de dados
        JMenu menu2 = new JMenu("Banco de Dados");
        menu2.setMnemonic(KeyEvent.VK_D);
        menu2.setFont(new Font ("Arial", Font.PLAIN, 11));
        
        //Op��es do Menu Banco de Dados
        //Op��o 1 - Login e Senha
        JMenuItem menu2Item1 = new JMenuItem("Login & Senha");
        menu2Item1.setFont(new Font("Arial", Font.PLAIN, 11));
        menu2Item1.setMnemonic(KeyEvent.VK_D);
        menu2Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        menu2Item1.addActionListener(
      		  new ActionListener()
      	      { 
      			  public void actionPerformed(ActionEvent e)
      			  { 
      				  chamaMetodo(e,"LoginDataBase"); 
      			  }
      	      }
        );
        
        menu2.add(menu2Item1);
        
        // Cria o Menu Ajuda na Barra de Menu

        JMenu menu3 = new JMenu("Ajuda");
        menu3.setMnemonic(KeyEvent.VK_U);
        menu3.setFont(new Font ("Arial",Font.PLAIN,11));

        // Op�oes do Menu Ajuda
        // Op��o 1 - Sobre
        JMenuItem menu3Item1 = new JMenuItem("Sobre");
        menu3Item1.setFont(new Font("Arial", Font.PLAIN,11));
        menu3Item1.setMnemonic(KeyEvent.VK_H);
        menu3Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
        menu3Item1.addActionListener(
		  new ActionListener()
	      { 
			  public void actionPerformed(ActionEvent e)
			  { 
				  chamaMetodo(e,"Sobre"); 
			  }
	      }
    	);
     
      // Adiciona os itens criados ao Menu Ajuda
      menu3.add(menu3Item1); // Item Sobre

      // Adiciona os Menus � Barra de Menu
      BMenu.add(menu1); // Cadastros B�sicos
      BMenu.add(menu2);
      BMenu.add(menu3); // Ajuda

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
