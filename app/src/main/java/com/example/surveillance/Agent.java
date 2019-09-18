package com.example.surveillance;

public class Agent {
    private String name;
    private String email;
    private String image;

    public Agent() {
    }

    public Agent(String name, String email, String image, String hb, String designation) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.hb = hb;
        this.designation = designation;
    }

    private String hb;
    private String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
