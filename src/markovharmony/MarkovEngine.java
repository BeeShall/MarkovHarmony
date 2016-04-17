package markovharmony;
import markovharmony.MarkovNode;
import markovharmony.Facts;
<<<<<<< HEAD
import markovharmony.db.Chords;
=======
>>>>>>> 57a8b435fd0e51049675d098618db5e5e69b204e
import java.util.ArrayList;
import java.util.Random;


public class MarkovEngine 
{
	private MarkovNode [] m_NodeArray;
	private ArrayList<Integer> m_CurrentProgression;

	public MarkovEngine()
	{
		System.out.println("Markov initialized");
		m_CurrentProgression = new ArrayList<Integer>();
		m_NodeArray = new MarkovNode [7];
	}
	
	public ArrayList<Integer> RunEngine()
	{
		System.out.println("Hey time for Markov");

		
		// Generate nodes and populate map
		generateNodes();
		
		// Initialize nodes	
		initializeNodes();
		
		return getProgression();
				
	}
	
	private void generateNodes()
	{		
		for(int i = 0; i < 7; i++)
		{	
			MarkovNode tmp = new MarkovNode(i+1);
			m_NodeArray[i] = tmp;
		}
		
	}


	private Integer [] generateProbabilities()
	{		
		Integer [] ProbabilityArray = new Integer[7];
		Random rand = new Random();
		for(int i = 0; i < 7; i++)
		{
			ProbabilityArray[i] = rand.nextInt(50);
		}
		
		return ProbabilityArray;
	}
	
	public ArrayList<Integer> populateDartBoard()
	{
		ArrayList<Integer> DartBoard = new ArrayList<Integer>();
		
		Integer [] ProbabilityArray = generateProbabilities();
		
		for(int j = 0; j < 7; j++)
		{
			for(int i = 0; i < ProbabilityArray[j]; i++)
			{
				DartBoard.add(j+1);
			}
		}
		
		return DartBoard;
	}
	
	
	private void initializeNodes()
	{
		for(int i = 0; i < 7; i++)
		{
			ArrayList<Integer> DartBoard = populateDartBoard();
			m_NodeArray[i].initialize(m_NodeArray, DartBoard);
		}
	}
	

	private ArrayList<Integer> getProgression()
	{
		return ChordGenerator.generateProgression(16, m_NodeArray);	
	}
	
}
