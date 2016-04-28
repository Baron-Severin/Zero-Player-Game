package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardBuilder {
	
	public final static int BOARD_WIDTH = 40;
	public final static int BOARD_HEIGHT = 15;
	public final static int REGIMENTS_PER_TEAM = 25;
	
	private static ArrayList<PositionObject> occupiedSquares = new ArrayList<PositionObject>();
	
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
		return directions;
	};  // end eightDirections
	
	public PositionObject suggestRegimentPlacement(ArrayList<PositionObject> baseLocations) {
		
		int base = randomBase(baseLocations);
		
		int baseX = baseLocations.get(base).getPositionX();
		int baseY = baseLocations.get(base).getPositionY();
		
		// this results in a random number between -3 and +3
		int randomNum = (int) ((Math.random() * 7) - 3);
		baseX += randomNum;
		
		randomNum = (int) ((Math.random() * 7) - 3);
		baseY += randomNum;
		
		PositionObject position = new PositionObject(baseX, baseY);
		
		if (position.getPositionX() < 0 || position.getPositionY() < 0
				|| position.getPositionX() > BoardBuilder.BOARD_WIDTH - 1 
				|| position.getPositionY() > BoardBuilder.BOARD_HEIGHT - 1) {
			position = suggestRegimentPlacement(baseLocations);
		}  // end if statement
        
		return position;
		
	}  // end suggestRegimentPlacement

	private int randomBase(ArrayList<PositionObject> baseLocations) {
		
		int base = (int) (Math.random() * baseLocations.size());
		return base;
		
	}  // end randomBase
	
	
}  // end BoardBuilder
