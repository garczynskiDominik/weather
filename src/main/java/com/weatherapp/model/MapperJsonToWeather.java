package com.weatherapp.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MapperJsonToWeather {
    private Weather weather;


    public Weather getWeatherObject() {
        String myJSONString = "{\"request\":{\"type\":\"City\",\"query\":\"Lublin, Poland\",\"language\":\"en\",\"unit\":\"m\"},\"location\":{\"name\":\"Lublin\",\"country\":\"Poland\",\"region\":\"\",\"lat\":\"51.250\",\"lon\":\"22.567\",\"timezone_id\":\"Europe\\/Warsaw\",\"localtime\":\"2021-04-10 14:49\",\"localtime_epoch\":1618066140,\"utc_offset\":\"2.0\"},\"current\":{\"observation_time\":\"12:49 PM\",\"temperature\":18,\"weather_code\":113,\"weather_icons\":[\"https:\\/\\/assets.weatherstack.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\"],\"weather_descriptions\":[\"Sunny\"],\"wind_speed\":22,\"wind_degree\":210,\"wind_dir\":\"SSW\",\"pressure\":1017,\"precip\":0,\"humidity\":30,\"cloudcover\":0,\"feelslike\":18,\"uv_index\":4,\"visibility\":10,\"is_day\":\"yes\"}}";
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
