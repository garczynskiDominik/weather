package com.weatherapp.connection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weatherapp.model.Localization;
import com.weatherapp.model.Weather;

public class MapperJsonToWeather {
    private Weather weather;


    public Weather getWeatherObject(Localization localization) {
        String myJSONString = localization.getJsonWithInfo();
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
