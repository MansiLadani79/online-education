package com.example.newmsp.model;

public class MyItemsStudent {

    private  final String fullname,mobile,email;

    public MyItemsStudent(String fullname, String mobile, String email) {
        this.fullname = fullname;
        this.mobile = mobile;
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
