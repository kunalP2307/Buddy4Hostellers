package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class PlaceDetails implements Serializable {

    String heading;
    String roomType;
    String maxAllowed;
    boolean tenantType;
    String apartmentType;
    String apartmentName;
    String bhkType;
    int floor;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public PlaceDetails(String heading, String roomType, String maxAllowed, boolean tenantType, String apartmentType, String apartmentName, String bhkType, int floor) {
        this.heading = heading;
        this.roomType = roomType;
        this.maxAllowed = maxAllowed;
        this.tenantType = tenantType;
        this.apartmentType = apartmentType;
        this.apartmentName = apartmentName;
        this.bhkType = bhkType;
        this.floor = floor;
    }

    public PlaceDetails(){

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(String maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public boolean isTenantType() {
        return tenantType;
    }

    public void setTenantType(boolean tenantType) {
        this.tenantType = tenantType;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getBhkType() {
        return bhkType;
    }

    public void setBhkType(String bhkType) {
        this.bhkType = bhkType;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
