package sorting;

import java.util.ArrayList;

public class SortingDriver {
	public static void main(String [] args) {
		ArrayList<Double> data = new ArrayList<Double>();
		
		for (int i = 0; i < 10; i++) {
			data.add((double) i);
		}
		
		SortingModule sort = new SortingModule(data);
		sort.sort();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(data.get(i)); 			
		}
	}
}
