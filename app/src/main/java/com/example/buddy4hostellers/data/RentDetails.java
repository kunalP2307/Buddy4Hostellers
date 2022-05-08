package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class RentDetails implements Serializable {

    double rent;
    boolean negotiable;
    double deposit;
    double maintenance;
    String furnishing;

    RentDetails(){

    }



    public RentDetails(double rent, boolean negotiable, double deposit, double maintenance, String furnishing) {
        this.rent = rent;
        this.negotiable = negotiable;
        this.deposit = deposit;
        this.maintenance = maintenance;
        this.furnishing = furnishing;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public boolean isNegotiable() {
        return negotiable;
    }

    public void setNegotiable(boolean negotiable) {
        this.negotiable = negotiable;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }
}
