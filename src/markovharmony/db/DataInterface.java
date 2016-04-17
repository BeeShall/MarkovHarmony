package markovharmony.db;


import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DataInterface {
	static MongoCollection<Document> songs;
	public static void main(String[] args){		
		try {
			MongoDatabase db = DBConnectionManager.getConnection();
			songs = db.getCollection("Songs");
			if(insertData("One Love","Bluez",Genre.Blues,1997,"USA", Chords.ChordList)){
				System.out.print("Data successfully added!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		}	
		
	}
	
	private static boolean insertData(String title, String artist, Genre genre, int year, String country, String[] chords){
		try{
			
			BasicDBList chordsList = new BasicDBList();
			for(String chord: chords){
				chordsList.add(chord);
			}
			songs.insertOne(new Document().append("TITLE", title).append("ARTIST", artist).append("GENRE", genre.name()).append("YEAR", year)
			.append("COUNTRY", country).append("chords",chordsList));
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
}
