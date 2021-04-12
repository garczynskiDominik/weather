import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weatherapp.input.ValidatorToLocalization;
import com.weatherapp.model.HttpClientToSendRequest;
import com.weatherapp.model.Localization;
import com.weatherapp.model.MapperJsonToWeather;
import org.apache.http.client.utils.URIBuilder;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        URIBuilder builder = new URIBuilder()
                .setScheme("http")
                .setHost("apache.org")
                .setPath("/shindig")
                .addParameter("helloWorld", "foo&bar")
                .setFragment("foo");
        System.out.println(builder.toString());


        URIBuilder builder1 = new URIBuilder()
                .setScheme("http")
                .setHost("api.weatherstack.com")
                .setPath("current")
                .addParameter("access_key", "3f4c60639ee881f4693cada28229a5e2")
                .addParameter("query","Lubiln");


        System.out.println(builder1);


        System.out.println("http://api.weatherstack.com/current?access_key=3f4c60639ee881f4693cada28229a5e2&query=Lublin");


    }

}
