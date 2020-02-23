package lunchDrone.domain;

public class Coordinate {

	private int xPosition;
	private int yPosition;
	private Position position;

	public Coordinate() {
		this.xPosition = 0;
		this.yPosition = 0;
		this.position = Position.NORTH;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "(" + xPosition + "," + yPosition + ") dirección " + position.getDirection();
	}

}
