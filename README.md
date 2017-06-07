# DwollaWeatherApp
This application shows the current weather of any city in Fahrenheit. The application fetches the data from openweathermap.org with the help of its api and shows the current data.

The application consists of two interfaces.
1. HTML interface, which takes the location as an input and shows the current data.
2. Command Line Interface, which takes the location input from the command line and shows the result.

<p>How to build and run the HTML Interface:</p>
This interface is developed using <a href="https://maven.apache.org/">Maven</a>.
Pull the project into the workspace.
Run the project as Maven generate-resources to install the dependencies.
Run the project on server.
Enter the location and click on Check Weather.
The result is displayed.

<p>How to build and run the Command Line Interface:</p>
Pull the project into the workspace.
Open the terminal.
Go to the project path using cd /path.
Go to the WeatherCommandLine.java file using cd /DwollaWeatherApp/resources
Compile the file WeatherCommandLine.java using javac WeatherCommandLine.java
Run the file using java WeatherCommandLine
Enter the Location in the terminal.
The result is displayed.

<p>Travis CI Build</p>
<a href="https://travis-ci.org/boennemann/badges">
<img src="https://travis-ci.org/ankurshrivastava11/DwollaWeatherApp.svg?branch=master" style="max-width:100%;">
</a>

<p> Travis CI Job Log </p>
https://travis-ci.org/ankurshrivastava11/DwollaWeatherApp/jobs/240223605

