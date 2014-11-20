/*
 *MyGui.java 
 *@author Sean Hayes
 *18th Nov 2014
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyMenuGui extends JFrame {
	private	JMenuBar myBar;
	 
	 public MyMenuGui(){
	 	setTitle("Enter Detials");
		setSize(300, 300);
		setLocation(250, 250);
	
		
		createMenus();
	 } //end of constructor
	
	public static void main (String args[]){
		MyMenuGui mainGui = new MyMenuGui();
		mainGui.setVisible(true);
	}//main
	
	public void createMenus(){
		
		}
}