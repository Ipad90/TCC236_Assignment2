package file_io;

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
