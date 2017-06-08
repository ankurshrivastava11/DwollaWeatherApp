package org.dwolla.resources;

public class WeatherAPIRequest {

	public WeatherAPIRequest(String url, String apiKey, String city, String tempUnit, String httpMethod) {
		super();
		this.url = url;
		this.apiKey = apiKey;
		this.city = city;
		this.tempUnit = tempUnit;
		this.httpMethod = httpMethod;
	}
	
	public WeatherAPIRequest() {
		super();
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTempUnit() {
		return tempUnit;
	}
	public void setTempUnit(String tempUnit) {
		this.tempUnit = tempUnit;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	private String url;
	private String apiKey;
	private String city;
	private String tempUnit;
	private String httpMethod;

}
