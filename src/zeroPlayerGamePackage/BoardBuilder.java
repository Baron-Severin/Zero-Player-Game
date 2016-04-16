package zeroPlayerGamePackage;

import java.util.ArrayList;

public class BoardBuilder {
	
	public final static int boardWidth = 20;
	public final static int boardHeight = 10;
	
	private static ArrayList<String> occupiedSquares = new ArrayList<String>();

	public static Boolean isSquareOpen(int positionX, int positionY) {
		String stringGrid = positionX + ", " + positionY;
		if (occupiedSquares.contains(stringGrid) || positionX > boardWidth || positionX < 0 
				|| positionY > boardHeight || positionY < 0) {
			return false;
		} else {
			return true;
		}
	}  // end isSquareOpen
	
	public static void addToOccupiedSquares(int positionX, int positionY) {
		if (isSquareOpen(positionX, positionY)==true){
		    String stringGrid = positionX + ", " + positionY;
		    occupiedSquares.add(stringGrid);
		} else {
	    	System.out.println("Position passed to BoardBuilder.addToOccupiedSquares already found to be occupied by BoardBuilder.isSquareOpen");
	    	new Exception().printStackTrace();
		}
	}  // end addToOccupiedSquares
	
	public static void removeFromOccupiedSquares(int positionX, int positionY) {
		if (isSquareOpen(positionX, positionY)==false){
		    String stringGrid = positionX + ", " + positionY;
		    occupiedSquares.remove(stringGrid);
		} else {
	    	System.out.println("Position passed to BoardBuilder.removeFromOccupiedSquares not found to be occupied by BoardBuilder.isSquareOpen");
	    	new Exception().printStackTrace();
		}
	}  // end removeFromOccupiedSquares
	
	public static ArrayList<String> eightDirections() {
		ArrayList<String> directions = new ArrayList<String>();
		directions.add("N");
		directions.add("NE");
		directions.add("E");
		directions.add("SE");
		directions.add("S");
		directions.add("SW");
		directions.add("W");
		directions.add("NW");
		return directions;
	}
	
}
