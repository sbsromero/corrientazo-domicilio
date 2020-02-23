package lunchDrone.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import lunchDrone.domain.Drone;
import lunchDrone.exception.DataException;
import lunchDrone.exception.FormatException;

public class ManageInformation {

	private static final String FILE_OUTPUT = "src/main/resources/output/";
	private String fileInput;

	public ManageInformation() {
		this.fileInput = "src/main/resources/input/";
	}

	public void loadInformation(Drone drone) throws DataException {
		int numFile = Integer.parseInt(drone.getIdDrone());
		String path = numFile < 10 ? "init0" : "init";

		try {
			File file = new File(fileInput + path + numFile + ".txt");
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
			throw new DataException("Error loading the routeMap for drone with id: " + drone.getIdDrone() + " " + path
					+ " File not found " + e.getMessage());
		}
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

	private boolean validaInput(String data) {
		for (int i = 0; i < data.length(); i++) {
			if ((data.charAt(i) != 'A') && (data.charAt(i) != 'I') && (data.charAt(i) != 'D')) {
				return false;
			}
		}
		return true;
	}

	public String getFileInput() {
		return fileInput;
	}

	public void setFileInput(String fileInput) {
		this.fileInput = fileInput;
	}
}
