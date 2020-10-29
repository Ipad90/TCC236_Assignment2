package tcc236.sep2020.assignment2.assign_2.james_ong_rui_ming;

/**
* Course Code : TCC236/05
* Course Title : Data Structures and Algorithms
* Student ID : 141190169, 141190132, 141190001
* Author : James Ong Rui Ming, Goh Loh Meng Sheng, Liew Jun Ping
* Date : TBD
* Honor Code : We pledge that this is our own program code.
* We received assistance from each other (group members) in understanding and debugging our program.
*/

import java.util.ArrayList;

/**
 * This class "SortingModule" contains the functions necessary to perform a 
 * Merge Sort algorithm
 */
public class SortingModule {
	private ArrayList<Double> array;

	public SortingModule(ArrayList<Double> array) {	
		this.array = array; 
	}
	
	/**
	 * 
	 * @return Returns sorted array
	 */
	public ArrayList<Double> getSortedArray() {
		return array;
	}
	
	/**
	 * Initializes the Merge Sort algorithm
	 */
	public void sort() {
		divider(0, array.size() - 1);
	}
	
	/**
	 * This function is a recursive function, that keeps repeating until the values within the
	 * ArrayList can no longer be divided.
	 * @param start_value
	 * @param end_value
	 */
	public void divider(int start_value, int end_value) {
		//  Divide until undividable
        if (start_value < end_value && (end_value - start_value) >= 1) {
            int middle_value = (end_value + start_value) / 2;
            divider(start_value, middle_value);
            divider(middle_value + 1, end_value);        
            
            merger(start_value, middle_value, end_value);            
        }       
    }
    
	/**
	 * 
	 * @param start_value
	 * @param middle_value
	 * @param end_value
	 */
    public void merger(int start_value, int middle_value, int end_value) {
        ArrayList<Double> merged_array = new ArrayList<Double>();
        
        int left_value = start_value;
        int right_value = middle_value + 1;
        
        while (left_value <= middle_value && right_value <= end_value) {
            if (array.get(left_value) <= array.get(right_value)) {
                merged_array.add(array.get(left_value));
                left_value++;
            } else {
                merged_array.add(array.get(right_value));
                right_value++;
            }
        }       
        
        while (left_value <= middle_value) {
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
}
