package com.example.surveillance;

public class Agent {
    public String name;
    public String email;
    public String image;
    public Double lat;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double lng;



    public String bloodgroup;
    public String medical;

    public Agent() {
    }

    public Agent(String name, String email, String image, String hb, String designation, String bloodgroup, String medical,Double lat,Double lng) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.hb = hb;
        this.designation = designation;
        this.bloodgroup = bloodgroup;
        this.medical = medical;
        this.lat = lat;
        this.lng = lng;
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
