package voorbeeldDelen;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Deel3 extends Applet implements ActionListener
{
	Button knop1, knop2, knop3;
	TextField textField;
	
	
	public void init()
	{
		setLayout(null);
		
		knop1 = new Button("Klik");
		knop1.setBounds(30, 75, 40, 20);
		knop1.addActionListener(this);
		add(knop1);
		knop2 = new Button("Klik");
		knop2.setBounds(80, 50, 40, 20);
		knop2.addActionListener(this);
		add(knop2);
		knop3 = new Button("Klik");
		knop3.setBounds(130, 100, 40, 20);
		knop3.addActionListener(this);
		add(knop3);
		
		textField = new TextField(10);
		textField.setBounds(60, 20, 90, 20);
		add(textField);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(new Color(200,15,183));
		g.fillRect(30, 180-75, 40, 75);
		g.setColor(new Color(14,51,177));
		g.fillRect(80, 180-100, 40, 100);
		g.setColor(new Color(111,156,171));
		g.fillRect(130, 180-50, 40, 50);
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, 180, 170);
		g.drawString("Appels", 24, 195);
		g.drawString("Pruimen", 80, 195);
		g.drawString("Peren", 137, 195);
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source == knop1)
		{
			textField.setText("150 appels");
		}
		if(source == knop2)
		{
			textField.setText("200 pruimen");
		}
		if(source == knop3)
		{
			textField.setText("100 peren");
		}
	}
}