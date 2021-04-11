import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weatherapp.model.HttpClientToSendRequest;
import com.weatherapp.model.Localization;
import com.weatherapp.model.MapperJsonToWeather;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {


        Localization localization = new Localization(51.2465, 22.5684, "Lublin", "Poland");
        new HttpClientToSendRequest().jsonFromHttpRequest(localization);

        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").setHost("www.google.com").setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "");
        URI uri = builder.build();
        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());

        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        System.out.println(mapperJsonToWeather.getWeatherObject(localization));




    }

}
