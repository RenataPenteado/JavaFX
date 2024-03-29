/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.litinow.hotelmanagement;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Renata
 */
public class Customers extends RecursiveTreeObject<Customers> {

    StringProperty id;
    StringProperty roomType;
    StringProperty roomNumber;
    StringProperty numberOfPeople;
    StringProperty floorNumber;
    StringProperty roomPhone;
    StringProperty roomPrice;
    StringProperty roomStatus;

    public Customers() {
        super();
    }

    public Customers(String id, String roomType, String roomNumber, String numberOfPeople, String floorNumber, String roomPhone, String roomPrice, String roomStatus) {
        this.id = new SimpleStringProperty(id);
        this.roomType = new SimpleStringProperty(roomType);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.numberOfPeople = new SimpleStringProperty(numberOfPeople);
        this.floorNumber = new SimpleStringProperty(floorNumber);
        this.roomPhone = new SimpleStringProperty(roomPhone);
        this.roomPrice = new SimpleStringProperty(roomPrice);
        this.roomStatus = new SimpleStringProperty(roomStatus);
    }

}
