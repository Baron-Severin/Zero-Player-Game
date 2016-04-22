package zeroPlayerGamePackage;

import java.util.ArrayList;

public class UnitLocationList {
	
	private ArrayList<Regiment> regimentList = new ArrayList<Regiment>();
	private ArrayList<PositionObject> regimentPositions = new ArrayList<PositionObject>();
	
	public ArrayList<Regiment> getRegimentList() {
		return regimentList;
	}  // end getregimentList

	public ArrayList<PositionObject> getRegimentPositions() {
		return regimentPositions;
	}  // end getRegimentPositions
	
	public void addUnit(Regiment regiment, PositionObject position) {
		if (regimentList.contains(regiment)) {
			System.out.println("UnitLocationList.addUnit Error: regimentList already contains " + regiment);
		}  // end if statement
		
		else if (regimentPositions.contains(position)) {
			System.out.println("UnitLocationList.addUnit Error: regimentPositions already contains " + position);
		}  // end else if statement
		
		else {
			regimentList.add(regiment);
			regimentPositions.add(position);
		}  // end else statement
		
	}  // end addUnit
	
	public void moveUnit(Regiment regiment, PositionObject position) {
		
		for (int i = 0; i < regimentList.size(); i++) {
			
			if (regimentList.get(i) == regiment) {
				regimentPositions.set(i, position);
				break;
			}  // end if statement
			
		}  // end for loop
		
	}  // end moveUnit
	
//	removeUnit() {
//		
//	}
//	
//	whereIsUnit() {
//		
//	}
//	
//	isSquareOccupied() {
//		
//	}
	
}  // end UnitLocationList
