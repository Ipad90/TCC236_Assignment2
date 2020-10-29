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
import java.util.ArrayList;

public interface FileIOInterface {
	public ArrayList<Double> readFile(String file_name);
	public void writeFile(ArrayList<Double> data, String file_name) throws IOException;
	public boolean checkFileExists(String file_name);
}
