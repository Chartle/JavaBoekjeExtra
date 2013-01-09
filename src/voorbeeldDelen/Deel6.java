package voorbeeldDelen;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Deel6 extends Applet implements ActionListener
{
	TextField inputField, outputField;
	Button knop;
	
	public void init()
	{
		setLayout(null);
		inputField = new TextField();
		inputField.setBounds(50, 50, 90, 20);
		add(inputField);
		
		knop = new Button("Calculate costs");
		knop.setBounds(50, 80, 90, 20);
		add(knop);
		knop.addActionListener(this);
		
		outputField = new TextField();
		outputField.setBounds(50, 110, 90, 20);
		add(outputField);
	}
	
	public void paint(Graphics g)
	{
		g.drawString("Input the amount of pens", 30, 35);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		double price;
		int pens = Integer.parseInt(inputField.getText());
		if(pens < 10)
			price = 2.00;
		else if(pens < 50)
			price = 1.50;
		else if(pens < 100)
			price = 1.25;
		else
			price = 1.00;
		String finalPrice = Double.toString(price*pens);
		if(finalPrice.length() <= 4)
			finalPrice = finalPrice + "0";
		outputField.setText("$" + finalPrice);			
	}
}
