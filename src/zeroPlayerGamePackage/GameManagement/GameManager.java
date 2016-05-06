package zeroPlayerGamePackage.GameManagement;

import java.util.ArrayList;

import zeroPlayerGamePackage.BoardBuilder;
import zeroPlayerGamePackage.PredictionHolder;
import zeroPlayerGamePackage.Regiment;
import zeroPlayerGamePackage.UnitLocationList;
import zeroPlayerGamePackage.Graphics.ConsoleLogger;
import zeroPlayerGamePackage.ReturnObjects.PositionObject;
import zeroPlayerGamePackage.ReturnObjects.PositionValueAndType;

public class GameManager {

	public static void main(String[] args) throws InterruptedException {
		
        SetUpGame setup = new SetUpGame();
        
		UnitLocationList team0 = new UnitLocationList(0);
		UnitLocationList team1 = new UnitLocationList(1);
		
		ArrayList<UnitLocationList> teamHolder = new ArrayList<UnitLocationList>();
		teamHolder.add(team0);
		teamHolder.add(team1);
		
		ArrayList<PositionObject> bases = setup.placeBases(3);

		while (bases.size() > 0) {
			team0.addBase(bases.get(0));
			team1.addBase(bases.get(1));
			bases.remove(0);
			bases.remove(0);  // ArrayList.remove shifts remaining elements left
		}  // end while loop
		
		bases = null;
		
// begin temporary graphics
		ConsoleLogger console = new ConsoleLogger();
		
		console.draw(team0.getBasePositions(), team1.getBasePositions(), 
				team0.getRegimentPositions(), team1.getRegimentPositions());
// end temporary graphics
		
//		Thread.sleep(1000);
		
		while (Regiment.regimentCounter < (BoardBuilder.REGIMENTS_PER_TEAM * 2)) {
			
			ArrayList<PositionObject> team0Bases = team0.getBasePositions();
			ArrayList<PositionObject> team1Bases = team1.getBasePositions();
			
			BoardBuilder builder = new BoardBuilder();
			
			PositionObject position;
			
			Boolean placed = false;
			while (placed == false){
				
				position = builder.suggestRegimentPlacement(team0Bases);
			
				if (!position.containsPositionEquality(UnitLocationList.team0RegimentLocations) 
						&& !position.containsPositionEquality(UnitLocationList.team1RegimentLocations)) {
					
					team0.addUnit(new Regiment(0, position));
					placed = true;
					
				}  // end if statement
			
			}  // end while loop
			
			placed = false;
			while (placed == false) {
				
				position = builder.suggestRegimentPlacement(team1Bases);
			
				if (!position.containsPositionEquality(UnitLocationList.team0RegimentLocations) 
						&& !position.containsPositionEquality(UnitLocationList.team1RegimentLocations)) {
					
					team1.addUnit(new Regiment(1, position));
					placed = true;
					
				}  // end if statement
			
			}  // end while loop
			
// begin temporary graphics
			console.draw(team0.getBasePositions(), team1.getBasePositions(), 
					team0.getRegimentPositions(), team1.getRegimentPositions());
// end temporary graphics
			
//			Thread.sleep(150);
			
		}  // end while loop
		
		
		// this is where runGame() from the readme begins
		// TODO when ai and actions are completed, loop this until game over
		// nested for loop == "for each regiment in each team"
		for (int i = 0; i < (BoardBuilder.REGIMENTS_PER_TEAM); i++) {
			
//			for (UnitLocationList myTeam: teamHolder) {
			for (int h = 0; h<2; h++) {
				
				UnitLocationList myTeam = teamHolder.get(h);
				UnitLocationList enemyTeam = new UnitLocationList(99);
				if (myTeam == team0) {
					enemyTeam = team1;
				} else if (myTeam == team1) {
					enemyTeam = team0;
				}  // end if statement
			
				Regiment regiment = myTeam.getRegimentByIndex(i);
				
				if (!(regiment.checkOpenDirections().size() == 0)) {
					
					regiment.logPossibleDirectionCheck();
					
					regiment.weighPossibleMoves(myTeam,enemyTeam);
										
				}  // end if statement
				
			}  // end for team in teamHolder
			
		}  // end for loop (BoardBuilder.REGIMENTS_PER_TEAM)
		
		
		
		
		
		// START TEST CODE
		// much of this no longer applies, but some of it saves a bit of time when debugging
////		
//		ArrayList<PredictionHolder> predicters = new ArrayList<PredictionHolder>();
//		for (Regiment i: team0.getRegimentList()) {
//			
//			PredictionHolder tempPredicter = new PredictionHolder(i);
//			predicters.add(tempPredicter);
//			tempPredicter.populateSurroundings();
//		    tempPredicter.populateSurroundingPerimeters();
//		    
//		    System.out.println(i.getPredictionHolder().surroundingPositionPerimeters.get(0).get(0).getValue());
//		}  // end for in loop
//		
//		
//		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(team0.getBasePositions().get(i).getPositionString());
//			System.out.println(team1.getBasePositions().get(i).getPositionString());
//		}
//		PositionObject position = new PositionObject(5, 5);
//		Regiment tester0 = new Regiment(0, position);
//		team0.addUnit(tester0);
//		PositionObject checkin = new PositionObject(5, 5);
//		System.out.println(UnitLocationList.isPositionOccupiedByTeam(checkin, 0));
//		System.out.println(UnitLocationList.isPositionOccupiedByTeam(checkin, 1));
//		PredictionHolder pred = new PredictionHolder(tester0);
//		pred.populateDirectionHolder();
//		ArrayList<String> array = tester0.checkOpenDirections();
//		System.out.println(tester0.directionToPositionObject(array));
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
