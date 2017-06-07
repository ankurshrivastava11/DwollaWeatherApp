package org.dwolla.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	InputStream is;
	private Properties prop;

	public Properties getProperties() throws IOException {

		try {
			prop = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			is = loader.getResourceAsStream("dev.properties");

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
		// get config properties
//		AppConfig ac = new AppConfig();

		Properties appConfig = this.getProperties();

		String value = appConfig.getProperty(key);

		return value;
	}
}
