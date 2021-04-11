import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weatherapp.model.Localization;
import com.weatherapp.model.MapperJsonToWeather;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("hello");
        System.out.println("Aplikacja do pogody");
        System.out.println("Main");
        System.out.println("Nowy branch develop");

        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        System.out.println(mapperJsonToWeather.getWeatherObject());




    }

}
