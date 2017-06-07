/**
 * 
 */
package org.dwolla;

import java.io.PrintWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dwolla.config.AppConfig;
import org.json.JSONObject;

/**
 * @author ankurshrivastava
 *
 */
//@Path("v1")
public class WeatherResource {

	/**
	 * 
	 */
	public WeatherResource() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Path("/about")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public String about() throws Exception {
		return "about";
	}

	@GET
	@Path("/cities/{cityName}/weather")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public String weatherInfo(@PathParam("cityName") String city) throws Exception {
		System.out.println("city " + city);

//		ObjectMapper ob = new ObjectMapper();
//		Expense exp = ob.readValue(ex, Expense.class);
		Client client = ClientBuilder.newClient();
StringBuilder sb = new StringBuilder();
		WebTarget target = client.target("http://api.openweathermap.org/data/2.5/weather");

		Response res = target.queryParam("q", city)
				.queryParam("units", "imperial")
				.queryParam("APPID", "e3c9e296ad1fbea5a28f9adfd906ef2d").request().get(Response.class);

		if (res.getStatus() == 200) {
			JSONObject json = new JSONObject(res.readEntity(String.class));
			JSONObject resultObject = json.getJSONObject("main");

			Double temp = resultObject.getDouble("temp");
			String cityName = city;
			int i = cityName.indexOf(' ');
			if (i > 0)
				cityName = cityName.substring(0, i);
			sb.append(cityName + " weather:" + temp + " degree Fahrenheit");
		} else {
			sb.append("entered city :" + city + " not found ");
		}
		
		return sb.toString();
	}

}
