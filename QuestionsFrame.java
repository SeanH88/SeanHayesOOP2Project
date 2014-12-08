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

 class QuestionsFrame extends JFrame implements ActionListener {
	//drivers
	LinkedList <Topscore> ts;
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
	private	HashMap<Integer, String> Arraymap;
	private	int questionAnswerID; //initialize question id
	
	
	//question frame
	 QuestionsFrame(){
	initializedata();
		
		//set title
		setTitle("Irish History");
		setSize (790, 400);
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
		nextButton.addActionListener(this);
	// nextButton.addActionListener(this);
		
		//add questions label qlabel
    	qLabel = new JLabel ("Choose a correct answer.");
    	qLabel.setForeground(Color.BLUE);
        qLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
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
	    panel.setSize(700,100);
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
	
	//Action QuizListner	
        	public void actionPerformed(ActionEvent e){
        		if(nextButton.getText().equals("NEXT")){
      	
     if(questionAnswerID<9)
      	{
      		Arraymap.put(questionAnswerID,getSelection());
      		questionAnswerID ++;
      		readQ_A(questionAnswerID);
      			number++;
                nextQuestion.setText("" + number);
      	}
      	

      	else {
      		Arraymap.put(questionAnswerID,getSelection());
      		nextButton.setText("Finish");
      	}
        	}
        	
        	else if (nextButton.getText().equals("Finish"))
        		new Results();
        		
   	}
   		
   		//	http://java.worldbestlearningcenter.com/2013/04/quiz-program.html
	public void initializedata(){
		//questionsPA store pairs and possible answers
		
		questions = new String[10][5];
	
	questions[0][0]="In what county were the first shots fired in Irish War of Indepedence?";
	questions[0][1]="Dublin";
	questions[0][2]="Cork";
	questions[0][3]="Tipperary";
	questions[0][4]="Galway";
	
	questions[1][0]="Who was the first president of Ireland?";
	questions[1][1]="Douglas Hyde";
	questions[1][2]="Erskine Childers";
	questions[1][3]="Cearbhall O Dalaigh";
	questions[1][4]="Sean T. O Kelly";
	
	questions[2][0]="What is the estimated year of settlment of the Celts in Ireland?";
	questions[2][1]="600BC";
	questions[2][2]="500BC";
	questions[2][3]="400BC";
	questions[2][4]="300BC";
	
	questions[3][0]="How many Irishmen fought in World War 1?";
	questions[3][1]="100,000 +";
	questions[3][2]="150,000 +";
	questions[3][3]="200,000 +";
	questions[3][4]="250,000 +";
	
	questions[4][0]="Combining deaths and emmigration, how many people died/left Ireland during the Great Famine?";
	questions[4][1]="2.75 million";
	questions[4][2]="2.5 million";
	questions[4][3]="2 million";
	questions[4][4]="1.75 million";
	
	questions[5][0]="Who was Charles Stewart Parnells' mistress?";
	questions[5][1]="Rosanna Gilbert";
	questions[5][2]="Katherine O'Shea";
	questions[5][3]="Terry Keane";
	questions[5][4]="Marie-Louise O'Murphy";
	
	questions[6][0]="In what year did United Irishmen Rebellion take place?";
	questions[6][1]="1798";
	questions[6][2]="1888";
	questions[6][3]="1788";
	questions[6][4]="1898";
	
	questions[7][0]="Where did the first recorded Viking raid take place in Ireland?";
	questions[7][1]="Dublin";
	questions[7][2]="Wexford";
	questions[7][3]="Rathlin Island";
	questions[7][4]="Armagh";
	
	questions[8][0]="Who was the German officer commander who was to drop of arms at Banna Strand in 1916?";
	questions[8][1]="Gustav von Senden-Bibran";
	questions[8][2]="Alfred von Tirpitz";
	questions[8][3]="Karl von Bunlow";
	questions[8][4]="Karl Spindler";
	
	questions[9][0]="When did Ireland join the EEC?";
	questions[9][1]="1972";
	questions[9][2]="1973";
	questions[9][3]="1974";
	questions[9][4]="1975";
	
	//answers
	answers = new String[10][2];	
	answers[0][0]="In what county were the first shots fired in Irish War of Indepedence?";
	answers[0][1]="Tipperary";
	
	answers[1][0] ="Who was the first president of Ireland?";
	answers[1][1] = "Douglas Hyde";
	
	answers[2][0] ="What is the estimated year of settlment of the Celts in Ireland?";
	answers[2][1] = "300BC";
	
	answers[3][0] ="How many Irishmen fought in World War 1?";
	answers[3][1] ="200,000 +";
	
	answers[4][0] ="Combining deaths and emmigration, how many people ndied/left Ireland during the Great Famine?";
	answers[4][1] ="2 million";
	
	answers[5][0] ="Who was Charles Stewart Parnells' mistress?";
	answers[5][1] ="Katherine O'Shea";
	
	answers[6][0] ="In what year did United Irishmen Rebellion take place?";
	answers[6][1] ="1798";
	
	answers[7][0] ="Where did the first recorded Viking raid take place in Ireland?";
	answers[7][1] ="Rathlin Island";
	
	answers[8][0] ="Who was the German officer commander who was to drop of arms at Banna Strand in 1916?";
	answers[8][1] ="Karl Spindler";
	
	answers[9][0] ="When did Ireland join the EEC?";
	answers[9][1] ="1973";
	
	 //create a map object to store pairs of question and selected answer
        Arraymap=new HashMap<Integer, String>();
		
}

public String getSelection(){
	String choice = null;
		Enumeration<AbstractButton> buttons=bg.getElements();
		while(buttons.hasMoreElements()) //returns user answer
		{
			JRadioButton temp =(JRadioButton)buttons.nextElement();
			if(temp.isSelected())
			{
				choice = temp.getText();
			}
		}
		return(choice);
}

//invokes to set the question to questionLabel and answer choices
public void readQ_A(int i){
	qLabel.setText(" " + questions[i][0]);
	choice1.setText(questions[i][1]);
	choice2.setText(questions[i][2]);
	choice3.setText(questions[i][3]);
	choice4.setText(questions[i][4]);
	choice1.setSelected(true);
	
}
	
	public int calCorrectAnswer(){
		int qNumber=10;
		int count=0;
		
		for(int i=0; i<qNumber; i++)
			if(answers[i][1].equals(Arraymap.get(i)))count++;
			return count;
	}
	
	public class Results {
		 Results(){
		 	
		 		//Show number of correct Answers
					int correct = calCorrectAnswer();				
		 JOptionPane.showMessageDialog(null,"You got "+ correct + " questions correct!","Result",JOptionPane.INFORMATION_MESSAGE);	
		 System.exit(0);
		}	

	}
	
}

