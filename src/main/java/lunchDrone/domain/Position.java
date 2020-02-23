package lunchDrone.domain;

public enum Position {

	NORTH("Norte"), 
	SOUTH("Sur"), 
	EAST("Oriente"), 
	WEST("Occidente");

	private String direction;

	private Position(String direction) {
		this.direction = direction;
	}

	private Position() {
		this.direction = "Norte";
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}