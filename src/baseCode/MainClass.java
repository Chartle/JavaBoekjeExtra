package baseCode;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import voorbeeldDelen.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainClass extends JFrame implements ActionListener
{
	public JButton next, previous, saveButton, outputButton, viewButton;
	public JTextArea infoText, codeText;
	public JPanel resultPanel, horDivider, vertDivider;
	public int deelNum = 1;
	public boolean loadedFile = true, showingCode = true;
	readFile rf = new readFile();
	File file = new File(""), infoFile = new File("");
	String fileString = "", infoString = "";
	
	public static void main(String[] args)
	{
		MainClass demo = new MainClass();
		demo.setSize(1000,800);
		demo.setLayout(null);
		demo.createCodeGUI();
		demo.createSamenvGUI();
		demo.setVisible(true);
	}
	
	public void createCodeGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(null);
		
		next = new JButton(">");
		next.setBounds(893, -1, 100, 101);
		window.add(next);
		next.addActionListener(this);

		previous = new JButton("<");
		previous.setBounds(-1, -1, 101, 101);
		window.add(previous);
		previous.addActionListener(this);
		
		horDivider = new JPanel();
		horDivider.setBounds(0,99,1000,1);
		horDivider.setBackground(Color.BLACK);
		window.add(horDivider);
		
		vertDivider = new JPanel();
		vertDivider.setBounds(424,99,1,665);
		vertDivider.setBackground(Color.BLACK);
		window.add(vertDivider);	
		
		infoText = new JTextArea();
		JScrollPane infoScroll = new JScrollPane(infoText);
		infoScroll.setBounds(20, 120, 380, 625);
		infoText.setEditable(false);
		window.add(infoScroll);
		
		codeText = new JTextArea();
		JScrollPane codeScroll = new JScrollPane(codeText);
		codeScroll.setBounds(445,120,520,625);
		window.add(codeScroll);
		
		saveButton = new JButton("Save code");
		saveButton.setBounds(540, 40, 110, 60);
		window.add(saveButton);
		saveButton.addActionListener(this);
		
		outputButton = new JButton("Output");
		outputButton.setBounds(660, 40, 90, 60);
		window.add(outputButton);
		outputButton.addActionListener(this);
		
		viewButton = new JButton("Code en uitleg");
		viewButton.setBounds(400,40,130,60);
		window.add(viewButton);
		viewButton.addActionListener(this);
		
		drawStuff();
	}

	public void createSamenvGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(null);
		
		//stoof voor samenvattingdinges hier;
		drawStuff();
	}
	
	public void visibilize(int view)
	{
		switch(view)
		{
			case 1:
				next.setVisible(false);
				previous.setVisible(false);
				infoText.setVisible(false);
				codeText.setVisible(false);
				saveButton.setVisible(false);
				outputButton.setVisible(false);
				showingCode = false;
				viewButton.setText("Code en uitleg");
				break;
			
			case 2: 
				next.setVisible(true);
				previous.setVisible(true);
				infoText.setVisible(true);
				codeText.setVisible(true);
				saveButton.setVisible(true);
				outputButton.setVisible(true);
				showingCode = true;
				viewButton.setText("Samenvatting");
				break;
		}
	}
	
	public void drawStuff()
	{
		fileString = "src\\voorbeeldDelen\\Deel"+deelNum+".java";
		infoString = "src\\infoTexts\\Info"+deelNum+".txt";
		file = new File(fileString);
		infoFile = new File(infoString);
		String codeContent = rf.getContents(file);
		String infoContent = rf.getContents(infoFile);
	    if(loadedFile)
	    	System.out.println("Got contents: Deel " + deelNum + "!\n");	    	
		codeText.setText(codeContent);
		infoText.setText(infoContent);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(source == viewButton)
		{
			if(showingCode)
				visibilize(1);

			else if(showingCode == false)
				visibilize(2);
		}
		
		if(source == next)
		{
			if(deelNum > 7)
				deelNum = 1;
			else
				deelNum++;
			loadedFile = true;
		}
		if(source == previous)
		{
			if(deelNum < 2)
				deelNum = 8;
			else
				deelNum--;
			loadedFile = true;
		}

		if(source == saveButton)
		{
			try
			{
				loadedFile = false;
				System.out.println("Saved content:\n");
				rf.saveFile(file,codeText.getText());
			}
			catch(Exception err)
			{
				System.out.println("Save error!");
			}
		}
		if(source == outputButton)
		{
			//run applet code here
		}		
		drawStuff();
	}
}
