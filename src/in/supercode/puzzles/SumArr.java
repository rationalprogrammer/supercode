package in.supercode.puzzles;


/**
 * Given an array of integers and a sum, 
 * output the number of pairs  whose addition is equal to the given sum.
 * 
 *  Difficulty level for me : Easy
 * 
 * @author Gaurav Vishal
 */
public class SumArr {
	
	public static void main(String[] args) {
		
		int[] iArr = {1,2,3,4,6,8,9};
		final int sum = 9;
		int count = 0;
		
		for (int i=0; i<iArr.length; i++) {
			for (int j=i; j<iArr.length; j++) {
				if (iArr[i]+iArr[j] == sum) {
					System.out.println(iArr[i] + "+" + iArr[j] + "=" + sum);
					count++;
				}
			}
		}
	
		System.out.println("Total number of pairs = " + count);
	}
	

}
