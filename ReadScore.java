import java.io.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
public class ReadScore{
	public static void main (String args[]) {
		
		JTextArea textArea = new JTextArea();
		Font font = new Font("monospaced",Font.PLAIN,12);
		textArea.setFont(font);
		
			textArea.append(String.format("%-25s\n\n","Score"));
			
	LinkedList <Topscore> myOtherScores = new LinkedList <Topscore>();
		
		
		try{
		
		File fscore = new File("myScore.dat");
		FileInputStream fis = new FileInputStream(fscore);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
	myOtherScores = (LinkedList<Topscore>) ois.readObject();
		}//end try
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}//end catch

	for(Topscore ts2 : myOtherScores){
		textArea.append(String.format("%-25s\n",ts2));
		System.out.println(ts2.toString());
		JOptionPane.showMessageDialog(null,textArea,"Formatted Data", 
		    	                          JOptionPane.INFORMATION_MESSAGE);
		
	}
		}
}