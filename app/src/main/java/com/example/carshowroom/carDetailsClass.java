package com.example.carshowroom;

import android.app.Application;

import java.util.ArrayList;

public class carDetailsClass extends Application {
    public static ArrayList<CARS> carsDetailClassArrayList;

    @Override
    public void onCreate() {
        super.onCreate();
        carsDetailClassArrayList = new ArrayList<>();
        carsDetailClassArrayList.add(new CARS("Amg GT R PRO","Mercedes","Rana WaQas", "03344398837"));
        carsDetailClassArrayList.add(new CARS("E250","Mercedes","Nabeel Shabir Khan Baloch", "03344398837"));
        carsDetailClassArrayList.add(new CARS("kicks","Nissan","Adnan Abid", "03344398837"));
        carsDetailClassArrayList.add(new CARS("GT-R","Nissan","Ahsan Farooq", "03344398837"));
        carsDetailClassArrayList.add(new CARS("BEETLE","Volkswagen","Mohsin Javeed", "03344398837"));
        carsDetailClassArrayList.add(new CARS("G CLASS","Mercedes","Hazeem Hassan", "03344398837"));
    }


}
