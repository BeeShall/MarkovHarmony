package markovharmony;
import markovharmony.MarkovNode;
<<<<<<< HEAD
import markovharmony.db.Chords;
=======
import markovharmony.Chords;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

>>>>>>> ec8afe49af9f98f3024dbbb588076a308c9df7eb

public class MarkovEngine 
{
	private ArrayList<MarkovNode> m_nodes;
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
		
		m_ProbabilityMap = generateProbabilities();
		
		
		// Populate the dart board
		
		m_DartBoard = new ArrayList<String>();
		populateDartBoard();
		
		
		// Generate nodes and populate map
		
		for(int i = 0; i < Chords.ChordList.length; i++)
		{
			MarkovNode tmp = new MarkovNode(Chords.ChordList[i], m_DartBoard);
			m_NodeMap.put(Chords.ChordList[i], tmp);
		}
		
		
		// Initialize nodes
		
		for(Enumeration e = m_NodeMap.keys(); e.hasMoreElements(); )
		{
			
		}
		
		
	}
	
	private void generateNodes()
	{
		m_nodes.clear();
		
		
		
	}

	private Dictionary<String, Integer> generateProbabilities()
	{
		Dictionary<String, Integer> probabilities = new Hashtable<String, Integer>();		
		
		Random rand = new Random();
		for(int i = 0; i < Chords.ChordList.length; i++)
		{
			probabilities.put(Chords.ChordList[i], rand.nextInt(50));
		}
		
		return probabilities;
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
	
}
