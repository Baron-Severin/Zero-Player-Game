package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class HasGridPosition {
	
	private int positionX;
	private int positionY;
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionX(int newX) {
		positionX = newX;
	}
	
	public void setPositionY(int newY) {
		positionY = newY;
	}

	public PositionObject directionToSquare(String direction) {
		
		int checkX = 0;
		int checkY = 0;
		
		switch (direction.toUpperCase()) {
		    case "N":
		    	checkX = this.getPositionX();
		    	checkY = this.getPositionY() + 1;
		    	break;
		    case "NE":
		    	checkX = this.getPositionX() + 1;
		    	checkY = this.getPositionY() + 1;
		    	break;
		    case "E":
		    	checkX = this.getPositionX() + 1;
		    	checkY = this.getPositionY();
		    	break;
		    case "SE":
		    	checkX = this.getPositionX() + 1;
		    	checkY = this.getPositionY() - 1;
		    	break;
		    case "S":
		    	checkX = this.getPositionX();
		    	checkY = this.getPositionY() - 1;
		    	break;
		    case "SW":
		    	checkX = this.getPositionX() - 1;
		    	checkY = this.getPositionY() - 1;
		    	break;
		    case "W":
		    	checkX = this.getPositionX() - 1;
		    	checkY = this.getPositionY();
		    	break;
		    case "NW":
		    	checkX = this.getPositionX() - 1;
		    	checkY = this.getPositionY() + 1;
		    	break;
		    default:
		    	System.out.println("Non-Direction passed to " + this + ".directionToSquare");
		    	new Exception().printStackTrace();		    			
		}  // end switch
		
		PositionObject position = new PositionObject(checkX, checkY);
		
		return position;
		
	}  // end directionToSquare()
	
	public Boolean isDirectionOpen(String direction) {
		
		return(BoardBuilder.isSquareOpen(getPositionX(), getPositionY()));	
		
	}  // end isDirectionOpen
	
	public HashMap<String, Boolean> checkOpenDirections() {
		ArrayList<String> directions = BoardBuilder.eightDirections();
		HashMap<String, Boolean> openDirections = new HashMap<String, Boolean>();
		for (int i = 0; i < directions.size(); i++) {

			if (isDirectionOpen(directions.get(i)) == true){
			
			    openDirections.put(directions.get(i), isDirectionOpen(directions.get(i)));
			
			}  // end if statement
			
		}  // end for loop
		
		return openDirections;
		
	}  // end checkOpenDirections
	
	
	
} // end hasGridPosition
