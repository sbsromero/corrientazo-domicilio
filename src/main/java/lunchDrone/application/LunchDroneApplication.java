package lunchDrone.application;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.service.CreateDroneService;
import lunchDrone.service.CreateDroneServiceImp;
import lunchDrone.service.DeliveryService;
import lunchDrone.service.DeliveryServiceImp;

public class LunchDroneApplication {

	public static void main(String[] args) throws DataException, InterruptedException, ExecutionException {
		CreateDroneService createDroneService = new CreateDroneServiceImp();
		DeliveryService deliveryLunchService = new DeliveryServiceImp();
		List<Drone> availableDrones = createDroneService.createDrone(2, 3, 10);
		createDroneService.setDeliveryRoute();
		
		ExecutorService exService = Executors.newCachedThreadPool();
		for (Drone drone : availableDrones) {
			Future<String> future = exService.submit(new Initializer(drone, deliveryLunchService));
			System.out.println(future.get());
		}
		exService.shutdownNow();
	}

}