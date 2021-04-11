package com.weatherapp.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MapperJsonToWeather {
    private Weather weather;


    public Weather getWeatherObject() {
        String myJSONString = ",\"temperature\":18,\"weather_code\":113,\"weather_icons\":[\"https:\\/\\/assets.weatherstack.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\"],\"weather_descriptions\":[\"Sunny\"],\"wind_speed\":22,\"wind_degree\":210,\"wind_dir\":\"SSW\",\"pressure\":1017,\"precip\":0,\"humidity\":30,\"cloudcover\":0,\"feelslike\":18,\"uv_index\":4,\"visibility\":10,\"is_day\":\"yes\"}}";
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);

        JsonObject current = jobj.get("current").getAsJsonObject();

        Weather weather = new Weather();
        weather.setTemperature(current.get("temperature").getAsDouble());
        weather.setHumidity(current.get("humidity").getAsInt());
        weather.setPressure(current.get("pressure").getAsInt());
        weather.setWindDirection(current.get("wind_dir").getAsString());
        weather.setWindSpeed(current.get("wind_speed").getAsInt());
        return weather;
    }


}
