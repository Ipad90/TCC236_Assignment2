package file_io;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIOModule implements FileIOInterface {
	File f;
	
	@Override
	public ArrayList<Double> readFile(String file_path) {
		int lines = 0;
		ArrayList<Double> values = new ArrayList<Double>();
		String new_line;
		Double new_value;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file_path));
			while((new_line = reader.readLine()) != null) {
				new_value = Double.parseDouble(new_line);
				values.add(new_value);
				lines++;
			}
			reader.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return values;
	}

	@Override
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
	
	public boolean checkFileExists(String file_path) {
		f = new File(file_path);
		return f.exists() && !f.isDirectory();
	}
}