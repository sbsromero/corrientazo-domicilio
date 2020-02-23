package service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lunchDrone.domain.Drone;
import lunchDrone.factory.DroneFactory;

public class CreateDroneTest {

	@Test
	public void createDroneTest() {
		DroneFactory droneFactory = new DroneFactory();
		Drone drone = droneFactory.createDrone(3, 10);
		assertEquals(3, drone.getCapacity());
		assertEquals(10, drone.getMaxDistance());
	}
}
