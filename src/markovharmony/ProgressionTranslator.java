package markovharmony;
import java.util.ArrayList;

public class ProgressionTranslator 
{
	public static ArrayList<String[]> numeralToSymbol(String key, ArrayList<Integer> numericProgression)
	{
		ArrayList<String[]> symbolicProgression = new ArrayList<String[]>();
		
		final String [][] keySignature;
		
		if(key == "MAJOR")
		{
			keySignature = Facts.CMajor;
		}
		else
		{
			keySignature = Facts.CMinor;
		}		
	
		
		for(int i = 0; i < numericProgression.size(); i++)
		{
			symbolicProgression.add(keySignature[numericProgression.get(i)-1]);
		}
		
		
		return symbolicProgression;
 	}
}
