package in.supercode.puzzles;

import java.util.Arrays;

/**
 * Choose any 5 digits
 * scramble them to make numbers
 * Given a number made from those 5 digits (may NOT be unique), find what should be 
 * the next number
 * 
 * The algo
 * 1. Check if the numbers are in descending order, if yes, then you have found the answer.
 * 2. If no find a pivot number and then arrange in ascending order the next set
 * 
 * Difficulty level : Hard
 * 
 * @author Gaurav
 *
 */
public class NextNum {
	
	// only positive integers
	private static int next(int number) {
		
		// find the number
		String sn = ""+number;
		// split the numbers into int array
		int[] digits = new int[sn.length()];	
		char[] ca = sn.toCharArray(); 
		for (int i=0; i<sn.length(); i++) {			
			digits[i] = Integer.parseInt(""+ca[i]);
		}
				
		// if descending then return same array
		if (isDesc(digits))
			return number;
		
		// else find the pivot from which the number is descending
		int pin = findPivotIndex(digits);
		// check. Should not come here as we have already made a check above
		// nevertheless
		if (pin == -1) {
			return number;
		}
		
		// once you get the pivot index
		// 1. split the array into 2 parts
		// 2. then find the next number for the second half
		
		int[] firstHalf =  copy(digits, 0, pin-1);
		int[] secondHalf = copy(digits, pin, digits.length-1);
		
		// the second half must then be arranged in sorted order
		int[] sortedSecHalf = sortByNextBigNum(secondHalf);
		
		// combine the two arrays and get the number
		int[] numArr = combine(firstHalf, sortedSecHalf);
		
		return convert(numArr) ;
		
	}
	
	private static int[] combine(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length+arr2.length];
		for (int i=0; i<arr1.length; i++) {
			arr[i] = arr1[i];
		}
		for (int i=0; i<arr2.length; i++) {
			arr[i+arr1.length] = arr2[i];
		}
		return arr;
	}
	
	// the number is scanned from right to left
	private static int findPivotIndex(int... iArr) {
		// start last but 1
		for (int i=iArr.length-2; i>=0; i--) {
			if (iArr[i] < iArr[i+1]) 
				return i;			
		}		
		// nothing found? return -1
		// it tells it is sorted in descending order
		return -1;
	}
	
	// copy from index to index both inclusive
	private static int[] copy(int[] iArr, int fromIndex, int toIndex) {
		int[] ia = new int[toIndex-fromIndex+1];
		for (int i=fromIndex, j=0; i<=toIndex; i++, j++) {
			ia[j] = iArr[i];
		}
		return ia;
	}
			
	private static int convert(int... digits) {
		int factor = 1;
		int num = 0;
		for (int i=digits.length-1; i>=0; i--) {
			num += digits[i]*factor;
			factor *= 10;
		}
		return num;
	}
	
	/**
	 * Take out the first number and see what is the biggest number in that array
	 * put that number in front and put the remaining numbers in ascending order. 
	 * 
	 * @param iArr
	 * @return
	 */
	private static int[] sortByNextBigNum(int... iArr) {
		
		// 1. find the first num
		// 2. sort the array
		// 3. see which index is bigger than the first array
		// 4. swap with that number
		int firstNum = iArr[0];
		Arrays.sort(iArr);
		int bigIndex = -1;
		
		for (int i=0; i<iArr.length; i++) {
			if (iArr[i] > firstNum) {
				bigIndex = i;
				break;
			}			
		}
		
		// it is already sorted
		if (bigIndex == -1)
			return iArr;
		
		// swap with first number
		int temp = iArr[bigIndex];
		iArr[bigIndex] = iArr[0];
		iArr[0] = temp;	
		
		// bug...
		// now take out the first element and then arrange the numbers in ascending order
		// and then join back
		int first = iArr[0];
		int[] others = copy(iArr, 1, iArr.length-1);
		Arrays.sort(others);
		iArr = combine(new int[]{first}, others);
		
		return iArr;				
	}
	
	// check if the values of the array are in descending
	// this gives the largest number
	private static boolean isDesc(int... iArr) {
		//choose the largest number
		int prev = iArr[0];				
		// ignore the first number, start with first
		for (int i=1; i<iArr.length; i++) {
			if (iArr[i] > prev)
				return false;
			else 
				prev = iArr[i];
		}
		return true;
	}

	private static int print(int num) {
		int nextNum = next(num);
		System.out.println(num + "->" + nextNum);
		return nextNum;
	}
	
	
	// print all numbers after it
	public static void main(String[] args) {
		
		//print(56983);
				
		int start = 5138;
		while (true) {
			 int s = print(start);
			 if (s == start)
				 break;
			 start = s;
		}

	}
	
}


