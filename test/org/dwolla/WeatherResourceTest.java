package org.dwolla;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.dwolla.resources.WeatherResource;
import org.dwolla.resources.WeatherService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author ankurshrivastava This is the Unit testing file for the Weather
 *         Servlet. The testing is done using jUnit and Mockito.
 */
public class WeatherResourceTest {

//	@Mock
//	HttpServletRequest request;
//
//	@Mock
//	HttpServletResponse response;
//
//	@Mock
//	Properties prop;
//
//	@Mock
//	AppConfig appConfig;
	
//	@Mock
//	WeatherAPIRequest apiRequest;

	private WeatherResource weatherResource = null;
	private WeatherService service = null;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = Mockito.mock(WeatherService.class);
		weatherResource = new WeatherResource(service);

	}

	@After
	public void destroy() throws Exception {
		service = null;
		weatherResource = null;
	}

	@Test
	public void validCity() throws Exception {
		String city = "Chicago";
		String temp = "Chicago weather:58.28 degree Fahrenheit";
		
		when(service.getWeatherInfo(Matchers.anyString())).thenReturn(temp);
		String resText = weatherResource.weatherInfo(city);
		
		verify(service, times(1)).getWeatherInfo(Matchers.anyString());;
		
		assertTrue(resText.contains(city));
		assertTrue(resText.contains("degree Fahrenheit"));
	}

	@Test
	public void inValidCity() throws Exception {
		String city = "1";
		String temp = "Entered city: 1 not found";
		
		when(service.getWeatherInfo(Matchers.anyString())).thenReturn(temp);
		String resText = weatherResource.weatherInfo(city);
		
		verify(service, times(1)).getWeatherInfo(Matchers.anyString());
		
		assertTrue(resText.contains(city));
		assertTrue(resText.contains("not found"));
	}
	// @Test
	// public void validCity() throws Exception {
	//
	// when(appConfig.getWeatherApiConfig("weather.api.url")).thenReturn("http://api-weather");
	// when(request.getParameter("location")).thenReturn("Chicago IL");
	//
	// JSONObject obj = new JSONObject();
	// obj.put("main", new JSONObject().put("temp", 56.28));
	//
	// StringWriter sw = new StringWriter();
	// PrintWriter pw = new PrintWriter(sw);
	//
	// when(response.getWriter()).thenReturn(pw);
	// new Weather().doGet(request, response);
	//
	// String result = sw.getBuffer().toString().trim();
	// System.out.println(result);
	// Assert.assertTrue(result.contains("Fahrenheit"));
	// }

	// @Test
	// public void invalidCity() throws Exception {
	//
	// when(request.getParameter("location")).thenReturn("1");
	//
	// JSONObject obj = new JSONObject();
	// obj.put("main", new JSONObject().put("temp", 56.28));
	//
	// StringWriter sw = new StringWriter();
	// PrintWriter pw = new PrintWriter(sw);
	//
	// when(response.getWriter()).thenReturn(pw);
	//
	// new Weather().doGet(request, response);
	//
	// String result = sw.getBuffer().toString().trim();
	// Assert.assertFalse(result.contains("Chicago"));
	// Assert.assertFalse(result.contains("Fahrenheit"));
	// }
	//
	// @Test
	// public void validCityWithName() throws Exception {
	//
	// when(request.getParameter("location")).thenReturn("Chicago");
	//
	// JSONObject obj = new JSONObject();
	// obj.put("main", new JSONObject().put("temp", 56.28));
	//
	// StringWriter sw = new StringWriter();
	// PrintWriter pw = new PrintWriter(sw);
	//
	// when(response.getWriter()).thenReturn(pw);
	//
	// new Weather().doGet(request, response);
	//
	// String result = sw.getBuffer().toString().trim();
	// Assert.assertTrue(result.contains("Chicago"));
	// }
	//
	// @Test
	// public void invalidCityWithSpecialChars() throws Exception {
	//
	// when(request.getParameter("location")).thenReturn("?");
	//
	// JSONObject obj = new JSONObject();
	// obj.put("main", new JSONObject().put("temp", 56.28));
	//
	// StringWriter sw = new StringWriter();
	// PrintWriter pw = new PrintWriter(sw);
	//
	// when(response.getWriter()).thenReturn(pw);
	//
	// new Weather().doGet(request, response);
	//
	// String result = sw.getBuffer().toString().trim();
	//
	// Assert.assertFalse(result.contains("Chicago"));
	// Assert.assertFalse(result.contains("Fahrenheit"));
	// }
}
