package org.dwolla.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ankurshrivastava
 *
 */
@Path("/weather")
public class WeatherResource {

	
public WeatherResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	private WeatherService weatherService = new WeatherService();

	public WeatherResource(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GET
	@Path("/about")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public String about() throws Exception {
		return "about";
	}

	@GET
	@Path("/cities/{cityName}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String weatherInfo(@PathParam("cityName") String city) throws Exception {
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://api.openweathermap.org/data/2.5/weather");
//		Response res = target.queryParam("q", city).queryParam("units", "imperial")
//				.queryParam("APPID", "e3c9e296ad1fbea5a28f9adfd906ef2d").request().get(Response.class);
		String temp = weatherService.getWeatherInfo(city);
		return temp;
//		StringBuilder sb = new StringBuilder();
//
//		if (serviceResopnse.getStatus() == 200) {
//			JSONObject json = new JSONObject(serviceResopnse.readEntity(String.class));
//			JSONObject resultObject = json.getJSONObject("main");
//
//			Double temp = resultObject.getDouble("temp");
//			String cityName = city;
//			int i = cityName.indexOf(' ');
//			if (i > 0)
//				cityName = cityName.substring(0, i);
//			sb.append(cityName + " weather: " + temp + " degree Fahrenheit");
//		} else {
//			sb.append("entered city :" + city + " not found ");
//		}
//		return sb.toString();
	}
}
