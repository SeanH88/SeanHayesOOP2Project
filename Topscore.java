import java.io.*;  
public class Topscore implements Serializable{  // needed for saving
	private int finalScore;
	
	// 'accessor' methods to return a copy of an attribute
	public int getfinalScore(){return finalScore;} 
	
		// 'mutator' methods to change the value of an attribute
	public void setfinalScore(int finalScore){
			this.finalScore = finalScore;
		}
	
		// 'constructor' methods to give people a sensible initial state
	
	/** full-args constructor, to create a person about whom everything is known
	 */
	 
	 public Topscore (int finalScore){
	 	setfinalScore(finalScore);	
	 }
	 
	 public Topscore(){
	 	this(0);
	 }
	 
	 
	/* String summary of the values of all the object's attributes
	 */
	public String toString(){
				return " " + getfinalScore();
	}
	
}