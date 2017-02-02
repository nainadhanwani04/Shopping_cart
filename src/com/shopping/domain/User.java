package com.shopping.domain;

/**
 * Created by nainadhanwani on 1/25/17.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public static User createUser(int id, String userName, String firstName, String lastName, String address) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        return user;
    }

    public static User updateUser(String userName,int id)
    {
        User user = new User();
        user.setId(id);
        user.setUserName("Naina");
        return user;
    }
    }
