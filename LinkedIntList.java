import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// A LinkedIntList object can be used to store a list of integers.
public class LinkedIntList {
    private ListNode front;   // node holding first value in list (null if empty)
    private String name = "front";   // string to print for front of list
    
    // Constructs an empty list.
    public LinkedIntList() {
        front = null;
    }
    
    // Constructs a list containing the given elements.
    // For quick initialization via Practice-It test cases.
    public LinkedIntList(int... elements) {
        this("front", elements);
    }
    
    public LinkedIntList(String name, int... elements) {
        this.name = name;
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
        }
    }
    
    // Constructs a list containing the given front node.
    // For quick initialization via Practice-It ListNode test cases.
    private LinkedIntList(String name, ListNode front) {
        this.name  = name;
        this.front = front;
    }
    
    // Appends the given value to the end of the list.
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            } 
            current.next = new ListNode(value);
        }
    }
    
    // Inserts the given value at the given index in the list.
    // Precondition: 0 <= index <= size
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            } 
            current.next = new ListNode(value, current.next);
        }
    }
    
    public boolean equals(Object o) {
        if (o instanceof LinkedIntList) {
            LinkedIntList other = (LinkedIntList) o;
            return toString().equals(other.toString());   // hackish
        } else {
            return false;
        }
    }
    
    // Returns the integer at the given index in the list.
    // Precondition: 0 <= index < size
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Removes the value at the given index from the list.
    // Precondition: 0 <= index < size
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
    
    // Returns the number of elements in the list.
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Returns a text representation of the list, giving
    // indications as to the nodes and link structure of the list.
    // Detects student bugs where the student has inserted a cycle
    // into the list.
    public String toFormattedString() {
        ListNode.clearCycleData();
        
        String result = this.name;
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            result += " -> [" + current.data + "]";
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += " /";
        }
        
        return result;
    }
    
    // Returns a text representation of the list.
    public String toString() {
        return toFormattedString();
    }
    
    // Returns a shorter, more "java.util.LinkedList"-like text representation of the list.
    public String toStringShort() {
        ListNode.clearCycleData();
        
        String result = "[";
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            if (result.length() > 1) {
				result += ", ";
			}
            result += current.data;
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += "]";
        }
        
        return result;
    }
    

    // ListNode is a class for storing a single node of a linked list.  This
    // node class is for a list of integer values.
    // Most of the icky code is related to the task of figuring out
    // if the student has accidentally created a cycle by pointing a later part of the list back to an earlier part.

    public static class ListNode {
        private static final List<ListNode> ALL_NODES = new ArrayList<ListNode>();
        
        public static void clearCycleData() {
            for (ListNode node : ALL_NODES) {
                node.visited = false;
                node.cycle = false;
            }
        }
        
        public int data;          // data stored in this node
        public ListNode next;     // link to next node in the list
        public boolean visited;   // has this node been seen yet?
        public boolean cycle;     // is there a cycle at this node?

        // post: constructs a node with data 0 and null link
        public ListNode() {
            this(0, null);
        }

        // post: constructs a node with given data and null link
        public ListNode(int data) {
            this(data, null);
        }

        // post: constructs a node with given data and given link
        public ListNode(int data, ListNode next) {
            ALL_NODES.add(this);
            this.data = data;
            this.next = next;
            this.visited = false;
            this.cycle = false;
        }
        
        public ListNode __gotoNext() {
            return __gotoNext(true);
        }
        
        public ListNode __gotoNext(boolean checkForCycle) {
            if (checkForCycle) {
                visited = true;
                
                if (next != null) {
                    if (next.visited) {
                        // throw new IllegalStateException("cycle detected in list");
                        next.cycle = true;
                    }
                    next.visited = true;
                }
            }
            return next;
        }
    }
    
    //Pre: LinkedIntList, an integer n
    //Post: Method checks and returns the last index (appearance) of n. returns -1 if n is not in list
    public int lastIndexOf(int n) { 
    	ListNode current = front;
    	int index = -1;
    	int i = 0;
    	while (current != null) { //while list is not empty
    		if (current.data == n) { //if current is equal to n
    			index = i; // set index to i
    		} 
    		i++; //increment i (index)
    		current = current.next; //move to next element
    	}
    	return index;
    }
    
    //Pre: LinkedIntList
    //Post: Method counts how many duplicates of any number there are. Ex: [1, 1, 1] would mean there are 2 duplicates of 1
    public int countDuplicates(){
    	ListNode current = front;
    	int duplicate = 0;
    	int number = current.data;
    	current = current.next;
    	while (current != null) { //while list is not empty
    		if (number == current.data) { //if the number is equal to next number
    			duplicate++;  //increment duplicate
    		}
    		else {
    			number = current.data; //go to next number
    		}
    		current = current.next; //check with "next-next" number
    	} 
    	return duplicate;
    }
    
    //Pre: LinkedIntList
    //Post: Returns true if there are two numbers adjacent to each other that are also consecutive values. Returns false otherwise
    public boolean hasTwoConsecutive() {
    	ListNode current = front;
    	int number = current.data;
    	current = current.next;
    	while (current != null) { //while list is not empty
    		if ((current.data - number) == 1) { //if the difference between next element and current element is 1, they are consecutive
    			return true;
    		}
    		number = current.data; //move to next numbers
    		current = current.next;
    	}
    	return false;
    }
    
    //Pre:LinkedIntList
    //Post: Removes and returns the last value of the list.
    public int deleteBack() {
    	ListNode current = front;
    	ListNode temp = current;
    	if (current == null) { //if list is empty, throw exception
    		throw new NoSuchElementException();
    	}
    	while (current.next != null) { //while list is not empty
    		temp = current; //set temp to value before end of list
    		current = current.next;
    	}
    	temp.next = null; //set the value after temp to null
    	return current.data; // return removed number
    }
}
