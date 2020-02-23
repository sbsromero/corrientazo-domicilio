package lunchDrone.application;

import java.util.concurrent.Callable;

import lunchDrone.domain.Drone;
import lunchDrone.service.DeliveryService;

public class Initializer implements Callable<String> {

	private DeliveryService deliveryService;
	private Drone drone;

	public Initializer(Drone drone, DeliveryService deliveryLunchService) {
		this.drone = drone;
		this.deliveryService = deliveryLunchService;
	}

	@Override
	public String call() throws Exception {
		deliveryService.deliveryLunchs(drone);
		deliveryService.exportReport(drone);
		return "delivers have been finished";
	}

}
