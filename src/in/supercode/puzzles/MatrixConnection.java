package in.supercode.puzzles;

/**
 * 
 * Given a matrix consisting of only zeroes and ones.
 * Cell containing 1 is available for connection and cell with 0 is not. 
 * The task is to find how many number of unique connections that can be made with adjacent cells (on all 8 sides).
 * 
 * 	1	0	0	1
 * 	0	1	1	1
 * 	1	0	0	1
 * 
 * In this case the answer is 8
 * 
 * Difficulty level = Easy
 * 
 * 
 * @author Gaurav Vishal
 *
 */
public class MatrixConnection {
	
	public static void main(String[] args) {
		
		int[][] table = new int[][]{{1,0,0,1},{0,1,1,1},{1,0,0,1}};
		System.out.println("rows=" + table.length);
		System.out.println("cols=" + table[0].length);
		
		int totCount = 0;
		
		for (int i=0; i<table.length; i++) {
			for (int j=0; j<table[0].length; j++) {
				totCount += countAround(table, i, j);
			}
		}
		
		// divide by 2
		totCount = totCount/2;
		
		System.out.println(totCount);
		
	}
	
	private static int countAround(int[][] table, int rowIn, int colIn) {
		
		//System.out.println("rowIn=" + rowIn + ", colIn=" + colIn);
		// exit if zero
		if (table[rowIn][colIn] == 0)
			return 0;
		
		int adCount = 0;
		
		for (int x=rowIn-1; x<=rowIn+1; x++) {
			for (int y=colIn-1; y<=colIn+1; y++) {
				if (x < 0 || x > table.length-1)
					continue;
				if (y < 0 || y > table[0].length-1)
					continue;
				if (x == rowIn && y == colIn)
					continue;				
				
				if (table[x][y] == 1) {					
					adCount++;
					//System.out.println("table[" + x + "][" + y + "]=" + table[x][y]);
				}
			}
			
		}
		//System.out.println("----------------- count=" + adCount);
		return adCount;
		
	}

}
