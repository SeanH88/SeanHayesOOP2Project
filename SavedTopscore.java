import java.util.*;
import java.io.*;

public class SavedTopscore{

public static void main (String args[]) throws FileNotFoundException, IOException {
	LinkedList <Topscore> myScore;
	myScore = new LinkedList<Topscore>();
	
	Topscore ts1 = new Topscore (10);
	myScore.add(ts1);
	
	File ScoreList = new File ("myScore.dat");
	FileOutputStream  fos = new FileOutputStream(ScoreList);
	
	ObjectOutputStream os = new ObjectOutputStream(fos);
	
	os.writeObject(myScore);

}
}