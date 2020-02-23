package lunchDrone.domain;

public class Drone {

	private String idDrone;
	private int capacity;
	private Coordinate currentPosition;
	private int maxDistance;
	private String[] routes;
	private String report;

	public Drone(int capacity, int maxDistance) {
		this.capacity = capacity;
		this.maxDistance = maxDistance;
		this.currentPosition = new Coordinate();
		this.routes = new String[capacity];
		this.report = "== Reporte de entregas ==";
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public String getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(String idDrone) {
		this.idDrone = idDrone;
	}

	public Coordinate getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Coordinate currentPosition) {
		this.currentPosition = currentPosition;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public String[] getRoutes() {
		return routes;
	}

	public void setRoutes(String[] routes) {
		this.routes = routes;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
}