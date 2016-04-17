package markovharmony.db;

import java.util.ArrayList;
import java.util.Collection;

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
	
	public boolean insertData(String title, String artist, Genre genre, int year, String country, Mode mode, String[] chords){
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
	
	public Collection<dbElement> getAllData(){
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
