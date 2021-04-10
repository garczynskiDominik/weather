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

        String myJSONString = "{'test': '100.00'}";
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);

        String result = jobj.get("test").getAsString();

        System.out.println(result);

    }

}
