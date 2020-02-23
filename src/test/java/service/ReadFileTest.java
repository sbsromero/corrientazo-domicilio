package service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.factory.DroneFactory;
import lunchDrone.service.LoadRouteMapService;
import lunchDrone.service.LoadRouteMapServiceImp;

public class ReadFileTest {

	@Test
	public void readWrongInput() {

		try {

			LoadRouteMapService loadRouteMapService = new LoadRouteMapServiceImp();
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(2, 10);
			drone.setIdDrone("1");

			String path = "src/test/resources/wrongInput/init0" + drone.getIdDrone() + ".txt";
			loadRouteMapService.loadRoutesForDrone(drone, path);
			fail("it's waits for an exception");
		} catch (DataException e) {
			assertTrue(e.getMessage(), true);
		}
	}
}
