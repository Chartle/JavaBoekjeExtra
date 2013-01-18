package baseCode;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Path.*;
import voorbeeldDelen.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainClass extends JFrame implements ActionListener
{
	public JButton next, previous, saveButton, outputButton;
	public JTextArea infoText, codeText;
	public JPanel resultPanel, horDivider, vertDivider;
	public int deelNum = 1;
	public boolean loadedFile = true;
	readFile rf = new readFile();
	File file = new File(""), infoFile = new File("");
	String fileString = "", infoString = "";
	
	public static void main(String[] args)
	{
		MainClass demo = new MainClass();
		demo.setSize(1000,800);
		demo.setLayout(null);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	public void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(null);
		
		next = new JButton(">");
		next.setBounds(885, -1, 100, 101);
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
		
		resultPanel = new JPanel();
		resultPanel.setBounds(445,120,520,625);
		resultPanel.setBackground(Color.WHITE);
		resultPanel.setVisible(false);
		window.add(resultPanel);
		
		saveButton = new JButton("Save code");
		saveButton.setBounds(540, 40, 110, 60);
		window.add(saveButton);
		saveButton.addActionListener(this);
		
		outputButton = new JButton("Output");
		outputButton.setBounds(660, 40, 90, 60);
		window.add(outputButton);
		outputButton.addActionListener(this);
		drawStuff();
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
