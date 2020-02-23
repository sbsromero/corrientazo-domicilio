package lunchDrone.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.service.LoadRouteMapService;
import lunchDrone.service.LoadRouteMapServiceImp;

public class ManageInformation {

	protected LoadRouteMapService loadRouteMapService;
	private static final String FILE_INPUT = "src/main/resources/input/";
	private static final String FILE_OUTPUT = "src/main/resources/output/";

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
			File file = new File(FILE_OUTPUT);
			String path = file.getAbsolutePath();
			String fileName = path + "/out" + drone.getIdDrone() + ".txt";
			writer = new FileWriter(fileName);
			writer.write(drone.getReport());
			writer.close();
		} catch (IOException e) {
			throw new DataException("Check the route or permissions");
		}
	}

}
