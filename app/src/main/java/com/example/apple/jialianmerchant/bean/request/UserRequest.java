package com.example.apple.jialianmerchant.bean.request;


public class UserRequest {
    private String UserName;
    private String Password;

    public UserRequest(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
