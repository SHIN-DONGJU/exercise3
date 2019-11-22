package com.example.exercise.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MapPoint2 {
    private String Name;
    private double latitude;
    private double longitude;

    public MapPoint2(){
        super();
    }

    public MapPoint2(String Name, double latitude, double longitude){
        this.Name=Name;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name=Name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude (double latitude){
        this.latitude =latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude (double longitude){
        this.longitude =longitude;
    }

}
