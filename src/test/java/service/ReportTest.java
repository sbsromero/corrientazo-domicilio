package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.exception.DeliveryException;
import lunchDrone.exception.FormatException;
import lunchDrone.factory.DroneFactory;
import lunchDrone.service.DeliveryService;
import lunchDrone.service.DeliveryServiceImp;
import lunchDrone.util.ManageInformation;

public class ReportTest {

	private final String MESSAGE = "Exception no expected";

	@Test
	public void reportDrone() {
		try {
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(3, 10);
			drone.setIdDrone("1");
			String path = "src/main/resources/input/";

			ManageInformation manageInformation = new ManageInformation();
			manageInformation.setFileInput(path);
			manageInformation.loadInformation(drone);

			String reporte = "== Reporte de entregas ==\n" + "(-2,4) direcci�n Occidente\n" + "(-1,3) direcci�n Sur\n"
					+ "(0,0) direcci�n Occidente";

			DeliveryService deliveryService = new DeliveryServiceImp();
			deliveryService.deliveryLunchs(drone);
			assertEquals(reporte, drone.getReport());
		} catch (FormatException e) {
			fail(MESSAGE);
		} catch (DeliveryException e) {
			fail(MESSAGE);
		} catch (DataException e) {
			fail(MESSAGE);
		}
	}
}
