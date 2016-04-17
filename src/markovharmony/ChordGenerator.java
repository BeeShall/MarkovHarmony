package markovharmony;
import markovharmony.MarkovNode;
import java.util.ArrayList;

public class ChordGenerator 
{
	public static ArrayList<Integer> generateProgression(Integer numChords, MarkovNode [] nodeArray)
	{
		ArrayList<Integer> progression = new ArrayList<Integer>();
		
		MarkovNode current = nodeArray[0];
		
		for(int i = 0; i < numChords; i++)
		{
			progression.add(current.getID());
			current = current.getNextChord();
		}
		
		return progression;
	}
	
	
}
