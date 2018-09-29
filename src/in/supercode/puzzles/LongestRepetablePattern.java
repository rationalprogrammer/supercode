package in.supercode.puzzles;

/**
 * Class that finds the longest repeatable pattern.
 * If the 2 patterns of similar length are found then the first one will prevail
 * 
 * @author Gaurav Vishal
 *
 */
public class LongestRepetablePattern {
	
	private static String longestPattern(String pattern) {
		
		if (pattern == null) {
			throw new RuntimeException("Pattern cannot be null");
		}
		
		String p = "";
		String temp = ""; 
		char[] cArr = pattern.toCharArray();
		
		for (int i=0; i<cArr.length; i++) {
			
			//System.out.println("i=" + i);
			
			// first one assign
			if (i == 0) {
				p += cArr[0];
			}
			
			// last one? break
			if (i == cArr.length-1) {
				break;
			}
			
			if (cArr[i] == cArr[i+1]) {
				temp += cArr[i];
			}
			else {
				// if not same then check if the preview was same?
				if ((i != 0) && (cArr[i] == cArr[i-1])) {
					temp += cArr[i];
					// check if the length of this is more than the previous one?
					if (p.length() < temp.length()) {
						p = new String(temp);
					}					
				}
				// reset
				temp = "";
			}			
		} // end of loop
		return p;		
	}	
	
	private static boolean assertTrue(String pattern, String correctAnswer) {		
		return longestPattern(pattern).equals(correctAnswer);
	}
	
	// test
	public static void main(String[] args) {
		
		System.out.println(assertTrue("hellllloworrrrlllllddd", "lllll"));
		System.out.println(assertTrue("he", "h"));
		System.out.println(assertTrue(null, "kk"));
		System.out.println(assertTrue("", ""));
		System.out.println(assertTrue("", ""));
		
	}

}
