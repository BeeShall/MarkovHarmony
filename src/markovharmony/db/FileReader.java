package markovharmony.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FileReader {

	private InputStream is;
	private Collection<dbElement> dbElements;

	
		public FileReader(InputStream is){
			this.is = is;
			dbElements = new ArrayList<dbElement>();
			readElements();
		}
		
		public void printElements(){
			for(dbElement e: dbElements){
				System.out.println(e.artist);
				System.out.println(e.country);
				System.out.println(e.title);
				System.out.println(e.year);
				System.out.println(e.genre);
				System.out.println(e.mode);
				for(String chord: e.chords){
					System.out.print(chord+" ");
				}
				System.out.println();
			}
		}

	
	public Collection<dbElement> getElements() {
		return dbElements;
	}

		
	private void readElements() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				dbElements.add(createDbElement(line.substring(1, line.length()-1)));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	private dbElement createDbElement(String data) {
		dbElement element = new dbElement();
		String[] subElements = data.split(",");
		element.title = subElements[0].trim();
		element.artist = subElements[1].trim();
		element.genre = Genre.valueOf(subElements[2].trim().toUpperCase());
		element.year = Integer.parseInt(subElements[3].trim());
		element.country = subElements[4].trim();
		element.mode = Mode.valueOf(subElements[5].trim().toUpperCase());
		element.chords = getChords(Arrays.copyOfRange(subElements, 6, subElements.length));
		return element;
	}
	
	private String[] getChords(String[] data){
		Collection<String> chords = new ArrayList<String>();
		for(int i=0;i<data.length;i++){
			if(i ==0) chords.add(data[i].trim().substring(1));
			else if(i==data.length-1) chords.add(data[i].trim().substring(0, data[i].length()-2));
			else chords.add(data[i]);
		}
		String[] returnChords = new String[chords.size()];
		chords.toArray(returnChords);
		
		return returnChords;
		
	}


	
}
