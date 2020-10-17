package tcc236.sep2020.assignment2.assign_2.james_ong_rui_ming;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import file_io.FileIOModule;
import sorting.SortingModule;

public class Driver {
	public static void main(String [] args) throws IOException {
		FileIOModule file_module = new FileIOModule();
		Scanner file_locator = new Scanner(System.in);
		
		boolean file_validator = false;
		ArrayList<Double> values;
		ArrayList<Double> sorted_array;
		
		while (!file_validator) {
			System.out.println("Enter CSV file directory.");
			
			String file_path = file_locator.nextLine();		
			
			file_validator = (file_module.checkFileExists(file_path));
			
			if (file_validator) {
				file_locator.close();
				System.out.println("Valid CSV file.");
				values = file_module.readFile(file_path);
				SortingModule sort_module = new SortingModule(values);

				long start_time = System.nanoTime();
				
				sort_module.sort();
				
				sorted_array = sort_module.getSortedArray();
				
				long end_time = System.nanoTime();
				long time_taken = end_time - start_time;
//				time_taken /= 1000000;
				
				file_module.writeFile(sorted_array, file_path);
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
				System.out.println("Time taken: " + time_taken);
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
				break;
			}
			System.out.println("Not a valid CSV file, try again.");			
		}
	}
}
