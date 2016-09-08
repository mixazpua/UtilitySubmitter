package com.example.mixazp.utilitysubmitter.model;

public class WaterDataModel {

    String mEmail;
    String mUtilites;
    String mUtilites2;
    String mDate;

    public WaterDataModel() {
    }

    public String getDate() {
        return mDate;
    }

    public String getUtilites2() {
        return mUtilites2;
    }

    public String getUtilites() {
        return mUtilites;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setUtilites2(String utilites2) {
        this.mUtilites2 = utilites2;
    }

    public void setUtilites(String utilites) {
        this.mUtilites = utilites;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public void setDate(String date) {
        this.mDate = date;
    }
}
