package markovharmony;
import java.util.ArrayList;

public class Main 
{
	public static void main(final String [] args) throws Exception
	{
		MarkovEngine markovengine = new MarkovEngine();
		ArrayList<Integer> progression =  markovengine.RunEngine();
		
		
		
		
		
		System.out.println(progression.toString());
		
		System.out.println("Program terminating.");
	}
}
