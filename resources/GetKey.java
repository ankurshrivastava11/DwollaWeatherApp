import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ankurshrivastava This file is used to fetch the api and url from the
 *         properties file.
 *
 */
public class GetKey {
	InputStream is;
	private Properties prop;

	public Properties getProperties() throws IOException {

		try {
			prop = new Properties();

			is = getClass().getClassLoader().getResourceAsStream("dev.properties");

			if (is != null) {
				prop.load(is);
			} else {
				throw new FileNotFoundException("property file '" + "dev.properties" + "' not found");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			is.close();
		}
		return prop;
	}

	public String getWeatherApiConfig(String key) throws IOException {
		Properties gk = this.getProperties();

		String value = gk.getProperty(key);

		return value;
	}
}
