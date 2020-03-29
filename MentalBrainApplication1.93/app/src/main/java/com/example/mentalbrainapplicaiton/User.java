package com.example.mentalbrainapplicaiton;

/**
 * User class for the purpose of keeping track of user information within Database
 */
public class User {

    private String username;
    private String email;
    private String password;
    private Integer experience;


    /**
     * Constructor method for User object
     */
    public User() {
    }


    /**
     * Method to set username attribute of User object.
     * @param username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method to set email attribute of User object.
     * @param email to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to set password attribute of User object.
     * @param password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to set experience attribute of User object.
     * @param experience
     */
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /**
     * Method to return username attribute of User object.
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method to return email attribute of User object.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to return password attribute of User object.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to return experience attribute of User object.
     * @return experience
     */
    public Integer getExperience() {
        return experience;
    }


    /**
     * Constructor for User object, takes the following parameters;
     * @param username - Users chosen name
     * @param email - Users email
     * @param password - Users password
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.experience = 0;
    }
}