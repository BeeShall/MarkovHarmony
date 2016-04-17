package markovharmony;
import java.util.ArrayList;

public class ProgressionTranslator 
{
	public static ArrayList<String[]> numeralToSymbol(String key, ArrayList<Integer> numericProgression)
	{
		ArrayList<String[]> symbolicProgression = new ArrayList<String[]>();
		
		final String [][] keySignature = new String [7][3];
		
		if(key == "CMajor")
		{
			System.arraycopy(Facts.CMajor, 0, keySignature, 0, 7);
		}
		else
		{
			System.arraycopy(Facts.CMinor, 0, keySignature, 0, 7);
		}		
		
		for(int i = 0; i < numericProgression.size(); i++)
		{
			symbolicProgression.add(keySignature[numericProgression.get(i)-1]);
		}
		
		
		return symbolicProgression;
 	}
}
