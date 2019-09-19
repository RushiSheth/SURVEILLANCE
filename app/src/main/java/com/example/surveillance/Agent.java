package com.example.surveillance;

public class Agent {
    public String name;
    public String email;
    public String image;



    public String bloodgroup;
    public String medical;

    public Agent() {
    }

    public Agent(String name, String email, String image, String hb, String designation, String bloodgroup, String medical) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.hb = hb;
        this.designation = designation;
    }

    public String hb;
    public String designation;

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
    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }
}
