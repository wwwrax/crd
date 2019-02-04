/**
 * 
 */
package rakesh.carrental.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import rakesh.carrental.model.RentWindow;
import rakesh.carrental.service.RentRequest;

@DisplayName("Test car reserve")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CarRentalControllerTest {
	
	private CarRentalController testController = new CarRentalController();
	private RentWindow window = new RentWindow();
	private String custId = "cust1";
	private RentRequest rentRequest = new RentRequest("SEDAN", 1, window);
	
	@Test
	@DisplayName("testReserve1 - SEDAN 1 - reserve")
	final void testReserve1() {
		rentRequest = new RentRequest("SEDAN", 1, window);
		try {
			//book car for 1 day.
			Boolean status = testController.reserve(custId, rentRequest).getStatus();
			System.out.println("testReserve1():status:"+status);
			assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("testReserve2 - SUV reserve - one")
	final void testReserve2() {
		rentRequest = new RentRequest("SUV", 1, window);
		try {
			Boolean status = testController.reserve(custId, rentRequest).getStatus();
			System.out.println("testReserve2():status:"+status);
			assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("testReserve3 - SEDAN - reserve booked window - return false")
	final void testReserve3() {
		rentRequest = new RentRequest("SEDAN", 1, window);
		try {
			Boolean status = testController.reserve(custId, rentRequest).getStatus();
			System.out.println("testReserve3():status:"+status);
			assertFalse(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("testReserve4 - SUV reserve again for 2 days after first booking")
	final void testReserve4() {
		window.setStart(window.getStart().plusDays(2));
		window.setEnd(window.getStart().plusDays(2));
		rentRequest = new RentRequest("SUV", 2, window);
		try {
			Boolean status = testController.reserve(custId, rentRequest).getStatus();
			System.out.println("testReserve4():status:"+status);
			assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
