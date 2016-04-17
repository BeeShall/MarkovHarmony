package markovharmony;
import markovharmony.db.Chords;
import java.util.ArrayList;

public class MarkovNode 
{
	private Integer m_ID;
	private MarkovNode [] m_NodeArray;
	private ArrayList<Integer> m_DartBoard;
	private boolean m_isInitialized;
	
	public MarkovNode(Integer id, ArrayList<Integer> DartBoard)
	{
		m_ID = id;
		m_DartBoard = DartBoard;
		m_isInitialized = false;
		
	}
	
	public Integer getID()
	{
		return m_ID;
	}
	
	
	public void initialize(MarkovNode [] nodeArray)
	{
		m_NodeArray = nodeArray;
		
		m_isInitialized = true;
	}
	
	
	
	
	
	
	
	
}
