package voorbeeldDelen;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Deel4 extends Applet implements ActionListener 
{
	Button knopGroter, knopKleiner;
	int diameter;
	
	public void init()
	{
		diameter = 10;
		knopGroter = new Button("Groter");
		knopGroter.addActionListener(this);
		add(knopGroter);
		
		knopKleiner = new Button("Kleiner");
		knopKleiner.addActionListener(this);
		add(knopKleiner);
	}
	
	public void paint(Graphics g)
	{
		g.drawString("Oppervlakte vijver = " + diameter*150, 40, 180);
		g.drawString("Oppervlakte gras = 7500", 40, 195);
		g.setColor(Color.GREEN);
		g.fillRect(getWidth()/2-25, getHeight()/2-25, 50, 50);
		g.setColor(Color.BLUE);
		g.fillRect(getWidth()/2-(diameter/2), getHeight()/2-(diameter/2), diameter, diameter);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == knopGroter)
		{
			diameter++;
			if(diameter > 50)
				diameter = 50;
			repaint();
		}
		
		if(source == knopKleiner)
		{
			diameter--;
			if(diameter < 0)
				diameter = 0;
			repaint();
		}
			
	}
}
