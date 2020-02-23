package lunchdrone.service;

import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;

public interface LoadRouteMapService {

	public void loadRoutesForDrone(Drone drone, String path) throws DataException;
}
