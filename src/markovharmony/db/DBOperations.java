package markovharmony.db;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBOperations {
	static MongoCollection<Document> songs;
	
	public DBOperations() throws Exception{
		MongoDatabase db;
		try {
			db = DBConnectionManager.getConnection();
			songs = db.getCollection("Songs");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception("Connection to the datbase was unsuccessful!");
	}
	}
	
	public boolean insertData(String title, String artist, Genre genre, int year, String country, Mode mode, Integer[] chords){
		try{			
			BasicDBList chordsList = new BasicDBList();
			for(Integer chord: chords){
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
	
	public ArrayList<ArrayList<Integer>> getAllProgressions(){
		final ArrayList<ArrayList<Integer>> progressions = new ArrayList<ArrayList<Integer>>();
		FindIterable<Document> iterable = songs.find();
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		       ArrayList<Integer> chords = (ArrayList<Integer>)document.get("CHORDS");	
		       
		       progressions.add(chords);
		    }
		});
		return progressions;
	}
	
	public ArrayList<ArrayList<Integer>> getFilteredData(String artist, Genre genre, int year, String country, Mode mode){
		final ArrayList<ArrayList<Integer>> progressions = new ArrayList<ArrayList<Integer>>();
		Document document = new Document();
		if(artist!="") document.append("ARTIST", artist);
		if(genre != Genre.NONE) document.append("GENRE", genre.name());
		if(year >0) document.append("YEAR", year);
		document.append("MODE", mode.name());
		FindIterable<Document> iterable =songs.find(document);
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		       ArrayList<Integer> chords = (ArrayList<Integer>)document.get("CHORDS");
		       
		       progressions.add(chords);
		    }
		});
		return progressions;
	}

}
