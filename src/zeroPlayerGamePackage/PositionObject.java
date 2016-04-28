package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PositionObject extends HasGridPosition {

	public PositionObject(int X, int Y) {
		positionX = X;
		positionY = Y;
		
	}  // end constructor

	private int positionX;
	private int positionY;
	
	public int getPositionX() {
		return positionX;
	}  // end getPositionX
	
	public int getPositionY() {
		return positionY;
		
	}  // end getPositionY
	
	public void setPositionX (int position) {
		this.positionX = position;
	}  // end setPositionX
	
	public void setPositionY (int position) {
		this.positionY = position;
	}  // end setPositionY
	
	public void setPosition (PositionObject position) {
		this.positionX = position.getPositionX();
		this.positionY = position.getPositionY();
	}  // end setPosition
	
	public String getPositionString () {
		return (this.getPositionX() + ", " + this.getPositionY());
	}  // end getPositionString
	
	public Boolean positionEquality (PositionObject position) {
		if (position.getPositionX() == positionX && position.getPositionY() == positionY) {
			return true;
		} else {
			return false;
		}  // end if statement
	}  // end positionEquality
	
	public Boolean containsPositionEquality (ArrayList<PositionObject> list) {
		
		for (int i = 0; i < list.size(); i++) {
			
			if (positionEquality(list.get(i))) {
				
				return true;
				
			}  // end if statement
			
		}  // end for loop
		
		return false;
		
	}  // end containsPositionEquality
	
	public Boolean containsPositionEquality (HashMap<Integer, PositionObject> hashmap) {
		
		Collection<PositionObject> templist = hashmap.values();		
		ArrayList<PositionObject> list = new ArrayList<PositionObject>(templist);
		
		for (int i = 0; i < list.size(); i++) {
			
			if (positionEquality(list.get(i))) {
				
				return true;
				
			}  // end if statement
			
		}  // end for loop
		
		return false;
		
	}  // end containsPositionEquality
	
	
}  // end PositionObject
