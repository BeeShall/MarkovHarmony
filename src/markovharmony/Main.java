package markovharmony;
import java.util.ArrayList;

public class Main 
{
	public static void main(final String [] args)
	{
		MarkovEngine markovengine = new MarkovEngine();
		ArrayList<Integer> progression =  markovengine.RunEngine();
		
		
		
		
		
		System.out.println(progression.toString());
		
		System.out.println("Program terminating.");
	}
}
