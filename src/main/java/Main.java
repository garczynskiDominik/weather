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


        Localization localization1 = new Localization(51.2465, 22.5684, "Lublin", "Poland");
        Localization localization2 = new Localization(51.2465, 22.5684, "Lublieeen", "Poland");
        Localization localization3 = new Localization(51.2465, 22.5684, "Lutblin", "Poland");
        Localization localization4 = new Localization(51.2465, 22.5684, "Lubltttin", "Poland");
        Localization localization5 = new Localization();
        Localization localization6 = new Localization();
        Localization localization7 = new Localization();
        Localization localization8 = new Localization();

        System.out.println(localization1);
        System.out.println(localization2);
        System.out.println(localization3);
        System.out.println(localization4);
        System.out.println(localization5);
        System.out.println(localization6);
        System.out.println(localization7);
        System.out.println(localization8);


        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        //System.out.println(mapperJsonToWeather.getWeatherObject(localization));


    }

}
