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
import lunchDrone.service.LoadRouteMapService;
import lunchDrone.service.LoadRouteMapServiceImp;

public class ReportTest {

	@Test
	public void reportDrone() {
		try {
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(3, 10);
			drone.setIdDrone("1");
			String path = "src/main/resources/input/init0" + drone.getIdDrone() + ".txt";

			LoadRouteMapService loadRouteMapService = new LoadRouteMapServiceImp();
			loadRouteMapService.loadRoutesForDrone(drone, path);
			String reporte = "== Reporte de entregas ==\n" + "(-2,4) dirección Occidente\n" + "(-1,3) dirección Sur\n"
					+ "(0,0) dirección Occidente";

			DeliveryService deliveryService = new DeliveryServiceImp();
			deliveryService.deliveryLunchs(drone);
			assertEquals(reporte, drone.getReport());
		} catch (FormatException e) {
			fail("Exception no expected");
		} catch (DeliveryException e) {
			fail("Exception no expected");
		} catch (DataException e) {
			fail("Exception no expected");
		}
	}
}
