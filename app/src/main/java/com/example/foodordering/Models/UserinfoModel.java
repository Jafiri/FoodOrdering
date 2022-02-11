package com.example.foodordering.Models;

public class UserinfoModel {

   public String username,email,password,mobile,address,userid;

    public void setAddress(String address) {
        this.address = address;
    }

    public UserinfoModel(String username, String email, String password, String mobile, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
    }

    public UserinfoModel() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
