package zeroPlayerGamePackage.GameManagement;

import java.util.ArrayList;

import zeroPlayerGamePackage.BoardBuilder;
import zeroPlayerGamePackage.PositionObject;
import zeroPlayerGamePackage.UnitLocationList;
import zeroPlayerGamePackage.Graphics.ConsoleLogger;

public class GameManager {

	public static void main(String[] args) {
		
        SetUpGame setup = new SetUpGame();
        
        // UnitLocationList(team)
		UnitLocationList team0 = new UnitLocationList(0);
		UnitLocationList team1 = new UnitLocationList(1);
		
		ArrayList<PositionObject> bases = setup.placeBases(3);

		while (bases.size() > 0) {
			team0.addBase(bases.get(0));
			team1.addBase(bases.get(1));
			bases.remove(0);
			bases.remove(0);  // ArrayList.remove shifts remaining elements left
		}  // end while loop
		
		bases = null;
		
		ConsoleLogger console = new ConsoleLogger();
		

		
		console.draw(team0.getBasePositions(), team1.getBasePositions(), 
				team0.getRegimentPositions(), team1.getRegimentPositions());
		

		

		
		/*
		 *  position team0.suggestRegimentPlacement()
		 *  if (!team0.isPositionOccupiedByTeam && !team1.isPositionOccupiedByTeam){
		 *     placeUnit()
		 *     } else {
		 *     unplaceableLocationList.add(position)
		 *     
		 *     (after all are placed) - unplaceableLocationList = null;
		 */
		
		
		
		
		// START TEST CODE
//		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(team0.getBasePositions().get(i).getPositionString());
//			System.out.println(team1.getBasePositions().get(i).getPositionString());
//		}
//		Regiment tester0 = new Regiment(0);
//		tester0.setPositionX(0);
//		tester0.setPositionY(0);
//		PositionObject position = new PositionObject(0, 0);
//		BoardBuilder.addToOccupiedSquares(position);
//		
//		Regiment tester1 = new Regiment(1);
//		tester1.setPositionX(1);
//		tester1.setPositionY(0);
//		PositionObject position1 = new PositionObject(1, 0);
//		BoardBuilder.addToOccupiedSquares(position1);
//		PositionObject tempPosition = new PositionObject(1, 0);
//		BoardBuilder.team1RegimentLocations.put("hi", tempPosition);
//		
//		System.out.println(tester0.checkOpenDirections());
//		tester0.regimentCheckEnemyLocations();
//		
//		
//		UnitLocationList team0 = new UnitLocationList();
//		UnitLocationList team1 = new UnitLocationList();
//		Regiment tester0 = new Regiment(0);
//		Regiment tester1 = new Regiment(1);
//		
//		PositionObject position0 = new PositionObject(10, 10);
//		PositionObject position1 = new PositionObject(11, 10);
//		
//		team0.addUnit(tester0, position0);
//		team1.addUnit(tester1, position1);
//		
////		System.out.println(team0.getRegimentList());
////		System.out.println(team0.getRegimentPositions());
////		
////		for (int i = 0; i< team0.getRegimentList().size(); i++) {
////			System.out.print("Regiment # " + team0.getRegimentList().get(i).getNumber());
////			System.out.println(", Position " + team0.getRegimentPositions().get(i).getPositionString());
////		}
//		
//		System.out.println(team1.whereIsUnit(1).getPositionString());
//		System.out.println(team0.whereIsUnit(tester0).getPositionString());
//		
//		team0.removeUnit(position0);
//		
//		System.out.println(team0.isPositionOccupiedByTeam(10, 10));
//		System.out.println(team1.isPositionOccupiedByTeam(11, 10));
//		
		
		// END TEST CODE

	}  // end main
			
}  // end GameManager
