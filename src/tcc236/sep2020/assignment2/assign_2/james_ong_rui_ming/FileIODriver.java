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

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIODriver {
	public static void main(String [] args) throws FileNotFoundException {
		FileIOModule file_module = new FileIOModule();
		Scanner file_locator = new Scanner(System.in);
		boolean file_validator = false;
		
		while (!file_validator) {
			System.out.println("Enter CSV file directory.");
			
			String file_path = file_locator.nextLine();		
			
			file_validator = (file_module.checkFileExists(file_path));
			
			if (file_validator) {
				file_locator.close();
				System.out.println("Valid CSV file.");
				file_module.readFile(file_path);
				
				break;
			}
			System.out.println("Not a valid CSV file, try again.");			
		}
	}
}
