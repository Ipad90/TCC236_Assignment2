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

public interface SortingInterface {
	public ArrayList<Double> sort(ArrayList<Double> data);
	public void merge(ArrayList<Double> left, ArrayList<Double> right, ArrayList<Double> data);
}
