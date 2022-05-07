package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class LocalityDetails implements Serializable {

    String area;
    String street;
    String landMark;
    double latitude;
    double longitude;

    public LocalityDetails(String area, String street, String landMark, double latitude, double longitude) {
        this.area = area;
        this.street = street;
        this.landMark = landMark;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
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
}
