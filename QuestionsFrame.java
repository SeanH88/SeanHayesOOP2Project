/*
 *QuestionFrame.java 
 *@author Sean Hayes
 *4th Dec 2014
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class QuestionsFrame extends JFrame{
	//drivers
	private JLabel questionLabel;
	private JLabel nextQuestion;
	private int number =1;
	private JButton nextButton;
	private JPanel panel;
	private ButtonGroup bg;
	private JRadioButton choice1, choice2, choice3, choice4;
	private JLabel qLabel;
	private String[][] questions;
	private String[][] answers;
	private HashMap<Integer, String> Arraymap;
	private int questionAnswerID; //initialize question id
	
	
	//question frame
	public QuestionsFrame(){
	initializedata();
		 
		//set title
		setTitle("Irish History");
		setSize (650, 400);
		setLocation(250,180);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		//set get the content pane and set properties
		Container questionContainer = getContentPane();
        questionContainer.setBackground(Color.LIGHT_GRAY);
       	questionContainer.setLayout(null);	
       	
       	//add question label
       	questionLabel = new JLabel ("Question ");
       	questionLabel.setForeground(Color.blue);
   	 	questionLabel.setBounds(130,60,300,70);
   	 	questionLabel.setFont(questionLabel.getFont().deriveFont(36.0f)); //http://stackoverflow.com/questions/17884843/change-jlabel-font-size
   		questionContainer.add(questionLabel);
   		
   		//add increment number label
   		nextQuestion = new JLabel("" + number);
   		nextQuestion.setForeground(Color.blue);
   	 	nextQuestion.setBounds(290,80,100,30);
   	 	nextQuestion.setFont(nextQuestion.getFont().deriveFont(36.0f)); //http://stackoverflow.com/questions/17884843/change-jlabel-font-size
		questionContainer.add(nextQuestion);
		
		//Adding "NEXT Button	
		nextButton = new JButton ("NEXT"); 
     	nextButton.setBounds(170,260,80,30);
       	nextButton.setForeground(Color.red);
		questionContainer.add(nextButton);
		nextButton.addActionListener(new QuizListener());
	// nextButton.addActionListener(this);
		
		//add questions label qlabel
    	qLabel = new JLabel ("Choose a correct answer.");
    	qLabel.setForeground(Color.BLUE);
        qLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
		//add 	radio buttons
		bg = new ButtonGroup();
    	choice1 = new JRadioButton("Choice1",true);
    	choice2 = new JRadioButton("Choice2", false);
    	choice3 = new JRadioButton("Choice3", false); //http://java.worldbestlearningcenter.com/2013/04/quiz-program.html
      	choice4 = new JRadioButton("Choice4", false);
      	choice1.setBackground(Color.LIGHT_GRAY);
      	choice2.setBackground(Color.LIGHT_GRAY);
      	choice3.setBackground(Color.LIGHT_GRAY);
      	choice4.setBackground(Color.LIGHT_GRAY);
    	bg.add(choice1);
    	bg.add(choice2);
    	bg.add(choice3);
    	bg.add(choice4);
    	
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLocation(40,150);
	    panel.setSize(550,100);
	    panel.setLayout(new GridLayout(5,1));
	    panel.add(qLabel);
	    panel.add(choice1);
	    panel.add(choice2);
	    panel.add(choice3);
	    panel.add(choice4);
	    questionContainer.add(panel);	
	   	questionAnswerID=0;
	   	readQ_A(questionAnswerID);//Displays the first question and user answer
		
	}
	
//	http://java.worldbestlearningcenter.com/2013/04/quiz-program.html
	public void initializedata(){
		//questionsPA store pairs and possible answers
		
		questions = new String[2][5];
		answers = new String[2][2];
	
	questions[0][0]="In what county were the first shots fired in Irish War of Indepedence?";
	questions[0][1]="Dublin";
	questions[0][2]="Cork";
	questions[0][3]="Tipperary";
	questions[0][4]="Galway";
	
	questions[1][0]="Who was first president of Ireland?";
	questions[1][1]="Douglas Hyde";
	questions[1][2]="Erskine Childers";
	questions[1][3]="Cearbhall O Dalaigh";
	questions[1][4]="Sean T. O Kelly";
	
	//answers
	answers = new String[2][2];	
	answers[0][0]="In what county were the first shots fired in Irish War of Indepedence?";
	answers[0][1]="Tipperary";
	
	 //create a map object to store pairs of question and selected answer
        Arraymap=new HashMap<Integer, String>();
		
}

public String getSelection(){
	String choice = null;
		Enumeration<AbstractButton> RadioButtons=bg.getElements();
		while(RadioButtons.hasMoreElements()) //returns user answer
		{
			JRadioButton temp =(JRadioButton)RadioButtons.nextElement();
			if(temp.isSelected())
			{
				choice = temp.getText();
			}
		}
		return(choice);
}

//invokes to set the question to questionLabel and answer choices
public void readQ_A(int i){
	qLabel.setText("" + questions[i][0]);
	choice1.setText("" + questions[i][1]);
	choice2.setText("" + questions[i][2]);
	choice3.setText("" + questions[i][3]);
	choice4.setText("" + questions[i][4]);
	choice1.setSelected(true);
	
}
		//Action QuizListner
         	private class QuizListener implements ActionListener{	
        	public void actionPerformed(ActionEvent e){
        		if(e.getActionCommand().equals("NEXT")){
        			
        	do
      	 {
      		//increments nextQuestion
      		nextQuestion.setText("" + (number+1));	
      		number++;
      	if (number ==10)
      	{
 
      	System.exit(0);
      		
      	}
      	 }while(number>=11) ;
        			
        	}
         }
   	}  
	public static void main (String args[]){
	QuestionsFrame qf = new	QuestionsFrame();
		System.out.println("YEAHHHHHHH!!");
	}//end of main 
	
}
