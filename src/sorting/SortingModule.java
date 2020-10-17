package sorting;

import java.util.ArrayList;

public class SortingModule {
	private ArrayList<Double> array;

	public SortingModule(ArrayList<Double> array) {	
		this.array = array; 
	}
	
	public ArrayList<Double> getSortedArray() {
		return array;
	}
	
	public void sort() {
		divider(0, array.size() - 1);
	}
	
	public void divider(int start_value, int end_value) {
        if (start_value < end_value && (end_value - start_value) >= 1) {
            int mid = (end_value + start_value) / 2;
            divider(start_value, mid);
            divider(mid + 1, end_value);        
            merger(start_value, mid, end_value);            
        }       
    }   
    
    public void merger(int start_value, int midIndex, int end_value) {
        ArrayList<Double> merged_array = new ArrayList<Double>();
        
        int left_value = start_value;
        int right_value = midIndex + 1;
        
        while (left_value <= midIndex && right_value <= end_value) {
            if (array.get(left_value) <= array.get(right_value)) {
                merged_array.add(array.get(left_value));
                left_value++;
            } else {
                merged_array.add(array.get(right_value));
                right_value++;
            }
        }       
        
        while (left_value <= midIndex) {
            merged_array.add(array.get(left_value));
            left_value++;
        }
        
        while (right_value <= end_value) {
            merged_array.add(array.get(right_value));
            right_value++;
        }
        
        int i = 0;
        int j = start_value;

        while (i < merged_array.size()) {
            array.set(j, merged_array.get(i++));
            j++;
        }
    }

	public void testing() {
		int data_length = array.size();
		
		for (int i = 0; i < data_length; i++) {
			System.out.println(array.get(i));
		}
	}
}
