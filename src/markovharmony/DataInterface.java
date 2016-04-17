package markovharmony;

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
}
