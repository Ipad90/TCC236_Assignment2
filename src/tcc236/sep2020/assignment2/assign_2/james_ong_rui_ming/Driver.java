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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Driver {
	/**
	 * If file entered is sortDesc300000.csv, a new file named SortedsortDesc300000.csv will be created
	 * which contains the values of the sorted array
	 */
	public static void main(String [] args) throws IOException {
		String file_sizes[] = { "100", "1000", "5000", "10000", "50000", "100000", "150000", "200000", "250000", "300000" };
		String file_prefix[] = { "sortAsc", "sortDesc", "rand" };
		
		FileIOModule file_module = new FileIOModule();
		Scanner file_locator = new Scanner(System.in);
		
		boolean file_validator = false;
		ArrayList<Double> values;
		ArrayList<Double> sorted_array;
		
		//	Repeats until a valid CSV file directory has been entered
		while (!file_validator) {
			System.out.println("Enter CSV file directory.");
			
			String file_path = file_locator.nextLine();		
			
			for (String prefix : file_prefix) {
				System.out.println("----- " + prefix + " -----");
				for (String sizes : file_sizes) {
					String file_location = file_path + "\\" + prefix + sizes + ".csv";
					String sorted_file_location = file_path + "\\Sorted\\" + prefix + sizes + ".csv";
					file_validator = (file_module.checkFileExists(file_location));
					
					if (file_validator) {
						file_locator.close();						
						values = file_module.readFile(file_location);
						SortingModule sort_module = new SortingModule(values);
		
						long start_time = System.nanoTime();
						
//						System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
						
						sort_module.sort();
						
//						System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
						sorted_array = sort_module.getSortedArray();
						
						long end_time = System.nanoTime();
						long time_taken = end_time - start_time;
						time_taken /= 1000000;
		
						file_module.writeFile(sorted_array, sorted_file_location);
						
						System.out.println(prefix + sizes + ", Time taken (Milliseconds): " + time_taken);
					} else {
						System.out.println("Not a valid CSV file, try again.");									
					}
				}
			}
			
		}
	}
}
