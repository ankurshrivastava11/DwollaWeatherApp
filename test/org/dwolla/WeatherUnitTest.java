package org.dwolla;

import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author ankurshrivastava This is the Unit testing file for the Weather
 *         Servlet. The testing is done using jUnit and Mockito.
 */
public class WeatherUnitTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void validCity() throws Exception {

		when(request.getParameter("location")).thenReturn("Chicago IL");

		JSONObject obj = new JSONObject();
		obj.put("main", new JSONObject().put("temp", 56.28));

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);
		new Weather().doGet(request, response);

		String result = sw.getBuffer().toString().trim();
		Assert.assertTrue(result.contains("Fahrenheit"));
	}

	@Test
	public void invalidCity() throws Exception {

		when(request.getParameter("location")).thenReturn("1");

		JSONObject obj = new JSONObject();
		obj.put("main", new JSONObject().put("temp", 56.28));

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new Weather().doGet(request, response);

		String result = sw.getBuffer().toString().trim();
		Assert.assertFalse(result.contains("Chicago"));
		Assert.assertFalse(result.contains("Fahrenheit"));
	}

	@Test
	public void validCityWithName() throws Exception {

		when(request.getParameter("location")).thenReturn("Chicago");

		JSONObject obj = new JSONObject();
		obj.put("main", new JSONObject().put("temp", 56.28));

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new Weather().doGet(request, response);

		String result = sw.getBuffer().toString().trim();
		Assert.assertTrue(result.contains("Chicago"));
	}
	
	@Test
	public void invalidCityWithSpecialChars() throws Exception {

		when(request.getParameter("location")).thenReturn("?");

		JSONObject obj = new JSONObject();
		obj.put("main", new JSONObject().put("temp", 56.28));

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new Weather().doGet(request, response);

		String result = sw.getBuffer().toString().trim();

		Assert.assertFalse(result.contains("Chicago"));
		Assert.assertFalse(result.contains("Fahrenheit"));
	}
}
