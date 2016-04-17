package markovharmony.db;


import java.util.Collection;
public class DataInterface {
		
	public static void main(String[] args){		
		try {
			DBOperations operations = new DBOperations();
			Collection<Collection<Integer>> els = operations.getAllProgressions();
			for(Collection<Integer> el: els){
				for(Integer chord: el){
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
