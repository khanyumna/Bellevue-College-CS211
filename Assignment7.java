import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Name: Yumna Khan
// Class: CS211
// Date: May 20, 2022
// Instructor: Craig Niiyama
// Description: This program has a method that takes a stack of integer and puts 3 occurrences of each of the integers in the stack,
// and has another method that checks if two stacks are the same or not, and a last method that checks if the given stack/queue is a palindrome (mirrored)


public class Assignment7 {

	// the entry point of the class calling the test methods which in turn calling the assigned methods
	public static void main(String[] args) {
		testSeeingThreeMethod();
		testTwoStacksAreEqualMethod();
		testIsMirrored();
	
	}
	// pre : a stack of integers
	// post: every value in the stack is replaced with three occurrences of that value
	public static void seeingThree(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<Integer>(); //temporary stack
		while (!s.empty()) { 
			int x = s.pop(); //get int from original stack
			for (int i = 0; i < 3; i++) { 
				temp.push(x); //push 3 occurrences of that integer in temp stack
			}
		} 
		while (!temp.empty()) {
			s.push(temp.pop()); //push values into the OG stack to retain order.
		}
	    }
	    
	// pre : two stacks of integers
	// post: a boolean result of true if the stacks are equal or false if the stacks are not equal
	public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {
		Stack<Integer> s3 = new Stack<Integer>(); //new stack
		if (s1.size() != s2.size()) { //if stacks are not the same size, they are not equal
			return false;
		}
		else {
			while (!s1.empty() && !s2.empty()) { 
				if (s1.peek() == s2.peek()) { //if the values at the "top" are the same
					//pop both of the values, push them on to new stack
					int x = s1.pop();
					int y = s2.pop();
					s3.push(x);
				}
				else {
					while (!s3.empty()) {
						int z = s3.pop(); //push the values of new stack into s2 and s1 to retain order
						s2.push(z);
						s1.push(z);
					}
					return false; 
				}
			}
		}
		return true;  //return true when values at the top are the same each time.
	}

	// pre : a queue of integers
	// post: returns true if the numbers in the queue represent a palindrome (and false otherwise). 
	//       A sequence of numbers is considered a palindrome if it is the same in reverse order
	public static boolean isMirrored(Queue<Integer> q) {
		if (q.isEmpty()) { //if the queue is empty, it is a palindrome.
			return true;
		}
		Queue<Integer> copy = q; //copy of q 
		Stack<Integer> temp = new Stack<Integer>(); //temp stack
		while (!q.isEmpty()) { 
			int n = q.remove(); //remove values from q
			temp.push(n); //push on to temp
		}
		q = copy; 
		while (!temp.empty() && !q.isEmpty()) { //while temp and q are not empty
			int pop = temp.pop(); //pop from temp
			int x = q.remove(); //remove from q
			if (pop != x) { // if the values are not equal, the queue is not a palindrome (checking reverse stack with OG queue)
				return false;
			}
		} 
			return true; //if they are equal, then it is a palindrome
	}
	// This is a test method testing twoStacksAreEqual method. It test both the true case and the false case
	private static void testIsMirrored() {

		Queue<Integer> myQueueP  = new LinkedList<Integer>();;
	
		for (int i = 0; i < 5; i++)
		{
		
			System.out.print(i);
			myQueueP.add(i);
			
		}
		for (int i = 3; i >= 0 ; i--)
		{
			
			System.out.print(i);
			myQueueP.add(i);
				
		}
		
		
		System.out.println();
		
		System.out.println(isMirrored(myQueueP) + " isMirrord");
		
	}

	//test method to test the testTwoStacksAreEqualMethod. 
	//It tests cases of the same stack and not the same stack.
	private static void testTwoStacksAreEqualMethod() {
		Stack<Integer> myStack1  = new Stack<Integer>();	
		Stack<Integer> myStack2  = new Stack<Integer>();
		Stack<Integer> myStack3  = new Stack<Integer>();
		Stack<Integer> myStack4  = new Stack<Integer>();
	
		for (int i = 0; i < 5; i++)
		{
			myStack1.push(i);
			myStack2.push(i);
			myStack4.push(i);
		
		}
		for (int i = 0; i < 6; i++)
		{
			myStack3.push(i);
		
		}
	
		System.out.println(twoStacksAreEqual(myStack1,myStack2) + " Same Stack ");
		
		System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");
		
	}

	//Method to test the SeeingThree method
	private static void testSeeingThreeMethod() {
		Stack<Integer> myStack  = new Stack<Integer>();	
		
		for (int i = 0; i < 5; i++)
		{
			myStack.push(i);

		}
		
		
		System.out.println();
		print(myStack);
		
		seeingThree(myStack);
	
		print(myStack);
		
	}
	// pre : a stack of integers
	// post: prints out the stack of integers
	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();

		 while ( e.hasMoreElements() )
		      System.out.print( e.nextElement() + " " );
		    System.out.println();

	
	}

} //end of Assignment7