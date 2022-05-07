package com.example.buddy4hostellers.data;

import java.io.Serializable;
import java.util.ArrayList;

public class LivingPlace implements Serializable {

    String placeId;
    NearbyCollege nearbyCollege;
    PlaceDetails placeDetails;
    RentDetails rentDetails;
    LocalityDetails localityDetails;
    Amenities amenities;
    String imageReference;
    InterestedStudents interestedStudents[];

    public LivingPlace(){

    }

    public LivingPlace(String placeId, NearbyCollege nearbyCollege, PlaceDetails placeDetails, RentDetails rentDetails, LocalityDetails localityDetails, Amenities amenities, String imageReference, InterestedStudents[] interestedStudents) {
        this.placeId = placeId;
        this.nearbyCollege = nearbyCollege;
        this.placeDetails = placeDetails;
        this.rentDetails = rentDetails;
        this.localityDetails = localityDetails;
        this.amenities = amenities;
        this.imageReference = imageReference;
        this.interestedStudents = interestedStudents;
    }

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

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    public InterestedStudents[] getInterestedStudents() {
        return interestedStudents;
    }

    public void setInterestedStudents(InterestedStudents[] interestedStudents) {
        this.interestedStudents = interestedStudents;
    }

}
