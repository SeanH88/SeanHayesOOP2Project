/*
 *FirstGui.java 
 *@author Sean Hayes
 *4th DEC 2014
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class FirstGui extends JFrame {
	
	//private  instance variable
		//drivers
		
	private	JButton playButton;
	private	JButton exitButton;
	private JLabel titleLabel;
//	private JLabel nameLabel;
	private	JMenuBar navBar;
//	private TextField nameTF;
	
	//mainGUI
public	FirstGui(){
		setTitle("Quiz Time!!!");
		setSize (650, 400);
		setLocation(250,180);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		//set get the content pane and set properties
		Container firstContainer = getContentPane();
        firstContainer.setBackground (Color.darkGray);
       	firstContainer.setLayout(null);
       	
       //	construct a play button
        playButton = new JButton ("PLAY");
        playButton.setBounds(170,220,80,30);
        playButton.setForeground(Color.red);
        firstContainer.add(playButton);
   		playButton.addActionListener(new MenuListener());
   		
   		// construct a exit button
   		 exitButton = new JButton ("EXIT");
        exitButton.setBounds(300,220,80,30);
        exitButton.setForeground(Color.red);
        firstContainer.add(exitButton);
		exitButton.addActionListener(new MenuListener());
		
		//Construct main JLabel 
   		titleLabel = new JLabel ("Irish History Quiz");
   		titleLabel.setForeground(Color.white);
   	 	titleLabel.setBounds(130,80,300,70);
   	 	titleLabel.setFont(titleLabel.getFont().deriveFont(36.0f)); //http://stackoverflow.com/questions/17884843/change-jlabel-font-size
   		firstContainer.add(titleLabel);
		
		//Construct main name JLabel
   		/*nameLabel = new JLabel("Please Enter Your Name: ");
   		nameLabel.setForeground(Color.white);
   	 	nameLabel.setBounds(120,160,145,20);
   		firstContainer.add(nameLabel);*/
   		
   		//Construct main name TextField
   	/*	nameTF = new TextField();
   		nameTF.setForeground(Color.black);
   		nameTF.setBounds(315,160,150,20);
   		firstContainer.add(nameTF);*/
   		
		createMenu();
	}
	
	public void createMenu() {
		
	navBar = new JMenuBar();
	setJMenuBar(navBar);
	JMenu file = new JMenu("File");
	navBar.add(file);
	JMenuItem play = new JMenuItem("Play");
	file.add(play);
	play.addActionListener( new MenuListener());
	JMenuItem score = new JMenuItem("High Score");
	file.add(score);
	file.addSeparator();
	JMenuItem quit = new JMenuItem("Quit");
	file.add(quit);
	quit.addActionListener( new MenuListener());
	JMenu help = new JMenu("Help");
	navBar.add(help);
	JMenuItem about = new JMenuItem("About");
	help.add(about);
	about.addActionListener( new MenuListener());	
	}//end of JMenu

        
         //Action MenuListner
         	private class MenuListener implements ActionListener{
         		
        	public void actionPerformed(ActionEvent e){
        		if(e.getActionCommand().equals("EXIT") || e.getActionCommand().equals("Quit")) {
        			System.exit(0);
        			}
        			
        	else if(e.getActionCommand().equals("Play") || e.getActionCommand().equals("PLAY")){
        	QuestionsFrame questionsFrame = new QuestionsFrame();
        	questionsFrame.setVisible(true);
        	}
        	
       		else if (e.getActionCommand().equals("About")){
        	JOptionPane.showMessageDialog(null, "This quiz produces 10 questions for the user to answer and adds" +
        		"the 10 highest scores and names", "About ",JOptionPane.INFORMATION_MESSAGE);	
       		}		
       	}
     } 	
}   
