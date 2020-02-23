package lunchDrone.service;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;

public interface LoadRouteMapService {

	public void loadRoutesForDrone(Drone drone, String path) throws DataException;
}
