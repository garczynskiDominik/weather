package com.weatherapp.model;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientToSendRequest {
    private Localization localization;


    public String jsonFromHttpRequest(Localization localization) {
        String uri2 = new StringBuilder("http://api.weatherstack.com/current?access_key=3f4c60639ee881f4693cada28229a5e2&query=")
                .append(localization.getLatitude())
                .append(",")
                .append(localization.getLongitude())
                .toString();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").setHost("www.google.com").setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "");
        URI uri = builder.build();

        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());




        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri2))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.body().toString();
    }
}

