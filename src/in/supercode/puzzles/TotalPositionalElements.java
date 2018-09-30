package in.supercode.puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a matrix of integers, task is to find out number of positional elements. 
 * A positional element is one which is either minimum or maximum in a row or in a column. 
 * If there are multiple minimum or maximum elements in a row or a column, return -1.
 * e.g.,
 * 
 * 	1	3	4
 * 	5	2	9
 * 	8	7	6
 * 
 * In this case the answer is 7, remove duplicates
 * 1,4,2,9,6,8,7
 * 
 * Difficulty level : Easy 
 * 
 * 
 * @author Gaurav Vishal
 *
 */
public class TotalPositionalElements {
	
	public static void main(String[] args) {
		
		// holds unique value
		Set<Integer> iSet = new HashSet<>();
		
		int[][] table = {{1,3,4},{5,2,9},{8,7,6}};
		int rowCount = table.length;
		int colCount = table[0].length;
		
		// for rows
		for (int i=0; i<rowCount; i++) {
			int[] row = row(table, i); 
			Arrays.sort(row);			
			iSet.add(row[0]);
			iSet.add(row[colCount-1]);
		}
		
		// for columns
		for (int i=0; i<colCount; i++) {
			int[] col = col(table, i); 
			Arrays.sort(col);			
			iSet.add(col[0]);
			iSet.add(col[rowCount-1]);
		}
		
		
		//System.out.println(Arrays.toString(row(table, 1)));
		//System.out.println(Arrays.toString(col(table, 0)));
		
		System.out.println("Count=" + iSet.size());
		System.out.println(Arrays.toString(iSet.toArray(new Integer[] {})));
		
	}		
	
	private static int[] col(int[][] table, int colIndex) {
		int[] col = new int[table.length];
		// count rows
		for (int i=0; i<table.length; i++) {
			col[i] = table[i][colIndex];
		}
		return col;
	}
	
	private static int[] row(int[][] table, int rowIndex) {
		int[] row = new int[table.length];
		// count cols
		for (int i=0; i<table[0].length; i++) {
			row[i] = table[rowIndex][i];
		}
		return row;
	}

}
