package markovharmony.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;



public class FileReader {

	private InputStream is;
	private static ArrayList<dbElement> dbElements;
	
	public static void main(String[] args){		
			InputStream is;
			try {
				is = new FileInputStream(new File("data.txt"));
				FileReader fr = new FileReader(is);				
				try {
					DBOperations operations = new DBOperations();
					for(dbElement element: dbElements ){
						if(operations.insertData(element.title,element.artist,element.genre,element.year,element.country, element.mode, element.chords)){
							System.out.println("Data successfully added!");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					System.exit(0);
				}				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
	}	

	
		public FileReader(InputStream is){			
			this.is = is;
			dbElements = new ArrayList<dbElement>();
			readElements();
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
	
	private Integer[] getChords(String[] data){
		ArrayList<Integer> chords = new ArrayList<Integer>();
		for(int i=0;i<data.length;i++){
			if(i ==0) chords.add(Integer.parseInt((data[i].trim().substring(1))));
			else if(i==data.length-1) chords.add(Integer.parseInt((data[i].trim().substring(0, data[i].length()-2))));
			else chords.add(Integer.parseInt((data[i].trim())));
		}
		Integer[] returnChords = new Integer[chords.size()];
		chords.toArray(returnChords);
		
		return returnChords;
		
	}


	
}
