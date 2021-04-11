package com.weatherapp.model;

public class Localization {
    private static long idCounter = 1;
    long id;
    double latitude;
    double longitude;
    String name;
    String region;
    String country;
    String jsonWithInfo;

    public Localization() {
        this.id = idCounter++;
    }

    public Localization(double latitude, double longitude, String region, String country) {
        this.id = idCounter++;
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

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
