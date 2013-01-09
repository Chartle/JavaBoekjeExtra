package voorbeeldDelen;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Deel5 extends Applet implements ActionListener
{
	TextField invoerVeld1, invoerVeld2, uitvoerVeld;
	Button knop;
	
	public void init()
	{
		setLayout(null);
		invoerVeld1 = new TextField();
		invoerVeld1.setBounds(15,50,80,20);
		add(invoerVeld1);
		
		invoerVeld2 = new TextField();
		invoerVeld2.setBounds(100,50,80,20);
		add(invoerVeld2);
		
		knop = new Button("Calculate");
		knop.setBounds(50,80,90,20);
		add(knop);
		knop.addActionListener(this);
	
		uitvoerVeld = new TextField();
		uitvoerVeld.setBounds(50,110,90,20);
		add(uitvoerVeld);		
	}
	
	public void paint(Graphics g)
	{
		g.drawString("White breads", 20, 40);
		g.drawString("Brown breads", 100, 40);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int wPuntjes = Integer.parseInt(invoerVeld1.getText());
		int bPuntjes = Integer.parseInt(invoerVeld2.getText());
		int aanbW = wPuntjes/5;
		int aanbB = bPuntjes/5;
		int overW = wPuntjes%5;
		int overB = bPuntjes%5;
		double total = (aanbW*2.00) + (aanbB*2.50) + (overW*0.50) + (overB*0.60);
		uitvoerVeld.setText("Totaal: " + total + "0");
	}
}
