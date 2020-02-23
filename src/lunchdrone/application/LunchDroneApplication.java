package lunchdrone.application;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;
import lunchdrone.service.CreateDroneService;
import lunchdrone.service.CreateDroneServiceImp;
import lunchdrone.service.DeliveryService;
import lunchdrone.service.DeliveryServiceImp;

public class LunchDroneApplication {

	public static void main(String[] args) throws DataException, InterruptedException, ExecutionException {
		CreateDroneService createDroneService = new CreateDroneServiceImp();
		DeliveryService deliveryLunchService = new DeliveryServiceImp();
		List<Drone> availableDrones = createDroneService.createDrone(12, 3, 10);
		createDroneService.setDeliveryRoute();
		
		ExecutorService exService = Executors.newCachedThreadPool();
		for (Drone drone : availableDrones) {
			Future<String> future = exService.submit(new Initializer(drone, deliveryLunchService));
			System.out.println(future.get());
		}
		exService.shutdownNow();
	}

}
