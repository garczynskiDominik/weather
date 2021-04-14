import org.apache.http.client.utils.URIBuilder;


import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long id = 5;
        String queryDataBase = new StringBuilder("update weather set localization_id=")
                .append(id)
                .append(" where id=")
                .append(id)
                .toString();

        System.out.println(queryDataBase);


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
                .addParameter("query", "Lubiln");


        System.out.println(builder1);


        System.out.println("http://api.weatherstack.com/current?access_key=3f4c60639ee881f4693cada28229a5e2&query=Lublin");


    }

}
