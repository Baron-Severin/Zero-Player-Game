package zeroPlayerGamePackage.Graphics;

import java.util.ArrayList;
import java.util.HashMap;

import zeroPlayerGamePackage.BoardBuilder;
import zeroPlayerGamePackage.GameManagement.GameManager;
import zeroPlayerGamePackage.ReturnObjects.PositionObject;

public class ConsoleLogger {
	
	@SuppressWarnings("unused")
	public void draw(ArrayList<PositionObject> team0Bases, ArrayList<PositionObject> team1Bases, 
			ArrayList<PositionObject> team0Regiments, ArrayList<PositionObject> team1Regiments) {
		
		if (GameManager.animateInConsole == true) {
		
			for (int i = 0; i < 20; i++) {
				System.out.println();
			}
			
			for (int h = 0; h < BoardBuilder.BOARD_HEIGHT + 1; h++) {
				
				String currentRow = "";
				
				for (int i = 0; i < BoardBuilder.BOARD_WIDTH + 1; i++) {
					
					PositionObject position = new PositionObject(i, h);
					if (position.containsPositionEquality(team0Bases)) {
						currentRow += " X";
					} else if (position.containsPositionEquality(team1Bases)) {
						currentRow += " T";
					} else if (position.containsPositionEquality(team0Regiments)) {
						currentRow += " 0";
					} else if (position.containsPositionEquality(team1Regiments)) {
						currentRow += " 1";
					} else {
						currentRow += " -";
					}  // end if statement
					
				}  // end width for loop
				
				System.out.println(currentRow);
				
			}  // end height for loop
			
		}  // end draw
		
	}  // end if GameManager.animateInConsole == true

}  // end ConsoleLogger
