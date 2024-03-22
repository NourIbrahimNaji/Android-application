package com.example.finalproject_1190270_1190768;


public class User {
    // attributes
    private String user_email;
    private String fist_name;
    private String last_name;
    private String password;
    private String cpassword;
    private String ptdestinations;

    // constructor
    public User(String user_email, String fist_name, String last_name, String password, String cpassword, String ptdestinations) {
        this.user_email = user_email;
        this.fist_name = fist_name;
        this.last_name = last_name;
        this.password = password;
        this.cpassword = cpassword;
        this.ptdestinations = ptdestinations;
    }

    public User() {

    }

    // setters and getters
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getPtdestinations() {
        return ptdestinations;
    }

    public void setPtdestinations(String ptdestinations) {
        this.ptdestinations = ptdestinations;
    }
}

