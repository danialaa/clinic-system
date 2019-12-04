package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.EquipmentType;

public class M_Equipment {
    private String name;
    private EquipmentType equipmentType;
    private int price, id, quantity;
    private boolean isAvailable;

    public M_Equipment(String name, EquipmentType equipmentType, int price, int id, int quantity, boolean isAvailable) {
        this.name = name;
        this.equipmentType = equipmentType;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }

    public M_Equipment() {
    }

    public int addEquipment() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        int available;

        if(this.isAvailable) {
            available = 1;
        } else {
            available = 0;
        }

        return databaseConnection.insertInto("equipment", "(Equipment_IsAvailable, Equipment_Name, Equipment_Price, " +
                "Equipment_Quantity, Equipment_Type)", "('" + available + "', '" + this.name + "', '" + this.price +
                "', '" + this.quantity + "', '" + this.equipmentType.getName() + "')");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
