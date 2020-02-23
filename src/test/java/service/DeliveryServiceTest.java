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

public class DeliveryServiceTest {

	@Test
	public void deliverDroneWithRouteTest1() {

		try {
			String routes[] = new String[1];
			routes[0] = "AAAAIAAD";
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(1, 10);
			drone.setRoutes(routes);

			DeliveryService deliveryService = new DeliveryServiceImp();
			deliveryService.deliveryLunchs(drone);
			assertEquals("(-2,4) dirección Norte", drone.getCurrentPosition().toString());
		} catch (FormatException e) {
			fail();
		} catch (DeliveryException e) {
			fail();
		}
	}

	@Test
	public void deliverDroneWithRouteTest2() {
		try {
			String routes[] = new String[2];
			routes[0] = "AAAAIAA";
			routes[1] = "DDAIAD";
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(1, 10);
			drone.setRoutes(routes);

			DeliveryService deliveryService = new DeliveryServiceImp();
			deliveryService.deliveryLunchs(drone);
			assertEquals("(-1,5) dirección Oriente", drone.getCurrentPosition().toString());
		} catch (FormatException e) {
			fail();
		} catch (DeliveryException e) {
			fail();
		}
	}

	@Test
	public void deliverDronWithRouteTest3() {
		try {
			String routes[] = new String[3];
			routes[0] = "AAAAIAA";
			routes[1] = "DDDAIAD";
			routes[2] = "AAIADAD"; 
			DroneFactory droneFactory = new DroneFactory();
			Drone drone = droneFactory.createDrone(1, 10);
			drone.setRoutes(routes);

			DeliveryService deliveryService = new DeliveryServiceImp();
			deliveryService.deliveryLunchs(drone);
			assertEquals("(0,0) dirección Occidente", drone.getCurrentPosition().toString());
		} catch (FormatException e) {
			fail();
		} catch (DeliveryException e) {
			fail();
		}
	}
}
