package Cipher;
//Encryption algorithms and UI

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class encryption extends JPanel implements ActionListener 
{
	protected JTextField textField;
	protected JTextArea encryptArea;
	public String encryption;
	Random random = new Random();
	
	private char inp; 
	private int conv;
	/*
	 * private int a = 'a'; private int b = 'b'; private int c = 'c'; private int d
	 * = 'd'; private int e = 'e'; private int f = 'f'; private int g = 'g'; private
	 * int h = 'h'; private int i = 'i'; private int j = 'j'; private int k = 'k';
	 * private int l = 'l'; private int m = 'm'; private int n = 'n'; private int o
	 * = 'o'; private int p = 'p'; private int q = 'q'; private int r = 'r'; private
	 * int s = 's'; private int t = 't'; private int u = 'u'; private int v = 'v';
	 * private int w = 'w'; private int x = 'x'; private int y = 'y'; private int z
	 * = 'z'; private int a1 = ' '; private int p1 = '.'; private int p2 = ',';
	 * private int p3 = '?'; private int p4 = '!'; private int parO = '('; private
	 * int parC = ')'; private int at = '@'; private int hsh = '#'; private int dol
	 * = '$'; private int carU = '^'; private int carL = '<'; private int carR =
	 * '>'; private int perc = '%'; private int and = '&'; private int star = '*';
	 * private int min = '-'; private int pls = '+'; private int eq = '='; private
	 * int apost = '\'';
	 */
	 
	
	public char
	getCharfromString(String str, int index)
	{
		return str.charAt(index); 
	}
	
	// create specified intervals; add interval char to end of key string; Parse 
	public void encryptionTextField()
	{
		textField = new JTextField(20);
		textField.addActionListener(this);
		JScrollPane scrollPane = new JScrollPane(textField);	
		
		//Panel Components
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		add(textField, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		add(scrollPane, c);
	}
	
	public void encrypting(String t) 
	{
		//String text = textField.getText();
		String newM = "";
		String key = "";
	
		try
		{
			for(int i = 0; i < t.length(); ++i)
			{
				int rando = random.nextInt(255);
				inp = (char)rando;
				key = key + inp;
				inp = getCharfromString(t, i);
				conv = inp + rando;
				inp = (char)conv;
				newM = newM + inp;
				System.out.println(rando);
				
			}
			System.out.println(newM);
			System.out.println(key);
		}
		catch(StringIndexOutOfBoundsException e)
		{
			System.out.println("String Index is OoB");
			
		}
		
	
	/*String test = " Th!s !s a test";
	int index = 2;
	char t = getCharfromString(test, index);
	
	System.out.println(char);
	*/

	//@Override
	
		
	}
	
	public void encrypt()
	{
		
		
		
		/*JFrame frame = new JFrame("encrypt");
	      frame.setSize(600, 400);    
	      frame.setLocation(0, 0);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      encryption e = new encryption();
	      frame.setContentPane(e);
	      e.requestFocus();
	      frame.setVisible(true);
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
