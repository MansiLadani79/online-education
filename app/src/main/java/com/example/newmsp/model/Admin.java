package com.example.newmsp.model;

public class Admin {


    private  String Aid;
    private String Name;
    private String Email;
    private  String Password;
    private String PhoneNumber;
    private int Logintype;
    private String Medium;
    private String Standard;
    private String Address;
    private String Date;
    private String Assignment;


    public Admin() {

    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getLogintype() {
        return Logintype;
    }

    public void setLogintype(int logintype) {
        Logintype = logintype;
    }

    public String getMedium() {
        return Medium;
    }

    public void setMedium(String medium) {
        Medium = medium;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String standard) {
        Standard = standard;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAssignment() {
        return Assignment;
    }

    public void setAssignment(String assignment) {
        Assignment = assignment;
    }

    public Admin(String aid, String name, String email, String password, String phoneNumber, int logintype, String medium, String standard, String address, String date, String assignment) {
        Aid = aid;
        Name = name;
        Email = email;
        Password = password;
        PhoneNumber = phoneNumber;
        Logintype = logintype;
        Medium = medium;
        Standard = standard;
        Address = address;
        Date = date;
        Assignment = assignment;

    }
}


