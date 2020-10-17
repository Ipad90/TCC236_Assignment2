package file_io;

import java.io.IOException;
import java.util.ArrayList;

public interface FileIOInterface {
	public ArrayList<Double> readFile(String file_name);
	public void writeFile(ArrayList<Double> data, String file_name) throws IOException;
	public boolean checkFileExists(String file_name);
}
