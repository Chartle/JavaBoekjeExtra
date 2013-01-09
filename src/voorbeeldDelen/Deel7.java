package voorbeeldDelen;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Deel7 extends Applet implements ActionListener 
{
	TextField inpField;
	int num;
	boolean isCalced = false;
	
	public void init()
	{
		setLayout(null);
		inpField = new TextField();
		inpField.setBounds(55,10,90,20);
		add(inpField);
		inpField.addActionListener(this);
	}
	
	public void paint(Graphics g)
	{
		if(isCalced)
		for(int i = 1; i<=10 ; i++)
		{
			g.drawString(num + " x " + i + " = " + num*i, 35, (i*15 + 30));
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		num = Integer.parseInt(inpField.getText());
		inpField.setText("");
		isCalced = true;
		repaint();
	}
}
