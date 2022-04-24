package com.example.buddy4hostellers.data;

import java.io.Serializable;

public class Student implements Serializable {

    private int userId;
    private String name;
    private String email;
    private String contact;

    private String collegeName;
    private String yearOfStudy;
    private String branchOfStudy;
    private boolean gender;

    public Student(){

    }

    public Student(int userId, String name, String email, String contact, String collegeName, String yearOfStudy, String branchOfStudy, boolean gender) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.collegeName = collegeName;
        this.yearOfStudy = yearOfStudy;
        this.branchOfStudy = branchOfStudy;
        this.gender = gender;
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

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getBranchOfStudy() {
        return branchOfStudy;
    }

    public void setBranchOfStudy(String branchOfStudy) {
        this.branchOfStudy = branchOfStudy;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
}
