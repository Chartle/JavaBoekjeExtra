package voorbeeldDelen;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Deel8 extends Applet implements ActionListener
{
	Button knop;
	TextField tekstvak;
	int aantalOgen;
	
	public void init()
	{
		knop = new Button("Gooi");
		add(knop);
		knop.addActionListener(this);
		
		tekstvak = new TextField(12);
		add(tekstvak);
	}
	
	public void paint(Graphics g)
	{
		tekenDobbelsteen(g, aantalOgen);
	}
	public int worp()
	{
		double t;
		t = Math.random();
		t*=6;
		t+=1;
		aantalOgen = (int) t;
		return aantalOgen;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == knop)
		{
			aantalOgen = worp();
			tekstvak.setText("Aantal ogen = " + aantalOgen);
		}
		repaint();
	}
	
	public void tekenDobbelsteen(Graphics g, int aantalOgen)
	{
		g.drawRoundRect(75, 50, 50, 50, 20, 20);
		switch (aantalOgen)
		{
		case 1:
			g.fillOval(96,71,8,8);
			break;
		case 2:
			g.fillOval(83,56,8,8);
			g.fillOval(110,86,8,8);
			break;
		case 3:
			g.fillOval(83,86,8,8);
			g.fillOval(96,71,8,8);
			g.fillOval(110,56,8,8);
			break;
		case 4:
			g.fillOval(83,56,8,8);
			g.fillOval(83,86,8,8);			
			g.fillOval(110,56,8,8);
			g.fillOval(110,86,8,8);
			break;
		case 5:
			g.fillOval(83,56,8,8);
			g.fillOval(83,86,8,8);	
			g.fillOval(96,71,8,8);
			g.fillOval(110,56,8,8);
			g.fillOval(110,86,8,8);
			break;
		case 6:
			g.fillOval(83,56,8,8);
			g.fillOval(83,86,8,8);	
			g.fillOval(83,71,8,8);
			g.fillOval(110,56,8,8);
			g.fillOval(110,86,8,8);	
			g.fillOval(110,71,8,8);
			break;
		}
	}	
}
