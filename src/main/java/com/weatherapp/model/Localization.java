package com.weatherapp.model;

public class Localization {
    private static long id = 1;
    double latitude;
    double longitude;
    String region;
    String country;
    String jsonWithInfo;

    public Localization() {
        id++;
    }

    public Localization(double latitude, double longitude, String region, String country) {
        id++;
        this.latitude = latitude;
        this.longitude = longitude;
        this.region = region;
        this.country = country;
    }

    public String getJsonWithInfo() {
        return jsonWithInfo;
    }

    public void setJsonWithInfo(String jsonWithInfo) {
        this.jsonWithInfo = jsonWithInfo;
    }

    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Lokalizacja{" +
                "id=" + id +
                ", współrzędne=" + latitude +
                ", " + longitude +
                ", region='" + region + '\'' +
                ", kraj='" + country + '\'' +
                '}';
    }
}
