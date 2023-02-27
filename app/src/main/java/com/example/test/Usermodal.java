package com.example.test;

public class Usermodal {
    private String firstName;
    private String surname;
    private String iDNo;
    private String phoneNo;
    private int id;

    // creating getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIDNo() {
        return iDNo;
    }

    public void setIDNo(String courseTracks) {
        this.iDNo = iDNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public Usermodal(String firstName, String surname, String iDNo, String phoneNo) {
        this.firstName = firstName;
        this.surname = surname;
        this.iDNo = iDNo;
        this.phoneNo = phoneNo;
    }
}

