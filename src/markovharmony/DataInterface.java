package markovharmony;

<<<<<<< HEAD
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DataInterface {

	public static void main(String[] args){
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("test");
		db.getCollection("myCollection").insertOne(
		        new Document("name","Bishal Regmi")
		        		.append("Company", "Ramapo"));
	}
=======
public class DataInterface 
{
	
>>>>>>> b27bb35ceb26acf0c31107a7cbae3002c0f4486c
}
