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
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        System.out.println(mapperJsonToWeather.getWeatherObject());

        Localization loc = new Localization(1,50.0453,22.0964,"Krasne", "Poland");
        System.out.println(new HttpClientToSendRequest().jsonFromHttpRequest(loc));


    }


    }
