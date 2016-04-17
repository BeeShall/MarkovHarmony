package markovharmony;
import java.util.ArrayList;
import java.util.Random;

public class MarkovNode 
{
	private Integer m_ID;
	private MarkovNode [] m_NodeArray;
	private ArrayList<Integer> m_DartBoard;
	
	public MarkovNode(Integer id)
	{
		m_ID = id;
	}
	
	public Integer getID()
	{
		return m_ID;
	}
	
	
	public void initialize(MarkovNode [] nodeArray, ArrayList<Integer> DartBoard)
	{
		m_NodeArray = nodeArray;
		m_DartBoard = DartBoard;
	}
	
	
	public MarkovNode getNextChord()
	{
		Random rand = new Random();
		return m_NodeArray[m_DartBoard.get(rand.nextInt(m_DartBoard.size()))-1];
	}
	
	
	
	
	
	
	
}
