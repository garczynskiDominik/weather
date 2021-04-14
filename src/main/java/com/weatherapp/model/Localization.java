package com.weatherapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Localization {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    double latitude;
    double longitude;
    String name;
    String region;
    String country;
    @Transient
    String jsonWithInfo;
    @OneToMany(mappedBy = "localization")
    private List<Weather> weathers;

    public Localization() {
    }

    public Localization(double latitude, double longitude, String region, String country) {
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
        return "Miejscowość " + name + " { " +
                "id = " + id +
                ", współrzędne = " + latitude +
                ", " + longitude +
                ", region = " + region +
                ", kraj = " + country +
                " }";
    }
}
