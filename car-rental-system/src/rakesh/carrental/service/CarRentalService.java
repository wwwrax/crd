package rakesh.carrental.service;

public interface CarRentalService {
	public RentResponse reserve(String custId, RentRequest request);
}
