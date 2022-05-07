package com.example.buddy4hostellers.data;

import java.io.Serializable;
import java.util.List;

public class ServiceProvider implements Serializable {

    private int userId;
    private String name;
    private String email;
    private String contact;
    private List<String> myPlaces;
    private List<String> myMesses;
    private List<String> extras;


    public ServiceProvider(int userId, String name, String email, String contact, List<String> myPlaces, List<String> myMesses, List<String> extras) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.myPlaces = myPlaces;
        this.myMesses = myMesses;
        this.extras = extras;
    }

    public ServiceProvider(){

    }

    public List<String> getMyPlaces() {
        return myPlaces;
    }

    public void setMyPlaces(List<String> myPlaces) {
        this.myPlaces = myPlaces;
    }

    public List<String> getMyMesses() {
        return myMesses;
    }

    public void setMyMesses(List<String> myMesses) {
        this.myMesses = myMesses;
    }

    public int getUserId() {
        return userId;
    }

    public List<String> getExtras() {
        return extras;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


}
