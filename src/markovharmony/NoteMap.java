package markovharmony;
import java.util.Dictionary;
import java.util.Hashtable;

public class NoteMap 
{
	public Dictionary<String, Integer[]> Notes;
	
	public NoteMap()
	{
		Notes = new Hashtable<String, Integer[]>();
		populate();
	}
	
	private void populate()
	{
		Integer tone1 = new Integer(60);
		Integer tone2 = new Integer(72);
		Integer tone3 = new Integer(84);

		Integer[] C = {tone1++, tone2++, tone3++};
		Integer[] Db = {tone1++, tone2++, tone3++};
		Integer[] D = {tone1++, tone2++, tone3++};
		Integer[] Eb = {tone1++, tone2++, tone3++};
		Integer[] E = {tone1++, tone2++, tone3++};
		Integer[] F = {tone1++, tone2++, tone3++};
		Integer[] Gb = {tone1++, tone2++, tone3++};
		Integer[] G = {tone1++, tone2++, tone3++};
		Integer[] Ab = {tone1++, tone2++, tone3++};
		Integer[] A = {tone1++, tone2++, tone3++};
		Integer[] Bb = {tone1++, tone2++, tone3++};
		Integer[] B = {tone1++, tone2++, tone3++};
		
		Notes.put("C", C);
		Notes.put("D", D);
		Notes.put("E", E);
		Notes.put("F", F);
		Notes.put("G", G);
		Notes.put("A", A);
		Notes.put("B", B);
		Notes.put("Db", Db);
		Notes.put("Eb", Eb);
		Notes.put("Gb", Gb);
		Notes.put("Ab", Ab);
		Notes.put("Bb", Bb);
		Notes.put("Cb", B);
		Notes.put("Fb", E);
		Notes.put("Cs", Db);
		Notes.put("Ds", Eb);
		Notes.put("Es", F);
		Notes.put("Fs", Gb);
		Notes.put("Gs", Ab);
		Notes.put("As", Bb);
		Notes.put("Bs", C);

		
	}
	
}
