package rakesh.carrental.controller;

import rakesh.carrental.model.RentWindow;
import rakesh.carrental.service.CarRentalService;
import rakesh.carrental.service.CarRentalServiceImpl;
import rakesh.carrental.service.RentRequest;
import rakesh.carrental.service.RentResponse;

public class CarRentalController {
	
	CarRentalService service = new CarRentalServiceImpl();
	
	public RentResponse reserve(String custId, RentRequest request) throws Exception{
		//car type defaults to sedan if not specified in request
		System.out.printf("\ninitial request: %s ", request);
		if(request.getCarType() == null || request.getCarType().isEmpty()) {
			request.setCarType("SEDAN");
		}
		if(request.getWindow() == null) {//set booking tie window if not already set
			RentWindow window = new RentWindow();
			request.setWindow(window);
		}
		if(request.getDays() != null) { // adjust time window for number of request days
			if(request.getDays()>1) 
				request.getWindow().getEnd().plusDays(request.getDays());
		}
		//check if available;
		System.out.printf("\nrequest: %s ", request);
		RentResponse response = service.reserve(custId, request);
		System.out.printf("\nresponse: %s \n", response);
		return response;
	}
	
}
