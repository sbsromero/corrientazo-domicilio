package lunchDrone.service;

import java.io.File;
import java.util.Scanner;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.exception.FormatException;

public class LoadRouteMapServiceImp implements LoadRouteMapService {

	@Override
	public void loadRoutesForDrone(Drone drone, String inputPath) throws DataException {

		try {
			File file = new File(inputPath);
			Scanner scanner = new Scanner(file);
			String[] routes = new String[drone.getCapacity()];
			int index = 0;
			while (scanner.hasNextLine() && index < routes.length) {
				String data = scanner.nextLine();
				if (!validaInput(data)) {
					throw new FormatException("The input is wrong");
				}
				routes[index] = data;
				index++;
			}
			scanner.close();
			drone.setRoutes(routes);
		} catch (Exception e) {
			throw new DataException("Error loading the routeMap for drone with id: " + drone.getIdDrone() + " "
					+ inputPath + " File not found " + e.getMessage());
		}
	}

	private boolean validaInput(String data) {
		for (int i = 0; i < data.length(); i++) {
			if((data.charAt(i) != 'A') && (data.charAt(i) != 'I') && (data.charAt(i)!= 'D')) {
				return false;
			}
		}
		return true;
	}
}
