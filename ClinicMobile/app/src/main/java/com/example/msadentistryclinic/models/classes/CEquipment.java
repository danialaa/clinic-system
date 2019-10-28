package com.example.msadentistryclinic.models.classes;

public class CEquipment {
    protected int equipmentID, quantity, price;
    protected  boolean isAvailable;
    protected String type, name;

    public CEquipment(int equipmentID, int quantity, int price, boolean isAvailable, String type, String name) {
        this.equipmentID = equipmentID;
        this.quantity = quantity;
        this.price = price;
        this.isAvailable = isAvailable;
        this.type = type;
        this.name = name;
    }

    public CEquipment() {
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
