package api.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.PassengerEndPoint;

public class GetPassengerTest {

	PassengerEndPoint passenger;

	@BeforeMethod
	public void init() {
		passenger = new PassengerEndPoint();
	}

	@Test
	public void testGetPassenger() {
		passenger.getpassenger();
		passenger.stausCodeValidation();
		passenger.responseBodyValidation("name", "Quatar Airways");
	}
}
