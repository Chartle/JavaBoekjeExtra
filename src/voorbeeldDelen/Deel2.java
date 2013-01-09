package voorbeeldDelen;

import java.applet.*;
import java.awt.*;

public class Deel2 extends Applet
{
	public void paint(Graphics g)
	{
		g.drawLine(50, 200, 50, 50);
		g.setColor(new Color(200,14,172));
		g.fillRect(50, 50, 100, 30);
		g.setColor(new Color(20,124,118));
		g.fillRect(50, 80, 100, 30);
		g.setColor(new Color(60,24,222));
		g.fillRect(50, 110, 100, 30);
		g.setColor(Color.BLACK);
		g.drawRect(50,50,100,90);
		g.drawLine(50, 80, 150, 80);
		g.drawLine(50, 110, 150, 110);
	}
}
