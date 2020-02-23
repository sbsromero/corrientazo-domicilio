package lunchDrone.service;

import lunchDrone.domain.Drone;
import lunchDrone.domain.Position;

public class MoveDroneServiceImp implements MoveDroneService {

	@Override
	public void moveDrone(Drone drone) {
		int xPosition = drone.getCurrentPosition().getxPosition();
		int yPosition = drone.getCurrentPosition().getyPosition();
		switch (drone.getCurrentPosition().getPosition()) {
		case NORTH:
			drone.getCurrentPosition().setyPosition(++yPosition);
			break;
		case SOUTH:
			drone.getCurrentPosition().setyPosition(--yPosition);
			break;
		case EAST:
			drone.getCurrentPosition().setxPosition(++xPosition);
			break;
		default:
			drone.getCurrentPosition().setxPosition(--xPosition);
			break;
		}
	}

	@Override
	public void turnLeft(Drone drone) {
		switch (drone.getCurrentPosition().getPosition()) {
		case NORTH:
			drone.getCurrentPosition().setPosition(Position.WEST);
			break;
		case SOUTH:
			drone.getCurrentPosition().setPosition(Position.EAST);
			break;
		case EAST:
			drone.getCurrentPosition().setPosition(Position.NORTH);
			break;
		default:
			drone.getCurrentPosition().setPosition(Position.SOUTH);
			break;
		}
	}

	@Override
	public void turnRight(Drone drone) {
		switch (drone.getCurrentPosition().getPosition()) {
		case NORTH:
			drone.getCurrentPosition().setPosition(Position.EAST);
			break;
		case SOUTH:
			drone.getCurrentPosition().setPosition(Position.WEST);
			break;
		case EAST:
			drone.getCurrentPosition().setPosition(Position.SOUTH);
			break;
		default:
			drone.getCurrentPosition().setPosition(Position.NORTH);
			break;
		}
	}
}
