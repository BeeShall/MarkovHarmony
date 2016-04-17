package markovharmony;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;
<<<<<<< HEAD
import markovharmony.db.Chords;
=======
>>>>>>> 57a8b435fd0e51049675d098618db5e5e69b204e
import java.util.ArrayList;
import java.util.Random;

public class MarkovNode 
{
	private Integer m_ID;
	private MarkovNode [] m_NodeArray;
	private ArrayList<Integer> m_DartBoard;
	private boolean m_isInitialized;
	
	public MarkovNode(Integer id)
	{
		m_ID = id;
		m_isInitialized = false;
		
	}
	
	public Integer getID()
	{
		return m_ID;
	}
	
	
	public void initialize(MarkovNode [] nodeArray, ArrayList<Integer> DartBoard)
	{
		m_NodeArray = nodeArray;
		m_DartBoard = DartBoard;
		
		m_isInitialized = true;
	}
	
	
	public MarkovNode getNextChord()
	{
		Random rand = new Random();
		return m_NodeArray[rand.nextInt(7)];
	}
	
	
	
	
	
	
	
}
