package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class NearbyCollege implements Serializable {

    private String nearByCollege;
    private double distanceFromCollege;

    public NearbyCollege(){

    }

    public NearbyCollege(String nearByCollege, double distanceFromCollege) {
        this.nearByCollege = nearByCollege;
        this.distanceFromCollege = distanceFromCollege;
    }

    public String getNearByCollege() {
        return nearByCollege;
    }

    public void setNearByCollege(String nearByCollege) {
        this.nearByCollege = nearByCollege;
    }

    public double getDistanceFromCollege() {
        return distanceFromCollege;
    }

    public void setDistanceFromCollege(double distanceFromCollege) {
        this.distanceFromCollege = distanceFromCollege;
    }

}
