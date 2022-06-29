// Yumna Khan, Craig Niiyama, CS211, Bellevue College
// Assignment #6

import java.util.*;

public class BogoSort {
	
	public static void main(String[] args) {
		
	
	int[] myArray = {42, 13, 19, 83, 23, 64, 26, 87, 34, 99, 62}; //final list I tested
	final long startTime = System.currentTimeMillis(); //starting timer
	bogoSort(myArray); //method call
	final long endTime = System.currentTimeMillis(); //ending timer
	printArray(myArray);
	System.out.println("Total execution time: " + (endTime - startTime) + " ms"); //printing time
		
	}





	// Places the elements of a into sorted order.
	public static void bogoSort(int[] a) {
		while (!isSorted(a)) {
			shuffle(a);
		}
		
	}
	// Returns true if a's elements are in sorted order.
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) { //for each element in list
			if (a[i] > a[i+1]) { //if the first element is greater than the element after it, the list is not sorted
				return false;
			}
		}
		return true; //otherwise, it is sorted
	}
	// Shuffles an array of ints by randomly swapping each
	// element with an element ahead of it in the array.
	public static void shuffle(int[] a) {
		Random rand = new Random();
		for (int i = 0; i < a.length - 1; i++) { //for each element in list
			int j = rand.nextInt((i+1), a.length); //find random integer where the index is greater than i and smaller than list length
			swap(a, i, j); //swap
		} 

	}
	// Swaps a[i] with a[j].
	public static void swap(int[] a, int i, int j) {
		//typical swap method. use variable temp, set it as i. then set i to j, and j to temp (i).
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void printArray(int[] a)
	{
		for(int i=0; i < a.length; i++)
		{
			System.out.println(a[i]);
			
		}
	}
	
}//end of BogoSort class






