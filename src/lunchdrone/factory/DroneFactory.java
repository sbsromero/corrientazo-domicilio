package lunchdrone.factory;

import lunchdrone.domain.Drone;

public class DroneFactory {

	public Drone createDrone(int capacity, int maxDistance) {
		return new Drone(capacity, maxDistance);
	}

}
