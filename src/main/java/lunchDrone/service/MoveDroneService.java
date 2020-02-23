package lunchDrone.service;

import lunchDrone.domain.Drone;

public interface MoveDroneService {

	public void moveDrone(Drone drone);
	public void turnLeft(Drone drone);
	public void turnRight(Drone drone);
}
