package com.example.carshowroom;

public class CARS {
     String carModel;
     String Maker;
     String ownerName;
     String ownerNumber;

    public CARS(String carModel, String maker, String ownerName, String ownerNumber) {
        this.carModel = carModel;
        this.Maker = maker;
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getMaker() {
        return Maker;
    }

    public void setMaker(String maker) {
        Maker = maker;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }
}
