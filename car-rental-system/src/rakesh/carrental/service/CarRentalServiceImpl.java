package rakesh.carrental.service;

import rakesh.carrental.data.RentalData;
import rakesh.carrental.model.ReserveCar;

public class CarRentalServiceImpl implements CarRentalService {

	@Override
	public RentResponse reserve(String custId, RentRequest request) {
		RentResponse response = new RentResponse();
		//check if available for booking
		boolean status = 
				RentalData.INSTANCE.
					checkIfCarAvailableForWindow(request.getCarType(), request.getWindow());
		if(status) {
			response.setStatus(Boolean.TRUE);
		}
		response.setCust(custId);
		response.setCar(bookTheCar(request));
		return response;
	}

	private ReserveCar bookTheCar(RentRequest request) {
		ReserveCar car = new ReserveCar(request.getCarType(), request.getWindow());
		RentalData.INSTANCE.updateCarBooking(car);
		return car;
	}

}
