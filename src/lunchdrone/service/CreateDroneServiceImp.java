package lunchdrone.service;

import java.util.ArrayList;
import java.util.List;

import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;
import lunchdrone.factory.DroneFactory;
import lunchdrone.util.ManageInformation;

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
		int index = 0;
		for (Drone drone : avaliableDrones) {
			loadInformation.loadInformation(drone, ++index);
		}
	}

}
