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
	
	public PositionObject getPositionObject() {
		PositionObject position = new PositionObject(positionX, positionY);
		return position;
	}
	
	public void setPositionX(int newX) {
		this.positionX = newX;
	}
	
	public void setPositionY(int newY) {
		this.positionY = newY;
	}
	
	public void setPosition(int newX, int newY) {
		this.positionX = newX;
		this.positionY = newY;
	}
	
	public void setPositionWithPositionObject(PositionObject position) {
		this.positionX = position.getPositionX();
		this.positionY = position.getPositionY();
	}

	public PositionObject directionToPositionObject(String direction) {
		
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
		
	}  // end directionToPositionObject()
	
	public ArrayList<PositionObject> directionToPositionObject(ArrayList<String> directions) {
		
		ArrayList<PositionObject> positions = new ArrayList<PositionObject>();
		
		for (int i = 0; i < directions.size(); i++) {
			
			PositionObject thisPosition = directionToPositionObject(directions.get(i));
			positions.add(thisPosition);
			
		}  // end for loop
		
		return positions;
		
	}  // end directionToPositionObject
	
	public ArrayList<String> checkOpenDirections() {
		ArrayList<String> directions = BoardBuilder.eightDirections();
		ArrayList<String> openDirections = new ArrayList<String>();
		for (int i = 0; i < directions.size(); i++) {
			
			PositionObject position = directionToPositionObject(directions.get(i));
			
			if (BoardBuilder.isSquareOpen(position) == true){
			
			    openDirections.add(directions.get(i));
			
			}  // end if statement
			
		}  // end for loop
		
		return openDirections;
		
	}  // end checkOpenDirections
	
	
	
} // end hasGridPosition
