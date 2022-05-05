package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class LivingPlace implements Serializable {

    String placeId;
    NearbyCollege nearbyCollege;
    PlaceDetails placeDetails;
    RentDetails rentDetails;
    LocalityDetails localityDetails;
    Amenities amenities;
    InterestedStudents interestedStudents;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public NearbyCollege getNearbyCollege() {
        return nearbyCollege;
    }

    public void setNearbyCollege(NearbyCollege nearbyCollege) {
        this.nearbyCollege = nearbyCollege;
    }

    public PlaceDetails getPlaceDetails() {
        return placeDetails;
    }

    public void setPlaceDetails(PlaceDetails placeDetails) {
        this.placeDetails = placeDetails;
    }

    public RentDetails getRentDetails() {
        return rentDetails;
    }

    public void setRentDetails(RentDetails rentDetails) {
        this.rentDetails = rentDetails;
    }

    public LocalityDetails getLocalityDetails() {
        return localityDetails;
    }

    public void setLocalityDetails(LocalityDetails localityDetails) {
        this.localityDetails = localityDetails;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public InterestedStudents getInterestedStudents() {
        return interestedStudents;
    }

    public void setInterestedStudents(InterestedStudents interestedStudents) {
        this.interestedStudents = interestedStudents;
    }
}
