import com.google.gson.Gson;
import com.google.gson.JsonObject;

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

        String myJSONString = "{\"request\":{\"type\":\"City\",\"query\":\"Lublin, Poland\",\"language\":\"en\",\"unit\":\"m\"},\"location\":{\"name\":\"Lublin\",\"country\":\"Poland\",\"region\":\"\",\"lat\":\"51.250\",\"lon\":\"22.567\",\"timezone_id\":\"Europe\\/Warsaw\",\"localtime\":\"2021-04-10 14:37\",\"localtime_epoch\":1618065420,\"utc_offset\":\"2.0\"},\"current\":{\"observation_time\":\"12:37 PM\",\"temperature\":17,\"weather_code\":113,\"weather_icons\":[\"https:\\/\\/assets.weatherstack.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\"],\"weather_descriptions\":[\"Sunny\"],\"wind_speed\":19,\"wind_degree\":210,\"wind_dir\":\"SSW\",\"pressure\":1017,\"precip\":0,\"humidity\":32,\"cloudcover\":0,\"feelslike\":17,\"uv_index\":4,\"visibility\":10,\"is_day\":\"yes\"}}";
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);

        String result = jobj.get("name").getAsString();

        System.out.println(result);

    }

}
