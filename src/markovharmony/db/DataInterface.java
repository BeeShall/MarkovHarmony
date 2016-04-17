package markovharmony.db;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import markovharmony.Facts;

public class DataInterface {
	static MongoCollection<Document> songs;
	
	public DataInterface(){
		try {
			MongoDatabase db = DBConnectionManager.getConnection();
			songs = db.getCollection("Songs");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public static void main(String[] args){		
		try {
			MongoDatabase db = DBConnectionManager.getConnection();
			songs = db.getCollection("Songs");
			InputStream is = new FileInputStream(new File("data.txt"));
			FileReader fr = new FileReader(is);
			Collection<dbElement> elements= fr.getElements();
			for(dbElement element: elements ){
				if(insertData(element.title,element.artist,element.genre,element.year,element.country, element.mode, element.chords)){
					System.out.println("Data successfully added!");
				}
			}
			/*
			Collection<dbElement> els = getAllData();
			System.out.println(els.size());
			for(dbElement el: els){
				System.out.println(el.artist);
				System.out.println(el.country);
				System.out.println(el.title);
				System.out.println(el.year);
				System.out.println(el.genre);
				System.out.println(el.mode);
				for(String chord: el.chords){
					System.out.print(chord+" ");
				}
				System.out.println();
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		}	
		
	}
	
	private static boolean insertData(String title, String artist, Genre genre, int year, String country, Mode mode, String[] chords){
		try{
			
			BasicDBList chordsList = new BasicDBList();
			for(String chord: chords){
				chordsList.add(chord);
			}
			songs.insertOne(new Document().append("TITLE", title).append("ARTIST", artist).append("GENRE", genre.name()).append("YEAR", year)
			.append("COUNTRY", country).append("MODE", mode.name()).append("CHORDS",chordsList));
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	private static Collection<dbElement> getAllData(){
		Collection<dbElement> elements = new ArrayList<dbElement>();
		FindIterable<Document> iterable = songs.find();
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		       dbElement element = new dbElement();
		       element.artist = document.getString("ARTIST");
		       element.title = document.getString("TITLE");
		       element.genre = Genre.valueOf(document.getString("GENRE"));
		       element.year = document.getInteger("YEAR");
		       element.mode = Mode.valueOf(document.getString("MODE"));
		       element.country = document.getString("COUNTRY");
		       Collection<String> chords = (ArrayList<String>)document.get("CHORDS");
		       String[] retreivedChords = new String[chords.size()];
		       chords.toArray(retreivedChords);
		       element.chords = retreivedChords;	
		       
		       elements.add(element);
		    }
		});
		return elements;
	}
}
