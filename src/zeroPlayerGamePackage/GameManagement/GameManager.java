package zeroPlayerGamePackage.GameManagement;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import zeroPlayerGamePackage.BoardBuilder;
import zeroPlayerGamePackage.PredictionHolder;
import zeroPlayerGamePackage.Regiment;
import zeroPlayerGamePackage.UnitLocationList;
import zeroPlayerGamePackage.Graphics.ConsoleLogger;
import zeroPlayerGamePackage.ReturnObjects.PositionObject;
import zeroPlayerGamePackage.ReturnObjects.PositionValueAndType;

public class GameManager {
	
	/* Begin Visual / Debug Options */
	// true to play normally
	public static final boolean sleep = true;
	public static final boolean animateInConsole = true;
	public static final long turnSpeed = 10;  // default == 10
	
	// false to play normally
	public static final boolean printPositionValues = false;
	public static final boolean oneTurnAtATime = false;
	public static final boolean printGenerateTowardsObjectivesScore = false;
	public static final boolean printTowardsObjectivesComponents = false;
	/* End Visual / Debug Options */

	public static void main(String[] args) throws InterruptedException {
		
		boolean gameOver = false;
		
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
		
		if (sleep == true) {
		    Thread.sleep(Math.round((double) (1000 * turnSpeed)/10));
		}  // if sleep == true
		
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
			
			if (sleep == true){
			    Thread.sleep(Math.round((double) (150 * turnSpeed)/10));
			}  // end if sleep == true
			    
		}  // end while loop
		
		if (sleep == true){
		    Thread.sleep(Math.round((double) (2000 * turnSpeed)/10));
		}  // end if sleep == true
		
		
		// this is where runGame() from the readme begins
		// TODO when ai and actions are completed, loop this until game over
		// nested for loop == "for each regiment in each team"
		
		while (gameOver == false) {
		
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
					
					PositionObject bestMove = regiment.weighPossibleMoves(myTeam, enemyTeam);
					
					if (!(enemyTeam.isPositionOccupiedByUs(bestMove))) {
					    myTeam.moveUnit(regiment, bestMove);
					}  // end if position is not occupied by enemy
					
//					if (enemyTeam.isPositionOccupiedByUs(bestMove)) {
//					    myTeam.attackPosition(regiment, bestMove);  // TODO this method is
//					}  // end if position is occupied by enemy      // currently unwritten
					
					console.draw(team0.getBasePositions(), team1.getBasePositions(), 
							team0.getRegimentPositions(), team1.getRegimentPositions());
					
					if (sleep == true){
					    Thread.sleep(Math.round((double) (150 * turnSpeed)/10));
					}  // end if sleep == true
										
				}  // end if statement
				
//				if (isGameOver() == false) {
//					
//				} else {
//					gameOver = true;
//				}
				
			}  // end for team in teamHolder
			
		}  // end for loop (BoardBuilder.REGIMENTS_PER_TEAM)
		
		if (oneTurnAtATime) {
			
			waitForEnter();
			
		}  // end if ifOneTurnAtATime == true
		
		} // end while gameOver == false
		
	}  // end main
	
	public static void waitForEnter() {
	    System.out.println("Press Enter to continue");
	    try { System.in.read(); }
	    catch (Exception e) {
	    	// this method only exists to force a wait between turns
	    };
	}  // end waitForEnter
			
}  // end GameManager
