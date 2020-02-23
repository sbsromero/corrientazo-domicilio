package lunchDrone.service;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.util.ManageInformation;

public class LoadRouteMapServiceImp implements LoadRouteMapService {

	private ManageInformation manageInformation;

	public LoadRouteMapServiceImp() {
		this.manageInformation = new ManageInformation();
	}

	@Override
	public void loadRoutesForDrone(Drone drone) throws DataException {
		manageInformation.loadInformation(drone);
	}
}
