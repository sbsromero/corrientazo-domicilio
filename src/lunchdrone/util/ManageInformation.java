package lunchdrone.util;

import java.io.FileWriter;
import java.io.IOException;

import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;
import lunchdrone.service.LoadRouteMapService;
import lunchdrone.service.LoadRouteMapServiceImp;

public class ManageInformation {

	protected LoadRouteMapService loadRouteMapService;
	private static final String FILE_INPUT = "/lunchdrone/resources/input/";
	private static final String FILE_OUTPUT = "/lunchdrone/resources/output/";

	public ManageInformation() {
		this.loadRouteMapService = new LoadRouteMapServiceImp();
	}

	public void loadInformation(Drone drone, int index) throws DataException {
		String path = (index < 10) ? "init0" : "init";
		loadRouteMapService.loadRoutesForDrone(drone, FILE_INPUT + path + index + ".txt");
	}

	public void exportReport(Drone drone) throws DataException {

		FileWriter writer;
		try {
			String path = LoadRouteMapServiceImp.class.getResource(FILE_OUTPUT).getPath();
			path = path.replace("bin", "src");
			String fileName = path.substring(1, path.length()) + "out" + drone.getIdDrone() + ".txt";

			writer = new FileWriter(fileName);
			writer.write(drone.getReport());
			writer.close();
		} catch (IOException e) {
			throw new DataException("Check the route or permissions");
		}
	}

}
