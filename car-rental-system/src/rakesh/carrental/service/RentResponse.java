package rakesh.carrental.service;

import rakesh.carrental.model.ReserveCar;

public class RentResponse {
	Boolean status=Boolean.FALSE;
	ReserveCar carBooked;
	String custId;
	
	public RentResponse() {}
	public RentResponse(Boolean status, String custId) {
		super();
		this.status = status;
		this.custId = custId;
	}

	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public ReserveCar getCarId() {
		return carBooked;
	}
	public void setCar(ReserveCar carBooked) {
		this.carBooked = carBooked;
	}
	public String getCust() {
		return custId;
	}
	public void setCust(String custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "RentResponse [rentSuccessful=" + status + ", carBooked=" + carBooked + ", custId=" + custId
				+ "]";
	}
	
	
}
