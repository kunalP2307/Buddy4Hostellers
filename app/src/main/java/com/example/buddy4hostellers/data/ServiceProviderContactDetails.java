package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class ServiceProviderContactDetails implements Serializable {

    private String name;
    private String contact;

    public ServiceProviderContactDetails(){

    }

    public ServiceProviderContactDetails(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
