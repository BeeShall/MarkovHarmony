package markovharmony;
import markovharmony.MarkovNode;
import markovharmony.Facts;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;


public class MarkovEngine 
{
	private Dictionary<String, MarkovNode> m_NodeMap;
	private ArrayList<String> m_DartBoard;
	Dictionary<String, Integer> m_ProbabilityMap; 
	
	public MarkovEngine()
	{
		System.out.println("Markov initialized");
	}
	
	public void begin()
	{
		System.out.println("Hey time for Markov");
		
		// Generate the probabilities
		m_ProbabilityMap = new Hashtable<String, Integer>();		
		generateProbabilities();
		
		// Populate the dart board
		m_DartBoard = new ArrayList<String>();
		populateDartBoard();
		
		
		// Generate nodes and populate map
		m_NodeMap = new Hashtable<String, MarkovNode>();
		generateNodes();
		
		// Initialize nodes	
		initializeNodes();
		
	}
	
	private void generateNodes()
	{		
		for(int i = 0; i < Facts.ChordList.length; i++)
		{
			
			MarkovNode tmp = new MarkovNode(Facts.ChordList[i], m_DartBoard);
			m_NodeMap.put(Facts.ChordList[i], tmp);
		}
		
	}


	private void generateProbabilities()
	{		
		Random rand = new Random();
		for(int i = 0; i < Facts.ChordList.length; i++)
		{
			m_ProbabilityMap.put(Facts.ChordList[i], rand.nextInt(50));
		}

	}
	
	public void populateDartBoard()
	{
		for(Enumeration e = m_ProbabilityMap.keys(); e.hasMoreElements(); )
		{
			Object tmp = e.nextElement();
			for(int i = 0; i < m_ProbabilityMap.get(tmp); i++)
			{
				m_DartBoard.add(((String) tmp));
			}
		}
	}
	
	
	private void initializeNodes()
	{
		for(Enumeration e = m_NodeMap.keys(); e.hasMoreElements(); )
		{
			m_NodeMap.get(e.nextElement()).initialize(m_NodeMap);
		}
	}
	
	
	
}
