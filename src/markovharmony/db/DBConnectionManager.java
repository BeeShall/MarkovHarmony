package markovharmony.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnectionManager {
	
	public static MongoDatabase getConnection() throws Exception{
		try{
			MongoClient mongoClient = new MongoClient("localhost",27017);
			MongoDatabase db = mongoClient.getDatabase("markovharmony");		
			return db;
		}
		catch(Exception e){
			throw new Exception("The database could not be opened!");
		}
	}
	

}
