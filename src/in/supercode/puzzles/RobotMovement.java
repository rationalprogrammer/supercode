package in.supercode.puzzles;


/**
 *  A robot can only move in four directions , UP(U), DOWN(D),LEFT(L),RIGHT(R). 
 *  Given a string consisting of instructions to move , output the co-ordinates 
 *  of robot after the executing the instructions. 
 *  Initial position of robot is at origin(0,0).
 *  
 *  Difficulty level for me : Easy
 * 
 * @author Gaurav Vishal
 *
 */
public class RobotMovement {
	
	// test method
	public static void main(String[] args) {
		
		Coord co = new Coord(0,0);
		String commandString = "UUURRDDRUULLDD";
		
		
		char[] ca = commandString.toCharArray();
		for (char c : ca) {
			Move m = Move.of(c);
			if (m == null)
				continue;
			co = co.nextMove(m);
		}
		
		System.out.println(co);		
	}
	
	
	/**
	 * private class for cordinates
	 * @author 
	 *
	 */
	public static class Coord {
		private int x;
		private int y;
		
		// constructor
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int x() {
			return x;
		}
		
		public int y() {
			return y;
		}
		
		public Coord nextMove(Move m) {
			return new Coord(this.x + m.getX() , this.y + m.getY());
		}

		@Override
		public String toString() {
			return "Coord [x=" + x + ", y=" + y + "]";
		}			
	}
	
	/**
	 * The movement of UP and down 
	 * @author Gaurav
	 *
	 */
	public enum Move {
		
		U(0,1), 
		D(0,-1), 
		R(1,0), 
		L(-1,0);
		
		private int x;
		private int y;
		
		private Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public static Move of(char c) {
			try {
				return valueOf(""+c);
			} catch (IllegalArgumentException e) {
				return null;
			}			
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}

}
