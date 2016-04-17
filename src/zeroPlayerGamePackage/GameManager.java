package zeroPlayerGamePackage;



public class GameManager {

	public static void main(String[] args) {
		
		Regiment tester = new Regiment(0);
		tester.setPositionX(5);
		tester.setPositionY(1);
		System.out.println(tester.directionToSquare("N").positionX);
		tester.directionToSquare("left");
		
		System.out.println(tester.checkOpenDirections());

	}  // end main
		
}  // end GameManager
