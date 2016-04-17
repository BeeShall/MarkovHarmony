package markovharmony.db;

import com.mongodb.client.MongoDatabase;

public class startDatabase {

	public static void start() {
		// TODO Auto-generated method stub
		try {
			MongoDatabase db = DBConnectionManager.getConnection();
			db.createCollection("Songs");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		}

	}

}
