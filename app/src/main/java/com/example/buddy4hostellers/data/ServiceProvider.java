package com.example.buddy4hostellers.data;

public class ServiceProvider {

    private int userId;
    private String name;
    private String email;
    private String contact;
    private String[] extras;



    public ServiceProvider(int userId, String name, String email, String contact, String[] extras) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.extras = extras;
    }

    public ServiceProvider(){

    }

    public int getUserId() {
        return userId;
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

    public String[] getExtras() {
        return extras;
    }

    public void setExtras(String[] extras) {
        this.extras = extras;
    }


}
