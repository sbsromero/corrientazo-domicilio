package lunchDrone.service;

import java.io.File;
import java.util.Scanner;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;

public class LoadRouteMapServiceImp implements LoadRouteMapService {

	@Override
	public void loadRoutesForDrone(Drone drone, String inputPath) throws DataException {

		try {
			File file = new File(LoadRouteMapServiceImp.class.getResource(inputPath).getPath());
			Scanner scanner = new Scanner(file);
			String[] routes = new String[drone.getCapacity()];
			int index = 0;
			while (scanner.hasNextLine() && index < routes.length) {
				String data = scanner.nextLine();
				routes[index] = data;
				index++;
			}
			scanner.close();
			drone.setRoutes(routes);
		} catch (Exception e) {
			throw new DataException("Error loading the routeMap for drone with id: " + drone.getIdDrone() + " " + inputPath
					+ " File not found");
		}
	}
}
