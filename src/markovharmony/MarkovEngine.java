package markovharmony;
import markovharmony.MarkovNode;
import markovharmony.db.Chords;
import java.util.ArrayList;
import java.util.Random;


public class MarkovEngine 
{
	private MarkovNode [] m_NodeArray;
	private ArrayList<Integer> m_DartBoard;
	private Integer [] m_ProbabilityArray; 
	
	public MarkovEngine()
	{
		System.out.println("Markov initialized");
	}
	
	public void begin()
	{
		System.out.println("Hey time for Markov");
		
		// Generate the probabilities
		m_ProbabilityArray = new Integer[7];		
		generateProbabilities();
		
		// Populate the dart board
		m_DartBoard = new ArrayList<Integer>();
		populateDartBoard();
		
		
		// Generate nodes and populate map
		m_NodeArray = new MarkovNode [7];
		generateNodes();
		
		// Initialize nodes	
		initializeNodes();
		
		System.out.println(m_DartBoard.toString());
		
	}
	
	private void generateNodes()
	{		
		for(int i = 0; i < 7; i++)
		{	
			MarkovNode tmp = new MarkovNode(i+1, m_DartBoard);
			m_NodeArray[i] = tmp;
		}
		
	}


	private void generateProbabilities()
	{		
		Random rand = new Random();
		for(int i = 0; i < 7; i++)
		{
			m_ProbabilityArray[i] = rand.nextInt(50);
		}
	}
	
	public void populateDartBoard()
	{
		for(int j = 0; j < 7; j++)
		{
			for(int i = 0; i < m_ProbabilityArray[j]; i++)
			{
				m_DartBoard.add(j+1);
			}
		}
	}
	
	
	private void initializeNodes()
	{
		for(int i = 0; i < 7; i++)
		{
			m_NodeArray[i].initialize(m_NodeArray);
		}
	}
	
	
	
}
