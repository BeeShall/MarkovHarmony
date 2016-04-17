package markovharmony;
import java.util.ArrayList;

public class Facts
{
	public static final String [] C = {"C", "E", "G"};
	public static final String [] Cm = {"C", "Eb", "G"};
	public static final String [] D = {"D", "Fs", "A"};
	public static final String [] Dm = {"D", "F", "A"};
	public static final String [] E = {"E", "Gs", "B"};
	public static final String [] Em = {"E", "G", "B"};
	public static final String [] F = {"F", "A", "C"};
	public static final String [] Fm = {"F", "Ab", "C"};
	public static final String [] G = {"G", "B", "D"};
	public static final String [] Gm = {"G", "Bb", "D"};
	public static final String [] A = {"A", "Cs", "E"};
	public static final String [] Am = {"A", "C", "E"};
	public static final String [] B = {"B", "Ds", "Fs"};
	public static final String [] Bm = {"B", "D", "Fs"};
	public static final String [] Db = {"Db", "F", "Ab"};
	public static final String [] Dbm = {"Db", "Fb", "Ab"};
	public static final String [] Eb = {"Eb", "G", "Bb"};
	public static final String [] Ebm = {"Eb", "Gb", "Bb"};
	public static final String [] Gb = {"Gb", "Bb", "Db"};
	public static final String [] Ab = {"Ab", "C", "Eb"};
	public static final String [] Abm = {"Ab", "Cb", "Eb"};
	public static final String [] Bb = {"Bb", "D", "F"};
	public static final String [] Bbm = {"Bb", "Db", "F"};

	
	public static final String [][] ChordList = 
		{
				C, Cm, D, Dm, E, Em, F, Fm, G, Gm, A, Am, B, Bm, Db, Dbm,
				Eb, Ebm, Gb, Ab, Abm, Bb, Bbm
		};
	
	public static final String [][] CMajor = 
		{
				C, Dm, Em, F, G, Am, Bm
		};
	
	public static final String [][] CMinor = 
		{
				Cm, Dm, Eb, Fm, Gm, Ab, Bb
		};
}
