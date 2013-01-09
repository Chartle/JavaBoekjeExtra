package main;

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
	public JButton next, previous, codeTab, resultsTab;
	public JTextArea infoText, codeText;
	public JPanel resultPanel, horDivider, vertDivider;
	public int deelNum = 1;
	public boolean seeCode = true;
	
	
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
		infoText.setBounds(20, 120, 380, 625);
		infoText.setEditable(false);
		window.add(infoText);
		
		codeText = new JTextArea();
		codeText.setBounds(445,120,520,625);
		window.add(codeText);
		
		resultPanel = new JPanel();
		resultPanel.setBounds(445,120,520,625);
		resultPanel.setBackground(Color.WHITE);
		resultPanel.setVisible(false);
		window.add(resultPanel);
		
		codeTab = new JButton("Code");
		codeTab.setBounds(560, 40, 90, 60);
		window.add(codeTab);
		codeTab.addActionListener(this);
		
		resultsTab = new JButton("Results");
		resultsTab.setBounds(660, 40, 90, 60);
		window.add(resultsTab);
		resultsTab.addActionListener(this);
		drawStuff();
	}
	
	public void drawStuff()
	{
		codeText.setText("");
		if(seeCode)
		{
			codeText.setVisible(true);
			resultPanel.setVisible(false);
		}
		else
		{
			codeText.setVisible(false);
			resultPanel.setVisible(true);
		}
		switch(deelNum)
		{
			case 1:
				infoText.setText("1");
				codeText.setText("1");
				break;
				
			case 2:
				infoText.setText("2");
				codeText.setText("2");
				break;

			case 3:
				infoText.setText("3");
				codeText.setText("3");
				break;

			case 4:
				infoText.setText("4");
				codeText.setText("4");
				break;

			case 5:
				infoText.setText("5");
				codeText.setText("5");
				break;

			case 6:
				infoText.setText("6");
				codeText.setText("6");
				break;

			case 7:
				infoText.setText("7");
				codeText.setText("7");
				break;

			case 8:
				infoText.setText("8");
				codeText.setText("8");
				break;
		}
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
		}
		if(source == previous)
		{
			if(deelNum < 2)
				deelNum = 8;
			else
				deelNum--;
		}
		if(source == codeTab)
		{
			seeCode = true;
		}
		if(source == resultsTab)
		{
			seeCode = false;
		}		
		drawStuff();
	}
}
