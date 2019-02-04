package rakesh.carrental.model;


public class ReserveCar {
	String carType;
	RentWindow window;
	
	public ReserveCar() {}
	public ReserveCar(String carType, RentWindow window) {
		super();
		this.carType = carType;
		this.window = window;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public RentWindow getWindow() {
		return window;
	}
	public void setWindow(RentWindow window) {
		this.window = window;
	}
	@Override
	public String toString() {
		return "ReserveCar [carType=" + carType + ", window=" + window + "]";
	}
	
}
