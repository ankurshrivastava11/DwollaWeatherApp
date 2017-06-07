package org.dwolla;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dwolla.config.AppConfig;
import org.json.JSONObject;

/**
 * @author ankurshrivastava This servlet calls the openweathermap api and
 *         returns the data in json.
 *
 *         Servlet implementation class checkWeather
 */
@WebServlet("/checkWeather")
public class Weather extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Weather() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(MediaType.APPLICATION_JSON);

		PrintWriter out = response.getWriter();

		Client client = ClientBuilder.newClient();
		
		AppConfig ac = new AppConfig();

		WebTarget target = client.target(ac.getWeatherApiConfig("weather.api.url"));
		System.out.println(target.getUri());
		Response res = target.queryParam("q", request.getParameter("location"))
				.queryParam("units", "imperial")
				.queryParam("APPID", ac.getWeatherApiConfig("weather.api.key"))
				.request().get(Response.class);

		if (res.getStatus() == 200) {
			JSONObject json = new JSONObject(res.readEntity(String.class));
			JSONObject resultObject = json.getJSONObject("main");

			Double temp = resultObject.getDouble("temp");
			String cityName = request.getParameter("location");
			int i = cityName.indexOf(' ');
			if (i > 0)
				cityName = cityName.substring(0, i);
			out.println(cityName + " weather:");
			String tempFah = temp + " degree Fahrenheit";
			out.println(tempFah);
		} else {
			out.println("entered city :" + request.getParameter("location") + " not found ");
		}

	}

}
