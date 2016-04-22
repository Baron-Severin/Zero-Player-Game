package zeroPlayerGamePackage;

public class PositionObject {

	public PositionObject(int X, int Y) {
		positionX = X;
		positionY = Y;
		
//		System.out.println(positionX);
//		System.out.println(positionY);
	}

	private int positionX;
	private int positionY;
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
		
	}
	
	public String getPositionString() {
		return (this.getPositionX() + ", " + this.getPositionY());
	}
}
