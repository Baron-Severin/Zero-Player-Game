package zeroPlayerGamePackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import zeroPlayerGamePackage.ReturnObjects.PositionObject;

public class UnitLocationList {
	
	// key is regiment id, value is regiment position
	public static HashMap<Integer, PositionObject> team0RegimentLocations = new HashMap<Integer, PositionObject>();
	public static HashMap<Integer, PositionObject> team1RegimentLocations = new HashMap<Integer, PositionObject>();
	
	public UnitLocationList(int team) {
		super();
		this.team = team;
	}
	
	private int team;

	public ArrayList<Regiment> regimentList = new ArrayList<Regiment>();
	private ArrayList<PositionObject> regimentPositions = new ArrayList<PositionObject>();
	private ArrayList<Base> ourBases = new ArrayList<Base>();
	private ArrayList<PositionObject> basePositions = new ArrayList<PositionObject>();
	private ArrayList<PredictionHolder> predictionHolders = new ArrayList<PredictionHolder>();
	
	public ArrayList<Regiment> getRegimentList() {
		return regimentList;
	}  // end getregimentList
	
	public Regiment getRegimentByIndex(int index) {
		Regiment regiment = this.regimentList.get(index);
		return regiment;
	}  // end getRegimentByIndex
	
	public Regiment getRegimentByPosition(PositionObject position) {
		for (int i = 0; i < regimentPositions.size(); i++) {
			
			if (regimentPositions.get(i).positionEquality(position)) {
				return regimentList.get(i);
			}
		}  // end for loop (regimentPositions.size)
			
		System.out.println("Team" + this.team + "UnitLocationList.getRegimentByPosition found"
				+ " no regiment at position " + position.getPositionString());
		new Exception().printStackTrace();
		
		// returns nonsense Regiment
		PositionObject fakePosition = new PositionObject(99, 99);
		Regiment fakeRegiment = new Regiment(99, fakePosition);
		return fakeRegiment;
			
	}  // end getRegimentByPosition

	public ArrayList<PositionObject> getRegimentPositions() {
		return regimentPositions;
	}  // end getRegimentPositions	
	
	public void addUnit(Regiment regiment) {
		if (regimentList.contains(regiment)) {
			System.out.println("UnitLocationList.addUnit Error: regimentList already contains " + regiment);
		}  // end if statement
		
		else if (regimentPositions.contains(regiment.getPositionObject())) {
			System.out.println("UnitLocationList.addUnit Error: regimentPositions already contains " + regiment.getPositionObject());
		}  // end else if statement
		
		else {
			regimentList.add(regiment);
			regimentPositions.add(regiment.getPositionObject());
			predictionHolders.add(new PredictionHolder(regiment));
			
			if (this.team == 0) {
				team0RegimentLocations.put(regiment.getNumber(), regiment.getPositionObject());
			} else {
				team1RegimentLocations.put(regiment.getNumber(), regiment.getPositionObject());
			}
		}  // end else statement
		
	}  // end addUnit
	
	public void moveUnit(Regiment regiment, PositionObject position) {
		
		for (int i = 0; i < regimentList.size(); i++) {
			
			if (regimentList.get(i) == regiment) {
				regimentPositions.set(i, position);
				
				if (regiment.getTeam() == 0) {
					team0RegimentLocations.put(regiment.getNumber(), position);
				} else if (regiment.getTeam() == 1) {
					team1RegimentLocations.put(regiment.getNumber(), position);
				}  // end if statement
				
				regiment.setPositionWithPositionObject(position);
				
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
			
			if (this.team == 0) {
				
				team0RegimentLocations.remove(regiment);
				
			} else if (this.team == 1) {
                team1RegimentLocations.remove(regiment);
			}  // end if statement
			
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
		PositionObject throwaway = new PositionObject(99, 99);
		Regiment regiment = new Regiment(99, throwaway);
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
	
	public static Boolean isPositionOccupiedByTeam (PositionObject position, int team) {
		
		Boolean myBool = false;
		
		Collection<PositionObject> locationCollection = null;
		
		if (team == 0) {
			
			locationCollection = team0RegimentLocations.values();
			
		}  else if (team == 1) {
			
			locationCollection = team1RegimentLocations.values();
			
		}  // end if statement
		
		
		ArrayList<PositionObject> occupiedLocations = new ArrayList<PositionObject>();
		occupiedLocations.addAll(locationCollection);
			
		for (PositionObject i: occupiedLocations) {
				
				if (i.positionEquality(position)) {
					myBool = true;
					break;
				}  // end if statement
				
		}  // end for loop
		    
    if (myBool == true) {
    	return true;
    } else {
    	return false;
    }  // end if statement
			
	}  // end isPositionOccupiedByTeam
	
	public boolean isPositionOccupiedByUs(PositionObject position) {
		
		boolean bool = false;
		
		if (this.team == 0){
			bool = UnitLocationList.isPositionOccupiedByTeam(position, 0);
		} else if (this.team == 1) {
			bool = UnitLocationList.isPositionOccupiedByTeam(position, 1);
		} else {
			System.out.println("UnitLocationList.isPositionOccupiedByUs was passed an int for "
					+ "this.team that was neither 0 nor 1.  Integer passed: " + this.team);
			new Exception().printStackTrace();
		}  // end if team == X
		
		return bool;
		
	}  // end isPositionOccupiedByUs
	
	public void addBase(PositionObject position) {
		
		Base base = new Base(team);
		base.setPositionWithPositionObject(position);
		
		ourBases.add(base);
		basePositions.add(position);
		
	}  // end addBase
	
//	public void destroyBase(Base base) {
//		// TODO put something here
//	}  // end destroyBase
	
	public ArrayList<Base> getBases(){
		return this.ourBases;
	}  // end getBases	 
	
	public ArrayList<PositionObject> getBasePositions() {
		return this.basePositions;
	} // end getBasePositions
	
}  // end UnitLocationList
