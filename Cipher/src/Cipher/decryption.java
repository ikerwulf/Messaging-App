package Cipher;
//Decryption algorithms and UI

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// Create specified intervals for decryption at 2, 3, 5, 10, and 20
//
public class decryption extends JPanel implements ActionListener
{
	protected JTextField textField;
	protected JTextArea encryptArea;
	public String encryption;
	//Random random = new Random();
	
	private char inp; 
	private int conv;
	
	public char
	getCharfromString(String str, int index)
	{
		return str.charAt(index); 
	}
	
	// create specified intervals; add interval char to end of key string; Parse 
	public void decryptionTextField()
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
	
	public void decrypting(String t, String k) 
	{
		//String text = textField.getText();
		String encM = "";
		int key;
	
		try
		{
			for(int i = 0; i < t.length(); ++i)
			{
				
				inp = getCharfromString(k, i);
				key = inp;
				//key = key + conv;
				inp = getCharfromString(t, i);
				conv = inp;
				conv = conv - key;
				inp = (char)conv;
				encM = encM + inp;
				//System.out.println(conv);
				//System.out.println(key);
			}
			System.out.println(encM);
			
		}
		catch(StringIndexOutOfBoundsException e)
		{
			System.out.println("String Index is OoB");
			
		}
		
	//@Override
	
		
	}
	
	public void decrypt()
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
