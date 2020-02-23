package lunchDrone.service;

import java.util.List;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;

public interface CreateDroneService {

	public List<Drone> createDrone(int number, int capacity, int maxDistance);
	public void setDeliveryRoute() throws DataException;
}
