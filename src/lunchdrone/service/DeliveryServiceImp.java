package lunchdrone.service;

import lunchdrone.domain.Coordinate;
import lunchdrone.domain.Drone;
import lunchdrone.exception.DataException;
import lunchdrone.exception.DeliveryException;
import lunchdrone.exception.FormatException;
import lunchdrone.util.ManageInformation;

public class DeliveryServiceImp implements DeliveryService {

	private MoveDroneService moveDroneService;
	private ManageInformation manageInformation;

	public DeliveryServiceImp() {
		this.moveDroneService = new MoveDroneServiceImp();
		this.manageInformation = new ManageInformation();
	}

	@Override
	public void deliveryLunchs(Drone drone) throws FormatException, DeliveryException {
		for (String route : drone.getRoutes()) {
			for (int i = 0; i < route.length(); i++) {

				switch (route.charAt(i)) {
				case 'A':
					validateMovement(drone.getCurrentPosition(), drone.getMaxDistance());
					moveDroneService.moveDrone(drone);
					break;
				case 'I':
					moveDroneService.turnLeft(drone);
					break;

				case 'D':
					moveDroneService.turnRight(drone);
					break;

				default:
					throw new FormatException("The input for the drone with id: "+drone.getIdDrone()+" is wrong");
				}
			}
			drone.setReport(drone.getReport() + "\n" + drone.getCurrentPosition().toString());
		}
	}

	public void validateMovement(Coordinate nextPoint, int maxDistance) throws DeliveryException {

		DeliveryException deliveryException = new DeliveryException("The point is out of the range of the delivery, the limit is "+maxDistance);
		switch (nextPoint.getPosition()) {
		case NORTH:
			if (nextPoint.getyPosition() + 1 > maxDistance)
				throw deliveryException;
			break;

		case SOUTH:
			if (nextPoint.getyPosition() - 1 < (maxDistance * -1))
				throw deliveryException;
			break;
		case EAST:
			if (nextPoint.getxPosition() + 1 > maxDistance)
				throw deliveryException;
			break;
		case WEST:
			if (nextPoint.getxPosition() - 1 < (maxDistance * -1))
				throw deliveryException;
			break;
		}

	}

	@Override
	public void exportReport(Drone drone) throws DataException {
		manageInformation.exportReport(drone);
	}

}
