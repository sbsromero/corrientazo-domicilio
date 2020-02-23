package lunchdrone.service;

import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;
import lunchdrone.exception.DeliveryException;
import lunchdrone.exception.FormatException;

public interface DeliveryService {

	public void deliveryLunchs(Drone drone) throws FormatException, DeliveryException;
	public void exportReport(Drone drone) throws DataException;

}
