package markovharmony;
import java.util.ArrayList;

public class Main 
{
	public static void main(final String [] args)
	{
		MarkovEngine engine = new MarkovEngine();
		ArrayList<Integer> progression =  engine.RunEngine();
		
		System.out.println(progression.toString());
		
		System.out.println("Program terminating.");
	}
}
