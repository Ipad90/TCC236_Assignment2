package sorting;

import java.util.ArrayList;

public interface SortingInterface {
	public ArrayList<Double> sort(ArrayList<Double> data);
	public void merge(ArrayList<Double> left, ArrayList<Double> right, ArrayList<Double> data);
	public void testing(ArrayList<Double> data);
}
