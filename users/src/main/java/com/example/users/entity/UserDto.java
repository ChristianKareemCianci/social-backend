package com.example.users.entity;


public class UserDto {

    private int id;
    private String email;
    private String password;

    public UserDto() {

    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDto( String email, String password,int id) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void setId() {
        this.id = id;
    }
    public int getId() {
        return id;
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

}

