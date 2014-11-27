/*
 *MyMenuGui.java 
 *@author Sean Hayes
 *26th Nov 2014
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyMenuGui extends JFrame implements ActionListener {
	
//private  instance variable
		//drivers
		
	private	JButton playButton;
	private	JButton exitButton;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private	JMenuBar navBar;
	private TextField nameTF;
	private JTextArea   JTAAbout = new JTextArea();
	
	public static void main (String args[]){
		
	MyMenuGui mainFrame = new MyMenuGui();
	mainFrame.setVisible(true);
	
			} //end main
			 
		public MyMenuGui() {
			setTitle("Quiz Time!!!");
			setSize (600, 400);
			setLocation(250,180);
			setDefaultCloseOperation( EXIT_ON_CLOSE );	
				
				 
				 //set get the content pane and set properties
		Container firstContainer = getContentPane();
        firstContainer.setBackground (Color.darkGray);
       	firstContainer.setLayout(null);
  
       	
	//  construct a play button
        playButton = new JButton ("PLAY");
        playButton.setBounds(170,220,80,30);
        playButton.setForeground(Color.red);
        firstContainer.add(playButton);
         BEHandlerP handlerPlay = new BEHandlerP();
   		playButton.addActionListener(handlerPlay);
        
        //  construct a exit button
        exitButton = new JButton ("EXIT");
        exitButton.setBounds(300,220,80,30);
        exitButton.setForeground(Color.red);
        firstContainer.add(exitButton);
        BEHandlerE handlerExit = new BEHandlerE();
   		exitButton.addActionListener(handlerExit);
   		
   		//Construct main JLabel 
   		titleLabel = new JLabel ("Irish History Quiz");
   		titleLabel.setForeground(Color.white);
   	 	titleLabel.setBounds(130,80,300,70);
   	 	titleLabel.setFont(titleLabel.getFont().deriveFont(36.0f)); //http://stackoverflow.com/questions/17884843/change-jlabel-font-size
   		firstContainer.add(titleLabel);
   		
   		//Construct main name JLabel
   		nameLabel = new JLabel("Please Enter Your Name: ");
   		nameLabel.setForeground(Color.white);
   	 	nameLabel.setBounds(120,160,145,20);
   		firstContainer.add(nameLabel);
   		
   			//Construct main name TextField
   		nameTF = new TextField();
   		nameTF.setForeground(Color.black);
   		nameTF.setBounds(315,160,150,20);
   		firstContainer.add(nameTF);
   		
   		createMenus();
   		
		} //end of constructor 
		
	
		public void createMenus(){
			navBar = new JMenuBar();
			setJMenuBar(navBar);
			JMenu file = new JMenu("File");
			navBar.add(file);
			JMenuItem play = new JMenuItem("Play");
			file.add(play);
			play.addActionListener(this);
			JMenuItem score = new JMenuItem("High Score");
			file.add(score);
			file.addSeparator();
			JMenuItem quit = new JMenuItem("Quit");
			file.add(quit);
			quit.addActionListener(this);
			JMenu help = new JMenu("Help");
			navBar.add(help);
			JMenuItem about = new JMenuItem("About");
			help.add(about);
			about.addActionListener(this);
		} //end of JMenu
	 
        public void actionPerformed(ActionEvent e){
        	if(e.getActionCommand().equals("Quit")){
        		System.exit(0);	
        	}
        
        	else if (e.getActionCommand().equals("About")){
        	JTAAbout.setText("About The Quiz");
        	JTAAbout.append("\nThis quiz randomly produces 10 questions for the user to answer and adds the 10 highest scores and names \n");	
        	JOptionPane.showMessageDialog(null,JTAAbout, "About ",JOptionPane.INFORMATION_MESSAGE);	
        	}
        	
        	else if (e.getActionCommand().equals("Play")){
        		Questions secondFrame = new Questions();	
				secondFrame.setVisible(true);
        	}
    
        }
        
        private class BEHandlerE implements ActionListener{
        	public void actionPerformed(ActionEvent e){
        		if(e.getActionCommand().equals("EXIT")){
				System.exit(0);
				
			}
			
        	}
        }
        
        private class BEHandlerP implements ActionListener{
        	public void actionPerformed(ActionEvent e){
        		if(e.getActionCommand().equals("PLAY")){
        		Questions secondFrame = new Questions();	
				secondFrame.setVisible(true);
        }
			
        	}
        }
		}
