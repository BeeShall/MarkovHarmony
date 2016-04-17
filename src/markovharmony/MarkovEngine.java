package markovharmony;
import markovharmony.MarkovNode;
import markovharmony.Facts;
import java.util.ArrayList;
import java.util.Random;
import markovharmony.db.DBOperations;

public class MarkovEngine 
{
	private MarkovNode [] m_NodeArray;
	private ArrayList<Integer> m_CurrentProgression;
	private ArrayList<ArrayList<Integer>> rawData;
	private Integer m_numChords;
	
	public MarkovEngine()
	{
		System.out.println("Markov initialized");
		m_CurrentProgression = new ArrayList<Integer>();
		m_NodeArray = new MarkovNode [7];
	}
	
	public ArrayList<Integer> RunEngine(ArrayList<ArrayList<Integer>> data, Integer phraseLength, Integer chordsPerMeasure) throws Exception
	{
		System.out.println("Hey time for Markovsky to play");

		// Calculate numChords
		m_numChords = phraseLength * chordsPerMeasure;
		
		// Generate nodes and populate map
		generateNodes();
		
		// Load in data	
		rawData = data;
		
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


	private Integer [] generateProbabilities(MarkovNode node)
	{		
		Integer [] ProbabilityArray = new Integer[7];
		for(int i = 0; i < 7; i++)
		{
			ProbabilityArray[i] = 0;
		}
		
		for(int i = 0; i < rawData.size(); i++)
		{
			for(int j = 0; j < rawData.get(i).size()-1; j++)
			{
				if(node.getID() == rawData.get(i).get(j))
				{
					ProbabilityArray[rawData.get(i).get(j+1)]++;
				}
			}
		}
		
		return ProbabilityArray;
	}
	
	public ArrayList<Integer> populateDartBoard(MarkovNode node)
	{
		ArrayList<Integer> DartBoard = new ArrayList<Integer>();
		
		Integer [] ProbabilityArray = generateProbabilities(node);
		
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
			ArrayList<Integer> DartBoard = populateDartBoard(m_NodeArray[i]);
			m_NodeArray[i].initialize(m_NodeArray, DartBoard);
		}
	}
	

	private ArrayList<Integer> getProgression()
	{
		return ChordGenerator.generateProgression(m_numChords, m_NodeArray);	
	}

	
	
	
	
	
}
