package markovharmony.db;


import java.util.ArrayList;
public class DataInterface {
		
	public static void main(String[] args){		
		try {
			DBOperations operations = new DBOperations();
			ArrayList<ArrayList<Integer>> els = operations.getFilteredData("OMI",null,null,"",null);
			for(ArrayList<Integer> el: els){
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
