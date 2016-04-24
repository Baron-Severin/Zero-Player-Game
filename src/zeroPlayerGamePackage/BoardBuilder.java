package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardBuilder {
	
	public final static int BOARD_WIDTH = 20;
	public final static int BOARD_HEIGHT = 10;
	
	private static ArrayList<PositionObject> occupiedSquares = new ArrayList<PositionObject>();
	
	static HashMap<String, PositionObject> team0RegimentLocations = new HashMap<String, PositionObject>();
	static HashMap<String, PositionObject> team1RegimentLocations = new HashMap<String, PositionObject>();

	
	public static Boolean isSquareOpen(PositionObject position) {
		if (occupiedSquares.contains(position) || position.getPositionX() > BOARD_WIDTH 
				|| position.getPositionX() < 0 || position.getPositionY() > BOARD_HEIGHT 
				|| position.getPositionY() < 0) {
			return false;
		} else {
			System.out.println("Position " + position.getPositionX() + ", " + position.getPositionY() + " is open");
			return true;
		}
	}  // end isSquareOpen
	
	public static void addToOccupiedSquares(PositionObject position) {
		if (isSquareOpen(position)==true){
		    occupiedSquares.add(position);
		} else {
	    	System.out.println("Position passed to BoardBuilder.addToOccupiedSquares already found to be occupied by BoardBuilder.isSquareOpen");
	    	new Exception().printStackTrace();
		}
	}  // end addToOccupiedSquares
	
	public static void removeFromOccupiedSquares(PositionObject position) {
		if (isSquareOpen(position)==false){
		    occupiedSquares.remove(position);
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
		System.out.println(directions);
		return directions;
	};  // end eightDirections
	
}  // end BoardBuilder
