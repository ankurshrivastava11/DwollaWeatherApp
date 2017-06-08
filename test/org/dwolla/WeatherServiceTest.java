package org.dwolla;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.dwolla.resources.WeatherAPIRequest;
import org.dwolla.resources.WeatherClient;
import org.dwolla.resources.WeatherService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class WeatherServiceTest {

	private WeatherService service = null;
	private WeatherClient client = null;

	private Response response;

	@Before
	public void setUp() throws Exception {
		response = Mockito.mock(Response.class);
		client = Mockito.mock(WeatherClient.class);
		service = new WeatherService(client);

	}

	@After
	public void destroy() throws Exception {
		service = null;
		client = null;
	}

	@Test
	public void testGetWeatherInfo() throws Exception {
		String city = "Chicago";
		String temp = "Chicago weather:58.28 degree Fahrenheit";
		int o = 200;
		Response expectedResponse = Response.status(Status.OK).entity(temp).type(MediaType.TEXT_PLAIN).build();
		ResponseBuilder r = Mockito.mock(ResponseBuilder.class);

		when(r.build().getStatus()).thenReturn(Response.status(o).build().getStatus());
		when(client.executeRequest(Mockito.mock(WeatherAPIRequest.class))).thenReturn(expectedResponse);
		String resText = service.getWeatherInfo(city);

		assertTrue(resText.contains(city));
		assertTrue(resText.contains("degree Fahrenheit"));
	}
}
