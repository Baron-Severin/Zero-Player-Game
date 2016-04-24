package zeroPlayerGamePackage;

public class PositionObject {

	public PositionObject(int X, int Y) {
		positionX = X;
		positionY = Y;
		
	}  // end constructor

	private int positionX;
	private int positionY;
	
	public int getPositionX() {
		return positionX;
	}  // end getPositionX
	
	public int getPositionY() {
		return positionY;
		
	}  // end getPositionY
	
	public void setPositionX (int position) {
		this.positionX = position;
	}  // end setPositionX
	
	public void setPositionY (int position) {
		this.positionY = position;
	}  // end setPositionY
	
	public void setPosition (PositionObject position) {
		this.positionX = position.getPositionX();
		this.positionY = position.getPositionY();
	}  // end setPosition
	
	public String getPositionString() {
		return (this.getPositionX() + ", " + this.getPositionY());
	}  // end getPositionString
	
}  // end PositionObject
