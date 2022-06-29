// Yumna Khan, Assignment #5, Bellevue College CS211
// Summary: This program calculates the number of permutations of a given set of numbers. Ex: the number of ways to select
// 5 cards from a deck of 52

public class recursive {
	public static void main(String[] args) {
		//calling method
		System.out.println(permut(5, 1));
		System.out.println(permut(55, 5));
		System.out.println(permut(52, 5));
	}
	public static int permut(int n, int r) {
		//throws illegal argument exception if r is less than 0 and n is less than r (online permutation calculator said n>=r>=0 has to be true)
		if ((r<0) || !(n >= r)) {
			throw new IllegalArgumentException();
		}
		//base case, when r is 0 the program returns 1
		if (r == 0) {
			return 1;
		}
		//recursive case, keeps running until base case is proven to be true (in-depth explanation in QA)
		else {
			return permut(n-1, r-1) * n;
		}
	}
}
