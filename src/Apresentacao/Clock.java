package Apresentacao;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Clock extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;

	Font font = new Font("Arial",Font.PLAIN,20);
    
    Graphics g;
    Date the_Date;
    Thread timer;
    String hora_final;

    public Clock()
    {   
    	this.setSize(130,45);
        start();
        g = getGraphics();
        the_Date = new Date();
    }

    public void start()
    {   if(timer ==null)
        {   
    		timer = new Thread(this);
            timer.start();
        }
    }

    public void stop()
    {   if(timer !=null)
        {   
    		timer.stop();
            timer = null;
        }
    }

    public void run()
    {   while(true)
        {   
    		the_Date = new Date();
            repaint();
            try{ Thread.sleep(500); }
            catch(InterruptedException e){}
        }
    }

    public void update(Graphics g)
    {   
    	the_Date = new Date();
        int horas   = the_Date.getHours();
        int minutos = the_Date.getMinutes();
        int segundos = the_Date.getSeconds();
        String hora_final;
        if (horas < 10)
          hora_final = "0" + horas;
        else
          hora_final = "" + horas;
        if (minutos < 10)
          hora_final += " : 0" + minutos;
        else
          hora_final += " : " + minutos;
        if (segundos < 10)
          hora_final += " : 0" + segundos;
        else
          hora_final += " : " + segundos;
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString(hora_final,20,20);
     }

     public void paint(Graphics g)
     {     
    	 super.paintComponent(g);
    	 update(g);
     }

     public Graphics getHora()
     { 
    	 return g;   
     }
}