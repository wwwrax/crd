package rakesh.carrental.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rakesh.carrental.model.RentWindow;
import rakesh.carrental.model.ReserveCar;

public class RentalData {
	
	private Map<String, List<RentWindow>> bookingMap;
	public static RentalData INSTANCE = new RentalData();
	
	private RentalData() {
		if(bookingMap == null) {
			bookingMap = new HashMap<String, List<RentWindow>>();
			CarDatabase.cars.forEach(car -> {
				bookingMap.put(car.getType(), new ArrayList<RentWindow>());
			});
		}
	}
	
	public ReserveCar updateCarBooking(ReserveCar car){
		bookingMap.get(car.getCarType()).add(car.getWindow());
		return car;
	}
	
	public Boolean checkIfCarAvailableForWindow(String type, RentWindow reqRentWindow) {
		List<RentWindow> windowList = bookingMap.get(type);
		Boolean returnFlag = Boolean.TRUE;
		for (RentWindow rentWindow : windowList) {
			if(rentWindow.isBefore(reqRentWindow)||rentWindow.isAfter(reqRentWindow)) {
					continue;
			}else {
				returnFlag = Boolean.FALSE;
			}
		}
		return returnFlag;
	}

}
