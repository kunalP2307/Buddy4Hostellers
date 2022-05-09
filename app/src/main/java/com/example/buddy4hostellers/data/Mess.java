package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class Mess implements Serializable {

    String messId;
    ServiceProviderContactDetails serviceProviderContactDetails;
    NearbyCollege nearbyCollege;
    LocalityDetails localityDetails;
    String messName;
    String foodType;

    public String getMessId() {
        return messId;
    }

    public void setMessId(String messId) {
        this.messId = messId;
    }

    public ServiceProviderContactDetails getServiceProviderContactDetails() {
        return serviceProviderContactDetails;
    }

    public void setServiceProviderContactDetails(ServiceProviderContactDetails serviceProviderContactDetails) {
        this.serviceProviderContactDetails = serviceProviderContactDetails;
    }

    public NearbyCollege getNearbyCollege() {
        return nearbyCollege;
    }

    public void setNearbyCollege(NearbyCollege nearbyCollege) {
        this.nearbyCollege = nearbyCollege;
    }

    public LocalityDetails getLocalityDetails() {
        return localityDetails;
    }

    public void setLocalityDetails(LocalityDetails localityDetails) {
        this.localityDetails = localityDetails;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Mess(String messId, ServiceProviderContactDetails serviceProviderContactDetails, NearbyCollege nearbyCollege, LocalityDetails localityDetails, String messName, String foodType) {
        this.messId = messId;
        this.serviceProviderContactDetails = serviceProviderContactDetails;
        this.nearbyCollege = nearbyCollege;
        this.localityDetails = localityDetails;
        this.messName = messName;
        this.foodType = foodType;
    }
}
