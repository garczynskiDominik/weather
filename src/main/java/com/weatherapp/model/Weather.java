package com.weatherapp.model;

import javax.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    double temperature;
    int pressure;
    int humidity;
    String windDirection;
    int windSpeed;

    @ManyToOne
    @JoinColumn(name = "localization_id")
    private Localization localization;

    public Weather() {
    }

    public Weather(double temperature, int pressure, int humidity, String windDirection, int windSpeed) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "temperatura = " + temperature + "\u00B0" + "C" +
                ", ciśnienie = " + pressure + "hPa" +
                ", wilgotność = " + humidity + "%" +
                ", kierunek wiatru = " + windDirection +
                ", prędkość wiatru = " + windSpeed + "km/h";
    }
}
