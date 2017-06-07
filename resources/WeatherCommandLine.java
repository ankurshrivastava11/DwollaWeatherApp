import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class WeatherCommandLine {
	private static Scanner scanner;
	InputStream is;

	private String getWeatherData(String cityName) throws MalformedURLException, IOException {
		GetKey gk = new GetKey();
		String key = gk.getWeatherApiConfig("weather.api.key");
		String path = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=imperial&APPID=" + key;
		InputStream is = new URL(path).openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private String getTemp(String data) {
		String str = "\"main\":{\"temp\":";
		int start = data.indexOf(str) + 15;
		String temp = data.substring(start, data.indexOf(',', start));
		return temp;
	}

	private String getCityName(String cityName) {
		int i = cityName.indexOf(' ');
		if (i > 0)
			cityName = cityName.substring(0, i);
		return cityName;
	}

	private void displayResult(String cityName) throws MalformedURLException, IOException {
		String json = getWeatherData(cityName);
		String temp = getTemp(json);
		cityName = getCityName(cityName);
		System.out.println(cityName + " weather:");
		System.out.println(temp + " Fahrenheit");
	}

	public static void main(String[] args) {
		try {
			scanner = new Scanner(System.in);
			System.out.println("Where are you?");
			String cityName = scanner.nextLine();
			WeatherCommandLine wcl = new WeatherCommandLine();
			wcl.displayResult(cityName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}