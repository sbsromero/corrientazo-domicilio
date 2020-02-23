package lunchDrone.service;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.exception.DeliveryException;
import lunchDrone.exception.FormatException;

public interface DeliveryService {

	public void deliveryLunchs(Drone drone) throws FormatException, DeliveryException;
	public void exportReport(Drone drone) throws DataException;

}