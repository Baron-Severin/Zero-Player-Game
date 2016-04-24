package zeroPlayerGamePackage;

import java.util.ArrayList;

public class UnitLocationList {
	
	public UnitLocationList(int team) {
		super();
		this.team = team;
	}
	
	private int team;

	private ArrayList<Regiment> regimentList = new ArrayList<Regiment>();
	private ArrayList<PositionObject> regimentPositions = new ArrayList<PositionObject>();
	private ArrayList<Base> ourBases = new ArrayList<Base>();
	
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
	
	public void removeUnit(Regiment regiment) {
		
		if (!regimentList.contains(regiment)) {
			
		    System.out.println("Error: Regiment passed to UnitLocationList " + this 
		    		+ ".removeUnit not found within regimentList");
		    new Exception().printStackTrace();
		    
		}  else {
			
			int index = regimentList.indexOf(regiment);
			regimentList.remove(regiment);
			regimentPositions.remove(index);
			regiment = null;
			
		}  // end if statement
		
	}  // end removeUnit
	
	public void removeUnit(PositionObject position) {
		
		if (!regimentPositions.contains(position)) {
			
		    System.out.println("Error: PositionObject passed to UnitLocationList " + this 
		    		+ ".removeUnit not found within regimentList");
		    new Exception().printStackTrace();
		    
		}  else {
			
			int index = regimentPositions.indexOf(position);
			regimentPositions.remove(position);
			regimentList.remove(index);
			// TODO: this method does not open Regiment for garbage collection
			
		}  // end if statement
		
	}  // end removeUnit
	
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
	
	public Boolean isPositionOccupiedByTeam (PositionObject position) {
		
		if (regimentPositions.contains(position)) {
			
			return true;
			
		}  else {
			
			return false;
			
		}  // end if statement
		
	}  // end isSquareOccupiedByTeam

	public Boolean isPositionOccupiedByTeam (int positionX, int positionY) {
		
		for (int i = 0; i < regimentPositions.size(); i++) {
			
			if (regimentPositions.get(i).getPositionX() == positionX 
					&& regimentPositions.get(i).getPositionY() == positionY) {
				
				return true;
				
			}  // end if statement
		
		}  // end for loop
		
		return false;
		
	}  // end isSquareOccupiedByTeam
	
	public void addBase(PositionObject position) {
		
		Base base = new Base(team);
		base.setPositionWithPositionObject(position);
		
		ourBases.add(base);
		
	}  // end addBase
	
	public ArrayList<Base> getBases(){
		return this.ourBases;
	}
	 
	
}  // end UnitLocationList
