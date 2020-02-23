package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DeliveryException;
import lunchDrone.exception.FormatException;
import lunchDrone.factory.DroneFactory;
import lunchDrone.service.DeliveryService;
import lunchDrone.service.DeliveryServiceImp;

public class ReportTest {

	
	@Test
	public void reportDrone() {
		try {
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(2, 10);
			String routes[] = new String[3];
			routes[0] = "AAAAIAA";
			routes[1] = "DDDAIAD";
			routes[2] = "AAIADAD"; 
			drone.setRoutes(routes);
			
			String reporte = "== Reporte de entregas ==\n"+
					"(-2,4) dirección Occidente\n"+
					"(-1,3) dirección Sur\n"+
					"(0,0) dirección Occidente";
			
			DeliveryService deliveryService = new DeliveryServiceImp();
			deliveryService.deliveryLunchs(drone);
			assertEquals(reporte, drone.getReport());
		} catch (FormatException e) {
			fail("Exception no expected");
		} catch (DeliveryException e) {
			fail("Exception no expected");
		}
	}
}
