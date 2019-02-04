package rakesh.carrental.service;

import rakesh.carrental.model.RentWindow;

public class RentRequest {
	String carType;
	Integer days = 1;
	RentWindow window;
	
	public RentRequest(String carType, Integer days, RentWindow window) {
		super();
		this.carType = carType;
		this.days = days;
		this.window = window;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public RentWindow getWindow() {
		return window;
	}
	public void setWindow(RentWindow window) {
		this.window = window;
	}
	
	@Override
	public String toString() {
		return "RentRequest [carType=" + carType + ", days=" + days + ", window=" + window + "]";
	}
		
}
