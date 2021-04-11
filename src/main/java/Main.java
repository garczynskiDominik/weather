import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weatherapp.model.HttpClientToSendRequest;
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


        Localization localization = new Localization(51.2465, 22.5684, "Lublin", "Poland");
        new HttpClientToSendRequest().jsonFromHttpRequest(localization);


        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        System.out.println(mapperJsonToWeather.getWeatherObject(localization));




    }

}
