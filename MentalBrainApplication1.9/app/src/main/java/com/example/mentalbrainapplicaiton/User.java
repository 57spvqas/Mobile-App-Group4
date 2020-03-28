package com.example.mentalbrainapplicaiton;

/**
 * User class for the purpose of keeping track of user information within Database
 */
public class User {

    private String username;
    private String email;
    private String password;
    private Integer experience;


    public User() {
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getExperience() {
        return experience;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.experience = 0;
    }
}