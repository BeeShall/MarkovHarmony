package markovharmony;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.ArrayList;

public class MarkovNode 
{
	private String m_ID;
	private Dictionary<String, MarkovNode> m_NodeMap;
	private ArrayList<String> m_DartBoard;
	private boolean m_isInitialized;
	
	public MarkovNode(String id, ArrayList<String> DartBoard)
	{
		m_ID = id;
		m_DartBoard = DartBoard;
		m_isInitialized = false;
		
	}
	
	public String getID()
	{
		return m_ID;
	}
	
	
	public void initialize(Dictionary<String, MarkovNode> nodeMap)
	{
		m_NodeMap = nodeMap;
		
		m_isInitialized = true;
	}
	
	
	
	
	
	
	
	
}
