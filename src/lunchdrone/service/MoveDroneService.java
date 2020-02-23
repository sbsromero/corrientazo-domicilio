package lunchdrone.service;

import lunchdrone.domain.Drone;

public interface MoveDroneService {

	public void moveDrone(Drone drone);
	public void turnLeft(Drone drone);
	public void turnRight(Drone drone);
}
