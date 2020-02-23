package lunchDrone.factory;

import lunchDrone.domain.Drone;

public class DroneFactory {

	public Drone createDrone(int capacity, int maxDistance) {
		return new Drone(capacity, maxDistance);
	}

}