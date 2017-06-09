package org.dwolla.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * @author ankurshrivastava
 *
 */
public class WeatherClient {

	private Client client = ClientBuilder.newClient();

	public Response executeRequest(WeatherAPIRequest request) {
		Response res = client.target(request.getUrl()).queryParam("q", request.getCity())
				.queryParam("units", request.getTempUnit()).queryParam("APPID", request.getApiKey()).request()
				.method(request.getHttpMethod());

		return res;
	}
}
