package steps;

import utils.ReadConfig;
import utils.RestSteps;

public class PassengerEndPoint extends RestSteps {

	final String ENDPOINT = "/v1/airlines/1";

	ReadConfig readConfig = new ReadConfig();

	public PassengerEndPoint() {
		setBaseUrl(readConfig.get("baseUrl"));
	}

	public void getpassenger() {
		sentAsGet(ENDPOINT);
	}

	public void stausCodeValidation() {
		getResponse().then().statusCode(200);
	}
}
