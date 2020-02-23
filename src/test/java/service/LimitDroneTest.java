package service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import lunchDrone.domain.Coordinate;
import lunchDrone.domain.Position;
import lunchDrone.exception.DeliveryException;
import lunchDrone.service.DeliveryServiceImp;

public class LimitDroneTest {

	@Test
	public void validateMovement() {

		try {
			Coordinate nextPoint = new Coordinate();
			nextPoint.setxPosition(-2);
			nextPoint.setyPosition(6);
			nextPoint.setPosition(Position.NORTH);

			DeliveryServiceImp deliveryService = new DeliveryServiceImp();
			deliveryService.validateMovement(nextPoint, 5);
			fail("It waits for an exception");
		} catch (DeliveryException e) {
			assertTrue(e.getMessage(), true);
		}

	}
}
