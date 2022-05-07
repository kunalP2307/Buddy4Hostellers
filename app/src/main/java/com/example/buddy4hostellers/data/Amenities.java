package com.example.buddy4hostellers.data;

import java.io.Serializable;
import java.util.List;

public class Amenities implements Serializable {

    int noOfBathrooms;
    int noOfBalconies;
    int noOfBeds;
    List<Boolean> otherAmenities;
    boolean friendsAllowed;
    String otherAmenitiesString;
    String description;

    public Amenities(int noOfBathrooms, int noOfBalconies, int noOfBeds, List<Boolean> otherAmenities, boolean friendsAllowed, String otherAmenitiesString, String description) {
        this.noOfBathrooms = noOfBathrooms;
        this.noOfBalconies = noOfBalconies;
        this.noOfBeds = noOfBeds;
        this.otherAmenities = otherAmenities;
        this.friendsAllowed = friendsAllowed;
        this.otherAmenitiesString = otherAmenitiesString;
        this.description = description;
    }

    public Amenities(){

    }

    public int getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public int getNoOfBalconies() {
        return noOfBalconies;
    }

    public void setNoOfBalconies(int noOfBalconies) {
        this.noOfBalconies = noOfBalconies;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public List<Boolean> getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(List<Boolean> otherAmenities) {
        this.otherAmenities = otherAmenities;
    }

    public boolean isFriendsAllowed() {
        return friendsAllowed;
    }

    public void setFriendsAllowed(boolean friendsAllowed) {
        this.friendsAllowed = friendsAllowed;
    }

    public String getOtherAmenitiesString() {
        return otherAmenitiesString;
    }

    public void setOtherAmenitiesString(String otherAmenitiesString) {
        this.otherAmenitiesString = otherAmenitiesString;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
