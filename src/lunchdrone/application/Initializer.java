package lunchdrone.application;

import java.util.concurrent.Callable;

import lunchdrone.domain.Drone;
import lunchdrone.service.DeliveryService;

public class Initializer implements Callable<String> {

	private DeliveryService deliveryLunchService;
	private Drone drone;

	public Initializer(Drone drone, DeliveryService deliveryLunchService) {
		this.drone = drone;
		this.deliveryLunchService = deliveryLunchService;
	}

	@Override
	public String call() throws Exception {
		deliveryLunchService.deliveryLunchs(drone);
		deliveryLunchService.exportReport(drone);
		return "delivers have been finished";
	}

}
