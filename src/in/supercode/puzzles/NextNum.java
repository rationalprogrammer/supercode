package in.supercode.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Choose any 5 digits
 * scramble them to make numbers
 * Given a number made from those 5 digits (may NOT be unique), find what should be 
 * the next number
 * 
 * 1. test case - find all numbers and sort them. Use them to test
 * 
 * @author Gaurav
 *
 */
public class NextNum {
	
	
	private static int next(int number) {
		
		String sn = ""+number;
		int[] nArr = new int[sn.length()];
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		
		
		
		
//		TestNextNum tnn = new TestNextNum(23456);
//		tnn.testFact();
	}

}

/**
 * The test class for testing the numbers.
 * This will also find all numbers that can be created by
 * scrambling a number. Just sort them after that
 * 
 * @author Gaurav 
 *
 */
class TestNextNum {
	
	// > 2 digits but <= 6
	private int baseNum;
	private int[] allNum;
	
	private static int fact(int num) {
		if (num <= 1)
			return 1;
		else {
			int f = num;
			while (num > 1) {
				f *= (--num);
			}
			return f;
		}
	}
	
	// constructor
	public TestNextNum(int baseNum) {
		// get the length, and create an array
		//allNum = new int[fact((""+baseNum).length())];
		List<Integer> iList = new ArrayList<>(100);
		
		// scramble and add to list
	}
	
	public void testFact() {
		System.out.println(fact(0));
		System.out.println(fact(1));
		System.out.println(fact(2));
		System.out.println(fact(3));
		System.out.println(fact(4));
		System.out.println(fact(5));
		System.out.println(fact(6));
	}	
	
}
