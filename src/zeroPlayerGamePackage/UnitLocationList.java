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
	
	public PositionObject whereIsUnit(Regiment regiment) {
		if (!regimentList.contains(regiment)) {
			System.out.println("Error: Regiment passed to UnitLocationList.whereIsUnit not "
					+ "found within regimentList");
			new Exception().printStackTrace();
		}  // end if statement
		
		int listPosition = regimentList.indexOf(regiment);
		return regimentPositions.get(listPosition);
		
	}  // end whereIsUnit(Regiment)
	
	public PositionObject whereIsUnit (int regimentNumber) {
		Regiment regiment = new Regiment(99);
		for (int i = 0; i < regimentList.size(); i++) {
			
			if (regimentList.get(i).getNumber() == regimentNumber) {
				
				regiment = regimentList.get(i);
				
			}  // end if statement
		    
		}  // end for loop
		
		if (regiment.getTeam() == 99) {
			System.out.println("Error: Regiment.Number passed to UnitLocationList.whereIsUnit not "
					+ "found within regimentList");
			new Exception().printStackTrace();
		}  // end if statement
		
		int listPosition = regimentList.indexOf(regiment);
		return regimentPositions.get(listPosition);
		
	}  // end whereIsUnit(regimentNumber)
	
//	isSquareOccupied() {
//		
//	}
	
}  // end UnitLocationList
