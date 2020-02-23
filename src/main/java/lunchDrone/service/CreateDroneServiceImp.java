package lunchDrone.service;

import java.util.ArrayList;
import java.util.List;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.factory.DroneFactory;

public class CreateDroneServiceImp implements CreateDroneService {

	private List<Drone> avaliableDrones;
	private DroneFactory droneFactory;
	private LoadRouteMapService loadRouteMapService;

	public CreateDroneServiceImp() {
		this.avaliableDrones = new ArrayList<>();
		this.droneFactory = new DroneFactory();
		this.loadRouteMapService = new LoadRouteMapServiceImp();
	}

	@Override
	public List<Drone> createDrone(int number, int capacity, int maxDistance) {
		int i = 1;
		while (i <= number) {
			Drone drone = droneFactory.createDrone(capacity, maxDistance);
			drone.setIdDrone(i + "");
			avaliableDrones.add(drone);
			i++;
		}
		return avaliableDrones;
	}

	@Override
	public void setDeliveryRoute() throws DataException {
		for (Drone drone : avaliableDrones) {
			loadRouteMapService.loadRoutesForDrone(drone);
		}
	}

}