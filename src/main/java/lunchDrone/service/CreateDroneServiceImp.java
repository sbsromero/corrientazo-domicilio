package lunchDrone.service;

import java.util.ArrayList;
import java.util.List;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.factory.DroneFactory;
import lunchDrone.util.ManageInformation;

public class CreateDroneServiceImp implements CreateDroneService {

	private List<Drone> avaliableDrones;
	private DroneFactory droneFactory;
	private ManageInformation loadInformation;

	public CreateDroneServiceImp() {
		this.loadInformation = new ManageInformation();
		this.avaliableDrones = new ArrayList<>();
		this.droneFactory = new DroneFactory();
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
			loadInformation.loadInformation(drone, Integer.parseInt(drone.getIdDrone()));
		}
	}

}