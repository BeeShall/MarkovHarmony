package markovharmony.db;



import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DataInterface {
		
	public static void main(String[] args){		
		try {
			DBOperations operations = new DBOperations();
			Collection<dbElement> els = operations.getAllData();
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		}	
		
	}	
	
	
	
}
