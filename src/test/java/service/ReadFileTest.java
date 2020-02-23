package service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.factory.DroneFactory;
import lunchDrone.util.ManageInformation;

public class ReadFileTest {

	@Test
	public void readWrongInput() {

		try {
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(2, 10);
			drone.setIdDrone("1");
			
			ManageInformation manageInformation = new ManageInformation();
			String path = "src/test/resources/wrongInput/";
			manageInformation.setFileInput(path);
			manageInformation.loadInformation(drone);
			fail("it's waits for an exception");
		} catch (DataException e) {
			assertTrue(e.getMessage(), true);
		}
	}
}
