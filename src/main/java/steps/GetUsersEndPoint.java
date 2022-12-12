package steps;

import utils.ReadConfig;
import utils.RestSteps;

public class GetUsersEndPoint extends RestSteps{
	
	final String ENDPOINT = "/api/users";

	ReadConfig readConfig = new ReadConfig();

	public GetUsersEndPoint() {
		setBaseUrl(readConfig.get("reqresbaseUrl"));
	}

	public void getpassenger() {
		sentAsGet(ENDPOINT);
	}

	public void stausCodeValidation() {
		getResponse().then().statusCode(200);
	}

}
