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

import java.io.*;
import java.util.ArrayList;

public class FileIOModule implements FileIOInterface {
	File f;

	/**
	 * This function reads the CSV file provided
	 * @param file_path - File path for file to be read
	 * @return Returns an ArrayList for Double values
	 */
	public ArrayList<Double> readFile(String file_path) {
		ArrayList<Double> values = new ArrayList<Double>();
		String new_line;
		Double new_value;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file_path));
			while((new_line = reader.readLine()) != null) {
				new_value = Double.parseDouble(new_line);
				values.add(new_value);
			}
			reader.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return values;
	}

	/**
	 * @param data - the array list with data
	 * @param file_directory - file directory of the data 
	 */
	public void writeFile(ArrayList<Double> data, String file_directory) throws IOException {
		File file_joiner;
		String file_name = f.getName();

		file_name = "Sorted" + file_name;
		file_directory = f.getParent();
		file_joiner = new File(file_directory, file_name);
		file_directory = file_joiner.getPath();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file_directory));
		file_name = "Sorted" + file_name;
		int size = data.size();

		for (int i = 0; i < size; i++) {
			writer.write(data.get(i).toString());
			writer.newLine();
		}
		
		writer.close();
	}
	
	/**
	 * @param file_path
	 * @return Returns Boolean value on whether file exists or not
	 */
	public boolean checkFileExists(String file_path) {
		f = new File(file_path);
		return f.exists() && !f.isDirectory();
	}
}
