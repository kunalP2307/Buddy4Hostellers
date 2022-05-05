package com.example.buddy4hostellers.data;

public class Amenities {

    int noOfBathrooms;
    int noOfBalconies;
    int noOfBeds;
    boolean[] otherAmenities;
    String description;

    public Amenities(){

    }

    public Amenities(int noOfBathrooms, int noOfBalconies, int noOfBeds, boolean[] otherAmenities, String description) {
        this.noOfBathrooms = noOfBathrooms;
        this.noOfBalconies = noOfBalconies;
        this.noOfBeds = noOfBeds;
        this.otherAmenities = otherAmenities;
        this.description = description;
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

    public boolean[] getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(boolean[] otherAmenities) {
        this.otherAmenities = otherAmenities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
