package org.dwolla;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

/**
 * @author ankurshrivastava
 * This servlet calls the openweathermap api and returns the data in json.
 *
 * Servlet implementation class checkWeather
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

		WebTarget target = ClientBuilder.newClient().target("http://api.openweathermap.org/data/2.5/weather");

		Response res = target.queryParam("q", request.getParameter("location")).queryParam("units", "imperial")
				.queryParam("APPID", "e3c9e296ad1fbea5a28f9adfd906ef2d").request().get(Response.class);

		if (res.getStatus() == 200) {

			JSONObject json = new JSONObject(res.readEntity(String.class));

			JSONObject resultObject = json.getJSONObject("main");

			Double temp = resultObject.getDouble("temp");

			out.println(request.getParameter("location") + " weather:");

			String tempFah = temp + " degree Fahrenheit";

			out.println(tempFah);
		} else {
			out.println("entered city :" + request.getParameter("location") + " not found ");
		}

	}

}
