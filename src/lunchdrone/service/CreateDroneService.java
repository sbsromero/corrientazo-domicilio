package lunchdrone.service;

import java.util.List;

import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;

public interface CreateDroneService {

	public List<Drone> createDrone(int number, int capacity, int maxDistance);
	public void setDeliveryRoute() throws DataException;
}
