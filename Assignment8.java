//Heading: Yumna Khan, Assignment 8, Craig Niiyama, 5/27/2022
//Summary: This is the code where I tested all the methods I added to the ArrayIntList class.


public class Assignment8 {
	public static void main(String[] args) {
		//calling test methods
		testUpToNowTotal();
		testIsPairSorted();
		testRemoveLast();
		testReplaceAll();
	}
	
	//Testing method for upToNowTotal()
	public static void testUpToNowTotal() {
		System.out.println("Testing upToNowTotal():");
		ArrayIntList test1 = new ArrayIntList(3, 5, 4, 7, 8);
		ArrayIntList result1 = new ArrayIntList(3, 8, 12, 19, 27); //expected result (calculated on my own)
		System.out.println("Original list: " + test1);
		System.out.println("Result after call: " + test1.upToNowTotal()); //calling method
		if (test1.upToNowTotal().equals(result1)) { //checking if expected result matches call result
			System.out.println("Test Passed");
		}
		else { 
			System.out.println("Test Failed");
		}
		System.out.println();
	}
	
	//Testing method for isPairSorted()
	public static void testIsPairSorted() {
		System.out.println("Testing isPairSorted():");
		ArrayIntList test1 = new ArrayIntList(3, 5, 4, 7, 8);
		ArrayIntList test2 = new ArrayIntList(6, 3, 4, 7, 8);
		System.out.println(test1 + " " + test1.isPairSorted()); //should return true, returns true
		System.out.println(test2 + " " + test2.isPairSorted()); //should return false, returns false
		System.out.println();
	}
	
	//Testing method for removeLast() (removing the last 2 values of list)
	public static void testRemoveLast() {
		System.out.println("Testing removeLast():");
		ArrayIntList test1 = new ArrayIntList(3, 5, 4, 7, 8);
		ArrayIntList result = new ArrayIntList(3, 5, 4); //expected result
		System.out.println("Original list:" + test1);
		test1.removeLast(2); 
		System.out.println("Result after call: " + test1); //result after call
		if (test1.equals(result)) { // if expected result matches call result, test passed
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		System.out.println();
	}
	
	//Testing method for replaceAll (exercise) 
	public static void testReplaceAll() {
		System.out.println("Chapter 15 exercise (replace all 3s with 100s):");
		ArrayIntList test1 = new ArrayIntList(3, 2, 5, 12, 3, 3, 3, 9, 10, 12, 3);
		System.out.println("Original List: " + test1); 
		ArrayIntList result = test1.replaceAll(3, 100); 
		System.out.println("Result: " +result);
	}
}